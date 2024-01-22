package com.br.onlineshoppingsystem.controller;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.br.onlineshoppingsystem.application.App;
import com.br.onlineshoppingsystem.domain.Customer;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShoppingSystemControllerTest {

	private void setIn(String input) {
    	InputStream in = new ByteArrayInputStream(input.getBytes());
    	System.setIn(in);
	}
	
    @Test
    public void choiceOfMenusElectornicsTest() {
    	setIn("1\n1\n6\n");
 
    	new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, null));	
    	boolean notException = true;
    	assertTrue(notException);
    }
    
    @Test
    public void choiceOfMenusClothingicsTest() {    	
    	setIn("1\n2\n6\n");
    	
    	new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, null));	
    	boolean notException = true;
    	
    	assertTrue(notException);
    }
    
    
  
    
    @AfterEach
    void clear() {
    	try {
			System.in.readAllBytes();
			System.in.nullInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
}
