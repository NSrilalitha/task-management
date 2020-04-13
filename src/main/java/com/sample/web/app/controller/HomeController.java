package com.sample.web.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value="/greet", method= RequestMethod.GET)
	public String getMessage() {
		return "Hello... It's working";
	}
}
