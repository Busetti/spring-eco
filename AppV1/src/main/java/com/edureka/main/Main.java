package com.edureka.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {
	
	
	@GetMapping("hello")
	public ModelAndView hello(ModelAndView mv) {
		mv.setViewName("hello");
		mv.addObject("data", "Hello World");
		return mv;
	}

}
