package com.br.onlineshoppingsystem.entities.validador;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.br.onlineshoppingsystem.entities.Validator;

public class ValidatorNameTest {

	@Test
	public void validCustomerInformationNameTest1() {
		assertDoesNotThrow(() -> {
			Validator.validCustomerInformationName("Gabriel");
		});
	}
	
	@Test
	public void validCustomerInformationNameTest2() {
		assertDoesNotThrow(() -> {
			String maiorNomeDoMundo = "Taumatawhakatangihangakoauauotamateaturipukakapikimaungahoronukupokaiwhenuakitanatahu";
			Validator.validCustomerInformationName(maiorNomeDoMundo);
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest1() {
		assertThrows(IllegalArgumentException.class, () -> {
			Validator.validCustomerInformationName("");
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest2() {
		assertThrows(IllegalArgumentException.class, () -> {
			Validator.validCustomerInformationName("a");
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest3() {
		assertThrows(IllegalArgumentException.class, () -> {
			Validator.validCustomerInformationName("ab");
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest4() {
		assertThrows(IllegalArgumentException.class, () -> {
			Validator.validCustomerInformationName("G4briel");
		});
	}
	
	@Test
	public void invalidCustomerInformationNameTest5() {
		assertThrows(IllegalArgumentException.class, () -> {
			String maiorNomeDoMundoComUmNumero= "Taumatawhakatangihangakoauauotamateatur1pukakapikimaungahoronukupokaiwhenuakitanatahu";
			
			Validator.validCustomerInformationName(maiorNomeDoMundoComUmNumero);
		});
	}
}
