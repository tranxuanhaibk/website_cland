package edu.vinaenter.cland.controllers.auths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class LoginController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("login")
	public String login() {
		System.out.println(bCryptPasswordEncoder.encode("123456"));
		return "auth.login";
	}

}
