package edu.vinaenter.cland.controllers.clands;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.cland.constants.GlobalsConstant;
import edu.vinaenter.cland.models.Contact;
import edu.vinaenter.cland.services.ContactService;

@Controller
public class ClandContactController extends ClandAbstractController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/contact")
	public String contact() {
		return "cland.contact";
	}
	
	@PostMapping("/contact")
	public String contact(@Valid @ModelAttribute("contact") Contact contact, BindingResult rs,
			RedirectAttributes rd) {
		if (rs.hasErrors()) {
			return "cland.contact";
		}
		if (contactService.add(contact) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
			System.out.println("OK");
		} else {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("erorr", null, Locale.getDefault()));
			System.out.println(" k OK");
		}
		return "redirect:/contact";
	}
}
