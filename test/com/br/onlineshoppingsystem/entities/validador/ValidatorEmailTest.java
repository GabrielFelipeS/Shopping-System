package com.br.onlineshoppingsystem.entities.validador;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.br.onlineshoppingsystem.entities.Validator;

public class ValidatorEmailTest {
	@Test
	public void validCustomerInformationNameTest1() {
		assertDoesNotThrow(() -> {
			Validator.validCustomerInformationEmail("gabr1el.felipe@gmail.com");
		});
	}
	
	@Test
	public void validCustomerInformationNameTest2() {
		assertDoesNotThrow(() -> {
			Validator.validCustomerInformationEmail("gabr1el.felipe@hotmail.com");
		});
	}
	
	@Test
	public void validCustomerInformationNameTest3() {
		assertDoesNotThrow(() -> {
			Validator.validCustomerInformationEmail("gabr1el.felipe@outlook.com");
		});
	}
	
	
	@Test
	public void invalidCustomerInformationNameTest1() {
		assertThrows(IllegalArgumentException.class, () -> {
			Validator.validCustomerInformationEmail("1gabriel.felipe@gmail.com");
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest2() {
		assertThrows(IllegalArgumentException.class, () -> {
			Validator.validCustomerInformationEmail("1gabriel.felipe@hotmail.com");
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest3() {
		assertThrows(IllegalArgumentException.class, () -> {
			Validator.validCustomerInformationEmail("1gabriel.felipe@outlook.com");
		});
	}
	
}
