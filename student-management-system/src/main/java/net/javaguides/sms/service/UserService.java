package net.javaguides.sms.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.sms.model.User;
import net.javaguides.sms.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	//User save(UserRegistrationDto registrationDto);
	
	User save(User registrationDto);

}
