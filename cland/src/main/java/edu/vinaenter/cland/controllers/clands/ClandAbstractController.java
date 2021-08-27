package edu.vinaenter.cland.controllers.clands;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.vinaenter.cland.models.Category;
import edu.vinaenter.cland.models.Land;
import edu.vinaenter.cland.services.CategoryService;
import edu.vinaenter.cland.services.LandService;

public abstract class ClandAbstractController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private LandService landService;

	@ModelAttribute
	public void addCommonobjects(Model model) {
		List<Category> categories = categoryService.findAll();
		// Land Hot
		List<Land> landHot = landService.findLandHot();
		// Dem tin
		model.addAttribute("categories", categories);
		model.addAttribute("landHot", landHot);
		model.addAttribute("landService", landService);
	}

}
