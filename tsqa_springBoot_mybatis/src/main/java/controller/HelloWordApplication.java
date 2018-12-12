package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class HelloWordApplication {

	 	@RequestMapping("/login")
	    public String test(String name,Model model) {
	        model.addAttribute("name",name);
	        return "hello";
	    }
	 	
	 	
	    @RequestMapping("/test/{name}")
	    public String test2(@PathVariable String name,String modelstr,Model model) {
	        System.out.println(name);
	        model.addAttribute("name",name);
	        model.addAttribute("model",modelstr);
	        return "test";
	    }
}
