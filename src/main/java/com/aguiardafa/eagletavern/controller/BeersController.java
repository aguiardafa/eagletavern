package com.aguiardafa.eagletavern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BeersController {

	@RequestMapping("/beers/new")
	public String newBeer() {
		return "beer/BeerRegister";
	}
}
