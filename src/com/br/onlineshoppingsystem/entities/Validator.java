package com.br.onlineshoppingsystem.entities;

public class Validator {
	
	public static void customerInformation(String name, String email, String addressInput) throws IllegalArgumentException {
		if(name.length() <= 2 || name.matches("[\\d]+")) {
			throw new IllegalArgumentException("Invalid name!");
		}
		
		boolean emailNotMatch = !email
				.matches("^[a-z][a-z0-9\\.]+@[a-z]+.[a-z]+$");
		
		if(emailNotMatch) {
			throw new IllegalArgumentException("Invalid email!");
		}
		
		boolean addressNotMatch = !addressInput
				.matches("^\\d{5}-?\\d{3}$");
		
		if(false) {
			throw new IllegalArgumentException("Invalid address!");
		}
	}
}
