package edu.vinaenter.cland.controllers.admins;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.cland.constants.GlobalsConstant;
import edu.vinaenter.cland.models.User;
import edu.vinaenter.cland.services.UserService;
import edu.vinaenter.cland.utils.StringUtils;
import edu.vinaenter.cland.validator.PaginationUtils;

@Controller
@RequestMapping("admin/user")
public class AdminUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = {"/index","/index/{page}"}, method = RequestMethod.GET)
	public String index(Model model,@PathVariable(required = false, name = "page") Integer page) {
		if(page == null) {
			page = 1;
		}
		// GET OFFSET
		int offset = PaginationUtils.getOffset(page);
		List<User> listUser = userService.findAll(offset, GlobalsConstant.LIMIT_PAGE);
		// PAGINATION
		int numberOfUser = userService.countUser();
		int totalPage = (int) Math.ceil((float) numberOfUser / GlobalsConstant.LIMIT_PAGE);
		
		model.addAttribute("listUser", listUser);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPage", totalPage);
		
		return "admin.user.index";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, ModelMap modelMap) {
		try {
			User user = userService.findOne(id);
			modelMap.addAttribute("user", user);
		} catch (Exception e) {
			return "redirect:/admin/user/index";
		}
		return "admin.user.edit";
	}

	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("user") User user,BindingResult rs,
			@PathVariable("id") int id,@RequestParam("passWord") String passWord, RedirectAttributes rd, ModelMap modelMap) {
		if (rs.hasErrors()) {
			return "admin.user.edit";
		}
		String password = bCryptPasswordEncoder.encode(passWord);
		//String password = StringUtils.md5(passWord);
		user.setPassWord(password);
		if (userService.edit(user, id) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
		} else {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("error", null, Locale.getDefault()));
		}
		return "redirect:/admin/user/index";

	}

	@GetMapping("del/{id}")
	public String del(@PathVariable int id, RedirectAttributes rd) {
		try {
			userService.del(id);
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
		} catch (Exception e) {
		}
		return "redirect:/admin/user/index";
	}

	@GetMapping("add")
	public String add() {
		return "admin.user.add";

	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("user") User user, BindingResult rs,
			@RequestParam("passWord") String passWord,
			RedirectAttributes rd,
			@RequestParam("level") String level) throws NoSuchAlgorithmException {
		if (rs.hasErrors()) {
			return "admin.user.add";
		}
		int roleId = 2;
		if ("admin".equals(level)) {
			roleId = 1;
			user.setAuthorization("Quản trị viên");
		} else {
			roleId = 2;
			user.setAuthorization("Người dùng");
		}
		System.out.println(roleId);
		String password = bCryptPasswordEncoder.encode(passWord);
//		String password = StringUtils.md5(passWord);
		System.out.println("Day là mk"+password);
		user.setPassWord(password);
		if (userService.add(user,roleId) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
		} else {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("error", null, Locale.getDefault()));
		}
		return "redirect:/admin/user/index";
	}
}
