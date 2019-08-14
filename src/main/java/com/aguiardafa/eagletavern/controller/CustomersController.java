package com.aguiardafa.eagletavern.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aguiardafa.eagletavern.model.Customer;

@Controller
public class CustomersController {

	@RequestMapping("/customers/new")
	public String newBeer() {
		return "customer/CustomerRegister";
	}
	
	@RequestMapping(value="/customers/new", method=RequestMethod.POST)
	public String register(@Valid Customer customer, //objeto oriundo do formulário, com atributos identicos aos campos 
							BindingResult result, //para pegar os resultados da validação, por exemplo
							Model model, //para enviar informações de volta a view, por exemplo
							RedirectAttributes redirect //para enviar informações via redirect
							) {
		if(result.hasErrors()) {
			model.addAttribute("errorMessage", "Erro de validação!!!");
			return "customer/CustomerRegister"; //retorno para view informada (não é uma nova requisição) 
		}
		redirect.addFlashAttribute("successMessage", "Cliente "+  customer.getNome() +" cadastrado com sucesso!!!");
		return "redirect:/customers/new"; //redirecionamento para uma nova URL (nova requisição)
	}

}
