package com.br.onlineshoppingsystem.entities;

public class Validator {

	// Future use in swing
	/*
	 * public static void customerInformation(String name, String email, String
	 * addressInput) throws IllegalArgumentException {
	 * validCustomerInformationName(name);
	 * 
	 * validCustomerInformationEmail(email);
	 * 
	 * validCustomerInformationAddress(addressInput); }
	 */

	public static void validCustomerInformationName(String name) {
		if (name.length() <= 2 || name.matches(".*[\\d]+.*")) {
			throw new IllegalArgumentException("Invalid name!");
		}
	}

	public static void validCustomerInformationEmail(String email) {
		boolean emailNotMatch = !email.matches("^[a-z][a-z0-9\\.]+@(gmail|hotmail|outlook|yahoo).com$");

		if (emailNotMatch) {
			throw new IllegalArgumentException("Invalid email!");
		}
	}

	public static void validCustomerInformationAddress(String addressInput) {
		boolean addressNotMatch = !addressInput.matches("^\\d{5}-?\\d{3}$");

		if (addressNotMatch) {
			throw new IllegalArgumentException("Invalid address!");
		}
	}

}
