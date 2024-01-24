package com.br.onlineshoppingsystem.model.services.paymentMethods;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import com.br.onlineshoppingsystem.model.exceptions.DomainException;
import com.br.onlineshoppingsystem.model.services.paymentMethod.Payment;

public class PaymentMethodsTest {
	private void setIn(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
	
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
