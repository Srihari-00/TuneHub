package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repositories.UsersRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Service
public class UsersServiceImplementation implements UsersService
{
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "User is added";
	}

	@Override
	public boolean emailExists(String email) {
		Users user = repo.findByEmail(email);
		if(user == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean validateUser(String email, String password) 
	{
		String db_password = repo.findByEmail(email).getPassword();
		if(password.equals(db_password))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getRole(String email) {

		return repo.findByEmail(email).getRole();
	}

	@Override
	public Users getUser(String email) 
	{
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
	}

	@Override
	@Transactional
	public String forgotPassword(String email, String newPass) {
		Users user = repo.findByEmail(email);
		if (user != null) 
		{
			user.setPassword(newPass);
			repo.save(user); // Save the updated user entity
			System.out.println("Password has been updated for user with email: " + email);
			return "Password Changed";
		} 
		else
		{
			System.out.println("User with email " + email + " not found");
			return "User not found";
		}
	}

}
