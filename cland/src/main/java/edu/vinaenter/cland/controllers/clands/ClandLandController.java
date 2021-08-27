package edu.vinaenter.cland.controllers.clands;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.vinaenter.cland.constants.GlobalsConstant;
import edu.vinaenter.cland.models.Land;
import edu.vinaenter.cland.services.LandService;
import edu.vinaenter.cland.validator.PaginationUtils;

@Controller
public class ClandLandController extends ClandAbstractController {
	
	@Autowired
	private LandService landService;
	
	@RequestMapping(value= {"/index","index/{page}"}, method = RequestMethod.GET)
	public String index(@PathVariable(required = false, name = "page") Integer page ,Model model) {
		// CurrentPage
		if (page == null) {
			page = 1;
		}
		// Get Offset
		int offset = PaginationUtils.getOffset(page);
		List<Land> landList = landService.findAllByStatus(offset, GlobalsConstant.LIMIT_PAGE);
		/* List<Land> landList = landService.findAll(); */
		
		//Paginate
		int totalRow = landService.totalRow();
		int totalPage = (int) Math.ceil((float) totalRow / GlobalsConstant.LIMIT_PAGE);
				
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("landList", landList);
		return "cland.index";
	}
	
	@PostMapping("index")
	public String index(@RequestParam("search") String search, Model model) {
		if (!"".equals(search)) {
			List<Land> listSearch = landService.searchLand(search);	
			model.addAttribute("listSearch", listSearch);
			model.addAttribute("search", search);
			return "cland.index";
		}
		return "redirect:/index";
	}
	
	@GetMapping("search")
	public String search() {
		return "cland.search";		
	}
	@GetMapping("maps")
	public String maps() {
		return "cland.maps";
	}	
}
