package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>
{
	public Users findByEmail(String email);
}
