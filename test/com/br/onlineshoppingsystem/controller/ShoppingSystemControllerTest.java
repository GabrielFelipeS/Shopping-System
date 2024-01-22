package com.br.onlineshoppingsystem.controller;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import com.br.onlineshoppingsystem.domain.Customer;


//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShoppingSystemControllerTest {
	private static ShoppingSystemController controller = new ShoppingSystemController();
	
	 //@Rule
	// public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();

	 
	private void setIn(String input) {
		
    	InputStream in = new ByteArrayInputStream(input.getBytes());
    	System.setIn(in);
	}
	
    @Test
   // @Order(1)
    public void choiceOfMenusElectornicsTest() {
    	//waitMoment();
    	setIn("1\n1\n6\n");
    	
    	 //ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    	 //System.setOut(new PrintStream(outContent));
    	 //systemInMock.provideLines("1", "1", "6");

    	 new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, null));	
    	boolean notException = true;
    	assertTrue(notException);
    }
    
    @Test
    //@Order(2)
    public void choiceOfMenusClothingicsTest() {
    	 //systemInMock.provideLines("1", "1", "6");
    	
    	setIn("1\n2\n6\n");
    	new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, null));	
    	boolean notException = true;
    	assertTrue(notException);
    }
    
    
    public void waitMoment() {
    	try {
			wait(50);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
