package com.presupuestar.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.presupuestar.model.user.Person;
import com.presupuestar.user.exception.InvalidEmailFormatException;
import com.presupuestar.user.service.PersonService;
import com.presupuestar.web.dto.RegisterPersonAccountDTO;

@Controller
public class RegisterPersonAccount {

	@Autowired
	private PersonService personService;

	// TODO ver que se hace con la excepcion
	// TODO ver que retorna, tambien puede ser ModelAndView
	// TODO vee que es BindingResult
	// TODO http://viralpatel.net/blogs/spring-3-mvc-handling-forms/
	@RequestMapping(value = "/registerPersonAccount", method = RequestMethod.POST)
	public String login(
			@ModelAttribute("registerPersonAccountDto") RegisterPersonAccountDTO registerPersonAccountDto,
			BindingResult result) {
		try {
			Person person = personService.registerNewPersonAccount(
					registerPersonAccountDto.getEmail(),
					registerPersonAccountDto.getPassword(),
					registerPersonAccountDto.getFirstName(),
					registerPersonAccountDto.getLastName());
		} catch (InvalidEmailFormatException e) {
			e.printStackTrace();
		}
		return "redirect:contacts.html";
	}

}
