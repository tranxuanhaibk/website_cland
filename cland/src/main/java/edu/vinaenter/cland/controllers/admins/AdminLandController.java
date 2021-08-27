package edu.vinaenter.cland.controllers.admins;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.cland.constants.GlobalsConstant;
import edu.vinaenter.cland.dto.LandDTO;
import edu.vinaenter.cland.models.Category;
import edu.vinaenter.cland.models.Land;
import edu.vinaenter.cland.services.CategoryService;
import edu.vinaenter.cland.services.LandService;
import edu.vinaenter.cland.utils.FileUitl;
import edu.vinaenter.cland.validator.PaginationUtils;

@Controller
@RequestMapping("admin/land")
public class AdminLandController {

	@Autowired
	private LandService landService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/index", "/index/{page}" }, method = RequestMethod.GET)
	public String news(Model model, @PathVariable(required = false, name = "page") Integer page) {
		// paginate
		int totalPage = (int) Math.ceil((float) landService.totalRow() / GlobalsConstant.LIMIT_PAGE);
		
		// Current Page
		if (page == null || page > totalPage || page < 1) {
			page = 1;
		}
		// Get offset = (currentPage - 1) * row_Count
		int offset = PaginationUtils.getOffset(page);
		List<Land> landList = landService.findAll(offset, GlobalsConstant.LIMIT_PAGE);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("landList", landList);
		return "admin.land.index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		String fileAnh = FileUitl.rename("ssadasdwqeq.jpg");
		System.out.println(fileAnh);
		return "admin.login";
	}

	@GetMapping("add")
	public String add(Model model) {
		List<Category> catList = categoryService.findAll();
		model.addAttribute("catList", catList);
		return "admin.land.add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("land") Land land, BindingResult rs,
			@RequestParam("hinhanh") MultipartFile picture, @RequestParam("cid") int cid, HttpServletRequest request,
			RedirectAttributes rd, Model model) throws IllegalStateException, IOException {
		if (rs.hasErrors()) {
			List<Category> catList = categoryService.findAll();
			model.addAttribute("catList", catList);
			return "admin.land.add";
		}
		String fileName = FileUitl.upload(picture, request);
		land.setPicture(fileName);
		land.setCategory(new Category(cid, null));
		if (landService.add(land) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		} else {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("error", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		}
	}

	@RequestMapping(value = "del/{landId}", method = RequestMethod.GET)
	public String del(@PathVariable Integer landId, HttpServletRequest request, RedirectAttributes rd) {
		System.out.println(landId);
		// Neu co anh thi xoa
		LandDTO landDTO = landService.findOne(landId);
		String oldPicture = landDTO.getPicture();
		FileUitl.del(oldPicture, request);
		if (landService.del(landId) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
		} else {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("error", null, Locale.getDefault()));
		}
		return "redirect:/admin/land/index";
	}

	@GetMapping("edit/{landId}")
	public String edit(@PathVariable int landId, ModelMap modelMap) {
		List<Category> catList = categoryService.findAll();
		LandDTO landDTO = landService.findOne(landId);
		Category cat = categoryService.findCid(landId);
		
		modelMap.addAttribute("catList", catList);
		modelMap.addAttribute("cat", cat);
		modelMap.addAttribute("landDTO", landDTO);
		return "admin.land.edit";
	}

	@PostMapping("edit/{landId}")
	public String edit(@Valid @ModelAttribute("land") Land land, BindingResult rs,@PathVariable("landId") int landId,
			@RequestParam("hinhanh") MultipartFile picture, RedirectAttributes rd, @RequestParam("cid") int cid,
			Model model, HttpServletRequest request) throws IllegalStateException, IOException {
		if (rs.hasErrors()) {
			List<Category> catList = categoryService.findAll();
			model.addAttribute("catList", catList);
			return "admin.land.edit";
		}
		LandDTO landDTO = landService.findOne(landId);
		String oldPic = landDTO.getPicture();
		String fileName = oldPic;
		if (!"".equals(picture.getOriginalFilename())) {
			// Xoa anh
			FileUitl.del(oldPic, request);
			// add anh
			fileName = FileUitl.upload(picture, request);
		}
		land.setLid(landId);
		land.setPicture(fileName);
		land.setCategory(new Category(cid, null));
		if (landService.edit(land) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		} else {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("error", null, Locale.getDefault()));
			return "redirect:/admin/land/edit";
		}
	}
	
	@PostMapping("status")
	@ResponseBody
	public String status(@RequestParam int aid) {
		System.out.println(aid);
		int status = landService.status(aid);
		System.out.println(status);
		String text = "";
		if(status == 1) {
			landService.UpdateStatus(0, aid);
			text = "Không";
		} else if(status == 0) {
			landService.UpdateStatus(1, aid);
			text = "Có";
		}
		System.out.println(text);
		return text;
	}
}
