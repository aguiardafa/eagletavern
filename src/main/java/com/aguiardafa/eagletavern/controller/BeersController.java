package com.aguiardafa.eagletavern.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aguiardafa.eagletavern.model.Beer;

@Controller
public class BeersController {

	@RequestMapping("/beers/new")
	public String newBeer() {
		return "beer/BeerRegister";
	}
	
	@RequestMapping(value="/beers/new", method=RequestMethod.POST)
	public String register(@Valid Beer beer, //objeto oriundo do formulário, com atributos identicos aos campos 
							BindingResult result, //para pegar os resultados da validação, por exemplo
							Model model, //para enviar informações de volta a view, por exemplo
							RedirectAttributes redirect //para enviar informações via redirect
							) {
		if(result.hasErrors()) {
			model.addAttribute("errorMessage", "Erro de validação!!!");
			return "beer/BeerRegister"; //retorno para view informada (não é uma nova requisição) 
		}
		redirect.addFlashAttribute("successMessage", "Cerveja SKU "+  beer.getSku() +" cadastrada com sucesso!!!");
		return "redirect:/beers/new"; //redirecionamento para uma nova URL (nova requisição)
	}
}
