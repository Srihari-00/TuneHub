package com.example.demo.services;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import com.example.demo.controller.OTPService;

@Service
public class OTPServiceImpletation implements OTPService 
{
	// Define the set of characters allowed in the OTP
	private static final String ALLOWED_CHARACTERS = "0123456789";

	private static final int length = 6; // Specify the length of OTP

	@Override
	public String generateOTP() 
	{
		// Use SecureRandom for generating random numbers securely
		SecureRandom random = new SecureRandom();

		// StringBuilder to efficiently build the OTP
		StringBuilder sb = new StringBuilder(length);

		// Generate OTP of specified length
		for (int i = 0; i < length; i++) {
			// Select a random index from the ALLOWED_CHARACTERS string
			int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());

			// Append the character at the random index to the OTP
			sb.append(ALLOWED_CHARACTERS.charAt(randomIndex));
		}
		// Print OTP
		System.out.println("Generated OTP: " + sb.toString());

		// Convert StringBuilder to String and return the OTP
		return sb.toString();


	}


}
