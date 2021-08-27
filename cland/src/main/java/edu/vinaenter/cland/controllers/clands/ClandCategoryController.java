package edu.vinaenter.cland.controllers.clands;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.vinaenter.cland.dto.LandDTO;
import edu.vinaenter.cland.models.Category;
import edu.vinaenter.cland.services.CategoryService;
import edu.vinaenter.cland.services.LandService;

@Controller
public class ClandCategoryController extends ClandAbstractController {

	@Autowired
	private LandService landService;

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/cat/{cid}", method = RequestMethod.GET)
	public String single(@PathVariable Integer cid, Model model) {
		List<LandDTO> listLandDTO = landService.findOfCat(cid);
		Category listCategory = categoryService.findOne(cid);
		String cname = listCategory.getCname();
		
		model.addAttribute("listLandDTO", listLandDTO);
		model.addAttribute("cname", cname);
		return "cland.cat";
	}

}
