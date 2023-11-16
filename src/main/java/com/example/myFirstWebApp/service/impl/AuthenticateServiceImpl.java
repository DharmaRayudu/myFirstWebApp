package com.example.myFirstWebApp.service.impl;

import org.springframework.stereotype.Service;

import com.example.myFirstWebApp.service.AuthenticateService;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

	@Override
	public boolean authenticate(String name, String password) {
		
		return name.equalsIgnoreCase("Dharma") && password.equalsIgnoreCase("Test");
	}

}
