package com.br.onlineshoppingsystem.entities;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import com.br.onlineshoppingsystem.entities.paymentMethod.Payment;

public class PaymentMethodsTest {
	private void setIn(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
	
	@Test
	public void creditCardTest() {
		setIn("00000000000000\n123\n12/3456\n");
		
		assertDoesNotThrow(() -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	@Test
	public void bankTransferTest() {
		setIn("021\ny\n");
		
		assertDoesNotThrow(() -> {
			new Payment().bankTransfer(2500.0);
		});
	}
	
	@Test
	public void pixTest() {
		setIn("y\n");
		
		assertDoesNotThrow(() -> {
			new Payment().pix(2500.0);
		});
	}
	
	@Test
	public void bitcoinTest() {
		setIn("1\ny\n");
		
		assertDoesNotThrow(() -> {
			new Payment().bitcoin(1.0);
		});
	}
}
