package com.br.onlineshoppingsystem.model.services.paymentMethods;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import com.br.onlineshoppingsystem.UtilSetIn;
import com.br.onlineshoppingsystem.model.services.paymentMethod.Payment;

public class PixTest extends UtilSetIn{
	@Test
	public void pixTest1() {
		setIn("y\n");
		
		assertDoesNotThrow(() -> {
			new Payment().pix(2500.0);
		});
	}
	
	@Test
	public void pixTest2() {
		setIn("m\n");
		
		
		assertDoesNotThrow(() -> {
			new Payment().pix(2500.0);
		});
	}
	
	@Test
	public void invalidArgumentPixTest1() {
		setIn("invalid\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().pix(2500.0);
		});
	}
	
	@Test
	public void invalidArgumentPixTest2() {
		setIn("\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().pix(2500.0);
		});
	}
}
