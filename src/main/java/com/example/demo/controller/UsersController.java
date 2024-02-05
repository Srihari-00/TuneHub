package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.LoginData;
import com.example.demo.entity.Song;
import com.example.demo.entity.Users;
import com.example.demo.services.SongService;
import com.example.demo.services.UsersService;
import jakarta.servlet.http.HttpSession;



@Controller
public class UsersController 
{
	@Autowired
	UsersService service;
	@Autowired
	SongService songService;
	@PostMapping("/validate")
	public String addUser(@ModelAttribute Users user) 
	{
		boolean userStatus = service.emailExists(user.getEmail());
		if(userStatus == false) {
			service.addUser(user);
			System.out.println("Users is added");
		}
		else {
			return "login";
		}
		return "index";
	}
	@PostMapping("/validation")
	public String validate(@ModelAttribute LoginData data,
			HttpSession session, Model model) 
	{		
		String email = data.getEmail();
		String password = data.getPassword();
		System.out.println("Call Received....!!");
		if(service.validateUser(email,password) == true)
		{
			String role = service.getRole(email);
			session.setAttribute("email", email);
			if(role.equals("admin"))
			{
				return "adminHome";
			}
			else
			{
				Users user = service.getUser(email);
				boolean userStatus = user.isPremium();
				model.addAttribute("isPremium", userStatus);
				
				List<Song> songsList = songService.fetchAllSongs();
				model.addAttribute("songs", songsList);
				
				return "customerHome";
			}
		}
		else 
		{
			return "login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
}