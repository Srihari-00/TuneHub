package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.ForgotPassword;
import com.example.demo.services.UsersService;

@Controller
public class OTPController 
{
	@Autowired
	OTPService service;
	
	@Autowired
	UsersService userService;
	
	@PostMapping("/setPassword")
	public String generateOTP( Model model,@ModelAttribute ForgotPassword data) 
	{
		String email = data.getEmail();
		if(userService.emailExists(email) == true)
		{
			String otp = service.generateOTP();
			System.out.println(email);
			model.addAttribute("email",email);
			model.addAttribute("otp", otp);
						
			return "enterOTP";
		}		
		return "register";
	}
	
	@PostMapping("/enterPassword")
	public String enterPassword(@ModelAttribute ForgotPassword data) {
	    String email = data.getEmail();
	    String newPass = data.getPassword();
	    String re_pass = data.getRe_password();
	    String userOTP = data.getOtp();
	    
	    if (userService.emailExists(email)) {
	        if (userOTP != null && userOTP.equals(data.getOtp()) && newPass.equals(re_pass)) {
	            userService.forgotPassword(email, newPass);
	            return "login";
	        } else {
	            System.out.println("Captcha code or password error....");
	            return "forgot";
	        }
	    }
	    
	    return "login";
	}

	
}
