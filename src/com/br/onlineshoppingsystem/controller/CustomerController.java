package com.br.onlineshoppingsystem.controller;

import java.util.Scanner;
import java.util.function.Consumer;

import com.br.onlineshoppingsystem.domain.Customer;
import com.br.onlineshoppingsystem.model.services.CustomerService;
import com.br.onlineshoppingsystem.validation.customer.ValidatorCustomer;

public class CustomerController {
	private static Scanner sc = new Scanner(System.in);

	public static Customer enterCustomerInformation() {

		 String name = scanString("Name: ", ValidatorCustomer::validCustomerInformationName);

		 String email = scanString("Email: ", ValidatorCustomer::validCustomerInformationEmail);

		 String addressInput = scanString("Shipping address (CEP/ZIP code - only integers): ", ValidatorCustomer::validCustomerInformationAddress);
	
		return CustomerService.createCustomer(name, email, addressInput);
	}
		
		
	public static String scanString(String message) {
		return scanString(message, (s) ->  {} );
	}
	
	public static String scanString(String message, Consumer<String> valid) {
		String s;
		while (true) {
			try {
				System.out.print(message);
				s = sc.nextLine();
				valid.accept(s);
				return s;
				
			} catch (IllegalArgumentException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println("\nInvalid information. Please enter valid values!");
			}
		}
	}
	
	

	

}
