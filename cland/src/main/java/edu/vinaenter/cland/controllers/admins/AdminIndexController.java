package edu.vinaenter.cland.controllers.admins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.vinaenter.cland.services.CategoryService;
import edu.vinaenter.cland.services.LandService;
import edu.vinaenter.cland.services.UserService;

@Controller
@RequestMapping("admin")
public class AdminIndexController {
	
	@Autowired
	private LandService landService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		
		int numberOfCat = categoryService.countCat();
		int numberOfLand = landService.totalRow();
		int numberOfUser = userService.countUser();
		
		model.addAttribute("numberOfCat", numberOfCat);
		model.addAttribute("numberOfLand", numberOfLand);
		model.addAttribute("numberOfUser", numberOfUser);
		
		return "admin.index";
	}
	

}
