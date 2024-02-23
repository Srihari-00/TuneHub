package com.example.demo.services;

import com.example.demo.entity.Users;

public interface UsersService 
{
	//To add a new user
	public String addUser(Users user);
	//To check if the user is already registered or not
	public boolean emailExists(String email);
	//To validate the user details
	public boolean validateUser(String email, String password);
	//To retreive the role of the user
	public String getRole(String email);
	//To get the user
	public Users getUser(String email);
	//To update the user
	public void updateUser(Users user);
	
	public String forgotPassword(String email, String newPass);
	

}
