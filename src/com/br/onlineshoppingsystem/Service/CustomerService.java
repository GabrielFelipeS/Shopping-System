package com.br.onlineshoppingsystem.Service;

import com.br.onlineshoppingsystem.domain.Customer;
import com.br.onlineshoppingsystem.entities.ShoppingCart;

public class CustomerService {

	public static Customer createCustomer(String name, String email, String addressInput) {
		long address = Long.parseLong(formatAddress(addressInput)); 
		
		return new Customer(name, email, address, new ShoppingCart());
	}
	
	private static String formatAddress(String addressInput) {
		return addressInput.replaceAll("[^\\d]", "");
	}

}
