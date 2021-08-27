package edu.vinaenter.cland.controllers.admins;

import java.util.List;
import java.util.Locale;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.cland.constants.GlobalsConstant;
import edu.vinaenter.cland.models.Contact;
import edu.vinaenter.cland.services.ContactService;
import edu.vinaenter.cland.validator.PaginationUtils;

@Controller
@RequestMapping("admin/contact")
public class AdminContactController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping({"index","index/{page}"})
	public String index(Model model, @PathVariable(required = false,name = "page") Integer page) {
		if (page == null) {
			page = 1;
		}
		// GET OFFSET = (CURRENTPAGE - 1) * rowCount
		int offset = PaginationUtils.getOffset(page);
		List<Contact> listContact = contactService.findAll(offset, GlobalsConstant.LIMIT_PAGE);
		
		// PAGINATION
		int numberOfContact = contactService.countContact();
		int totalPage = (int) Math.ceil( (float) numberOfContact / GlobalsConstant.LIMIT_PAGE);
		model.addAttribute("listContact", listContact);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPage", totalPage);
		return "admin.contact.index";
	}
	
	@GetMapping("add")
	public String add() {
		return "admin.contact.add";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("contact") Contact contact, BindingResult rs, RedirectAttributes rd) {
		if (rs.hasErrors()) {
			return "admin.contact.edit";
		}
		if (contactService.add(contact) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
		} else {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("error", null, Locale.getDefault()));
		}
		return "redirect:/admin/contact/index";
	}
	
	@GetMapping("edit/{cid}")
	public String edit(@PathVariable int cid, ModelMap modelMap) {
		Contact contact = contactService.findOne(cid);
		modelMap.addAttribute("contact", contact);
		return "admin.contact.edit";
	}
	
	@PostMapping("edit/{cid}")
	public String edit(@Valid @ModelAttribute("contact") Contact contact, BindingResult rs,
			@PathVariable int cid, RedirectAttributes rd, ModelMap modelMap) {
		if (rs.hasErrors()) {
			return "admin.contact.edit";
		}
		if (contactService.edit(contact, cid) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
		} else {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("error", null, Locale.getDefault()));
		}
		System.out.println(contactService.edit(contact, cid));
		return "redirect:/admin/contact/index";
	}
	
	@GetMapping("del/{cid}")
	public String del(@PathVariable int cid, RedirectAttributes rd) {
		if (contactService.del(cid) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
		}
		return "redirect:/admin/contact/index";
	}

}
