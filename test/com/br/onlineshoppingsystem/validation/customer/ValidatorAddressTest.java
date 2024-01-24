package com.br.onlineshoppingsystem.validation.customer;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.br.onlineshoppingsystem.validation.customer.ValidatorCustomer;

public class ValidatorAddressTest {
	
	@Test
	public void validCustomerInformationAddressTest1() {
		assertDoesNotThrow(() -> {
			ValidatorCustomer.validCustomerInformationAddress("00000-000");
		});
	}
	
	@Test
	public void validCustomerInformationAddressTest2() {
		assertDoesNotThrow(() -> {
			ValidatorCustomer.validCustomerInformationAddress("12345-678");
		});
	}
	
	@Test
	public void validCustomerInformationAddressTest3() {
		assertDoesNotThrow(() -> {
			ValidatorCustomer.validCustomerInformationAddress("00000000");
		});
	}
	
	@Test
	public void validCustomerInformationAddressTest4() {
		assertDoesNotThrow(() -> {
			ValidatorCustomer.validCustomerInformationAddress("12345678");
		});
	}
	
	
	@Test
	public void invalidCustomerInformationAddressTest1() {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidatorCustomer.validCustomerInformationAddress("12345-67");
		});
	}
	
	
	@Test
	public void invalidCustomerInformationAddressTest2() {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidatorCustomer.validCustomerInformationAddress("1234-678");
		});
	}
	
	@Test
	public void invalidCustomerInformationAddressTest3() {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidatorCustomer.validCustomerInformationAddress("1234567");
		});
	}
}
