package com.example.myFirstWebApp.login;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
//	@Autowired
//	private AuthenticateService authenticateService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(ModelMap model) {
		LOG.info("From login method");
		model.put("name", getUserName());
		return "welcome";
	}
	
	
	public String getUserName() {
		Authentication action =  SecurityContextHolder.getContext().getAuthentication();
		return action.getName();
	}
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap map) {
//		LOG.info("From welcome page");
//		
//		//AuthenticateService authenticateService = (n, p)-> n.equalsIgnoreCase(liginName) && p.equalsIgnoreCase(loginPass);
//		
//		if(authenticateService.authenticate(name, password)) {
//			map.put("name", name);
//			map.put("password", password);
//			return "welcome";
//		}
//		map.put("errorMSG", "Invalid Credentials Please retry!");
//		return "login";
//	}
}
