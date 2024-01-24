package com.br.onlineshoppingsystem.model.services.paymentMethods;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import com.br.onlineshoppingsystem.UtilSetIn;
import com.br.onlineshoppingsystem.model.services.paymentMethod.Payment;

public class BankTransferTest extends UtilSetIn{
	@Test
	public void bankTransferTest() {
		setIn("021\ny\n");
		
		assertDoesNotThrow(() -> {
			new Payment().bankTransfer(2500.0);
		});
	}
	
	@Test
	public void bankTransferTest2() {
		setIn("021\nm\n");
		
		assertDoesNotThrow(() -> {
			new Payment().bankTransfer(2500.0);
		});
	}
	
	@Test
	public void invalidArgumentBankTransferTest1() {
		setIn("021\ninvalid\n");
		
		assertThrows(NoSuchElementException.class ,() -> {
			new Payment().bankTransfer(2500.0);
		});
	}
	
	@Test
	public void invalidArgumentBankTransferTest2() {
		setIn("invalid\ny\n");
		
		assertThrows(NoSuchElementException.class ,() -> {
			new Payment().bankTransfer(2500.0);
		});
	}
	
	@Test
	public void invalidArgumentBankTransferTest3() {
		setIn("021invalid\ny\n");
		
		assertThrows(NoSuchElementException.class ,() -> {
			new Payment().bankTransfer(2500.0);
		});
	}
}
