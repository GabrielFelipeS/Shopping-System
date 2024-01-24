package com.br.onlineshoppingsystem.validation.customer;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.br.onlineshoppingsystem.validation.customer.ValidatorCustomer;

public class ValidatorNameTest {

	@Test
	public void validCustomerInformationNameTest1() {
		assertDoesNotThrow(() -> {
			ValidatorCustomer.validCustomerInformationName("Gabriel");
		});
	}
	
	@Test
	public void validCustomerInformationNameTest2() {
		assertDoesNotThrow(() -> {
			String maiorNomeDoMundo = "Taumatawhakatangihangakoauauotamateaturipukakapikimaungahoronukupokaiwhenuakitanatahu";
			ValidatorCustomer.validCustomerInformationName(maiorNomeDoMundo);
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest1() {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidatorCustomer.validCustomerInformationName("");
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest2() {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidatorCustomer.validCustomerInformationName("a");
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest3() {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidatorCustomer.validCustomerInformationName("ab");
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest4() {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidatorCustomer.validCustomerInformationName("G4briel");
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest5() {
		assertThrows(IllegalArgumentException.class, () -> {
			String maiorNomeDoMundoComUmNumero= "Taumatawhakatangihangakoauauotamateatur1pukakapikimaungahoronukupokaiwhenuakitanatahu";
			
			ValidatorCustomer.validCustomerInformationName(maiorNomeDoMundoComUmNumero);
		});
	}
}
