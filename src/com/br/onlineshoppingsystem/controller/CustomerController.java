package com.br.onlineshoppingsystem.controller;

import java.util.Scanner;

import com.br.onlineshoppingsystem.domain.Customer;
import com.br.onlineshoppingsystem.entities.ShoppingCart;
import com.br.onlineshoppingsystem.entities.ShoppingSystem;
import com.br.onlineshoppingsystem.entities.Validator;
import com.br.onlineshoppingsystem.entities.Singletons.SingletonScanner;

public class CustomerController {

	public static Customer enterCustomerInformation() {
		String name, email, addressInput;
		long address;
		
		Scanner sc = SingletonScanner.getInstence();

		while (true) {
			System.out.print("Name: ");
			name = sc.nextLine();

			System.out.print("Email (@gmail.com): ");
			email = sc.nextLine(); // Change to nextLine() to read the whole line

			System.out.print("Shipping address (CEP/ZIP code - only integers): ");
			addressInput = sc.nextLine(); // Change to nextLine() to read the whole line

			try {
				//Validator.customerInformation(name, email, addressInput);
				address = Long.parseLong(formatAddress(addressInput)); // Try to parse the input as a long
				break; // Break the loop if a valid address is obtained
			} catch (IllegalArgumentException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println("\nInvalid information. Please enter valid values!");
			}
			
		}
		Customer customer = new Customer(name, email, address, new ShoppingCart());
		System.out.println(customer);
		return customer;
	}
	
	private static String formatAddress(String addressInput) {
		return addressInput.replaceAll("[^\\d]", "");
	}

}
