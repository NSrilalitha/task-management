package com.sample.web.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://bpvog76086dns1.eastus2.cloudapp.azure.com:8080", "http://172.18.0.1:8080"})
public class HomeController {

	@RequestMapping(value="/greet", method= RequestMethod.GET)
	public String getMessage() {
		return "Hello... It's working";
	}
}
