package edu.vinaenter.cland.controllers.clands;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.vinaenter.cland.constants.GlobalsConstant;
import edu.vinaenter.cland.dto.LandDTO;
import edu.vinaenter.cland.services.LandService;

@Controller
public class ClandSingleController extends ClandAbstractController{
	
	@Autowired
	private LandService landService;
	
	@RequestMapping(value="/single/{lid}", method = RequestMethod.GET)
	public String single(@PathVariable Integer lid, Model model, HttpSession session) {
		
		// Tăng views
		String hasVisited = (String) session.getAttribute("hasVisited" + lid);
		if (hasVisited == null) {
			session.setAttribute("hasVisited :"+lid, "yes");
			session.setMaxInactiveInterval(3600);
			// Tăng view
			landService.increaseView(lid);
		}
		// Tin chi tiet
		LandDTO landDTO = landService.findSingle(lid);
		
		// Tin lien quan
		List<LandDTO> landRelated = landService.findRelated(landDTO,GlobalsConstant.LIMIT_RELATED);
		System.out.println(landDTO.getCid());
		System.out.println(landDTO.getLid());
		
		model.addAttribute("landRelated", landRelated);
		model.addAttribute("landDTO", landDTO);
		return "cland.single";
	}

}
