package com.br.onlineshoppingsystem.model.services.paymentMethods;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import com.br.onlineshoppingsystem.UtilSetIn;
import com.br.onlineshoppingsystem.model.services.paymentMethod.Payment;

public class BitCoinTest extends UtilSetIn{
	
	@Test
	public void bitcoinTest1() {
		setIn("1\ny\n");
		
		assertDoesNotThrow(() -> {
			new Payment().bitcoin(1.0);
		});
	}
	
	@Test
	public void bitcoinTest2() {
		setIn("1\nm\n");
		
		assertDoesNotThrow(() -> {
			new Payment().bitcoin(1.0);
		});
	}
	
	
	@Test
	public void invalidBitcoinTest1() {
		setIn("1\nn\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().bitcoin(1.0);
		});
	}
	
	@Test
	public void invalidBitcoinTest2() {
		setIn("1\ninvalid\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().bitcoin(1.0);
		});
	}
}
