package edu.vinaenter.cland.controllers.admins;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.cland.constants.GlobalsConstant;
import edu.vinaenter.cland.models.Category;
import edu.vinaenter.cland.models.Land;
import edu.vinaenter.cland.services.CategoryService;
import edu.vinaenter.cland.services.LandService;
import edu.vinaenter.cland.validator.PaginationUtils;

@Controller
@RequestMapping("admin/cat")
public class AdminCategoryController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private LandService landService;

	@GetMapping({"index","index/{page}"})
	public String index(Model model, @PathVariable(required = false,name = "page") Integer page) {
		if(page == null) {
			page = 1;
		}
		// GET OFFSET
		int offset = PaginationUtils.getOffset(page);
		List<Category> categoryList = categoryService.findAll(offset, GlobalsConstant.LIMIT_PAGE);
		
		// PAGINATION
		int numberOfCat = categoryService.countCat();
		int totalPage = (int) Math.ceil((float)numberOfCat/GlobalsConstant.LIMIT_PAGE);
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("landService", landService);
		
		return "admin.cat.index";
	}

	@GetMapping("add")
	public String add(Model model) {
		return "admin.cat.add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("cat") Category cat,
			BindingResult rs,
			RedirectAttributes rd) {
		if(rs.hasErrors()) {
			return "admin.cat.add";
		}
		if (categoryService.add(cat) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
		rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("error", null, Locale.getDefault()));
		return "admin.cat.add";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id,ModelMap modelMap) {
		try {
			Category cat = categoryService.findOne(id);
			modelMap.addAttribute("cat", cat);
		} catch (Exception e) {
			return "redirect:/admin/cat/index";
		}
		return "admin.cat.edit";
	}
	
	@PostMapping("edit/{id}")
	public String edit(@Parameter String cname,@PathVariable int id,
			RedirectAttributes rd) {
		Category cat = new Category(id, cname);
		if (categoryService.edit(cat) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success",null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
		rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("error",null, Locale.getDefault()));
		return "admin.cat.edit";
	}
	
	@GetMapping("del/{id}")
	public String edit(@PathVariable int id, RedirectAttributes rd) {
		try {
			categoryService.del(id);
			landService.delCid(id);
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success",null, Locale.getDefault()));
		} catch (Exception e) {
		}
		return "redirect:/admin/cat/index";
	}
	
	@PostMapping("index")
	public String index(@RequestParam("searchCat") String searchCat, Model model) {
		if (!"".equals(searchCat)) {
			List<Category> listSearch_Cat = categoryService.searchCat(searchCat);
			model.addAttribute("listSearch_Cat", listSearch_Cat);
			model.addAttribute("searchCat", searchCat);
			return "admin.cat.index";
		}
		return "redirect:/admin/cat/index";
	}
	
	@GetMapping("search")
	public String search() {
		return "admin.search";		
	}
}
