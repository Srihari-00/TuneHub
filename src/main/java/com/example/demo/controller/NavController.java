package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NavController 
{
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	@GetMapping("/register")
	public String registration()
	{
		return "register";
	}
	@GetMapping("/newSong")
	public String newSong()
	{
		return "newSong";
	}
}
