package edu.vinaenter.cland.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	@GetMapping("error403")
	public String login() {
		return "auth.error403";
	}

}
