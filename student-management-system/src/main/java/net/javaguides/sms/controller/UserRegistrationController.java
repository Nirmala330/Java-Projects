package net.javaguides.sms.controller;

import javax.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import net.javaguides.sms.service.UserService;
import net.javaguides.sms.model.User;



@Controller
//@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;
	
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping("/registration")
	public String showRegistrationForm(User user) {
		return "registration";
	}
	
	@PostMapping("/registration")
	public String register(@Valid User user , Errors errors , Model model) {
		
		if(errors.hasErrors()) {
			return "registration";
		}else {
			
			try {
				
			userService.save(user); 
			model.addAttribute("message","Registered success");
			return "redirect:/registration?success";
			
			} catch (DataIntegrityViolationException e) {
				  
				System.out.println("email already exist"); 
				return "redirect:/registration?error";
				 
		    }

					  

		}
		
	}

	
	
	
	
}
