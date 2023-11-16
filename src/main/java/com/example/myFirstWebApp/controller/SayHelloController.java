package com.example.myFirstWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class SayHelloController {
	
	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "I am learning Spring Web MVC!";
	}

	@RequestMapping("/say-hello-html")
	@ResponseBody
	public String sayHelloWithHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html>");
		buffer.append("<title>");
		buffer.append("My Web Page");
		buffer.append("</title>");
		buffer.append("<body>");
		buffer.append("My First Web");
		buffer.append("</body>");
		buffer.append("</html>");

		return buffer.toString();
		
	}
	
	@RequestMapping("say-hello-jsp")
	
	public String sayHelloWithJSP() {
		return "sayHello";
	}
	
	
	
}
