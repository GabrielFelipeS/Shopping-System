package com.br.onlineshoppingsystem.model.services.paymentMethods;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import com.br.onlineshoppingsystem.UtilSetIn;
import com.br.onlineshoppingsystem.model.services.paymentMethod.Payment;

public class CardCreditPaymentTest extends UtilSetIn{
	@Test
	public void creditCardTest1() {
		setIn("00000000000000\n123\n12/3456\n");
		
		assertDoesNotThrow(() -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	@Test
	public void creditCardTest2() {
		setIn("m\n6\n");
		
		assertDoesNotThrow(() -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	
	@Test
	public void invalidCardNumberCreditCardTes1() {
		setIn("00000000000000000000\n123\n12/3456\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	@Test
	public void invalidCardNumberCreditCardTes2() {
		setIn("0\n123\n12/3456\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	@Test
	public void invalidCardNumberCreditCardTes3() {
		setIn("0000000A000000\n123\n12/3456\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	@Test
	public void invalidCvvInputCreditCardTes1() {
		setIn("00000000000000\n1234\n12/3456\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	@Test
	public void invalidCvvInputCreditCardTes2() {
		setIn("00000000000000\n000\n12/3456\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	@Test
	public void invalidCvvInputCreditCardTes3() {
		setIn("00000000000000\n0A0\n12/3456\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	@Test
	public void invalidDueDateInputCreditCardTes1() {
		setIn("00000000000000\n123\n00/0000\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	@Test
	public void invalidDueDateInputCreditCardTes2() {
		setIn("00000000000000\n123\n01/1900\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	@Test
	public void invalidDueDateInputCreditCardTes3() {
		setIn("00000000000000\n123\n01/2023\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	@Test
	public void invalidDueDateInputCreditCardTes4() {
		setIn("00000000000000\n123\n01/2A23\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().creditCard(2500.0);
		});
	}
	
	
	@Test
	public void invalidDueDateInputCreditCardTes5() {
		setIn("00000000000000\n123\nA1/2023\n");
		
		assertThrows(NoSuchElementException.class, () -> {
			new Payment().creditCard(2500.0);
		});
	}
	
}
