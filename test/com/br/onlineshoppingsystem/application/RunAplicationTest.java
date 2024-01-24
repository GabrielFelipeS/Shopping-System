package com.br.onlineshoppingsystem.application;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import org.junit.Test;

import com.br.onlineshoppingsystem.controller.ShoppingSystemController;

public class RunAplicationTest {

	private void setIn(String input) {
    	InputStream in = new ByteArrayInputStream(input.getBytes());
    	System.setIn(in);
	}
	
    @Test
    public void shouldTakeUserInput() {
    	setIn("gab\ngabriel@gmail.com\n12345678");
    	
    	assertThrows(NoSuchElementException.class ,() -> {
    		App.main(null);
    	});
    }
    
    @Test
    public void shouldTakeUserInput2() {
    	setIn("gab\ngabriel@gmil.com\ngabriel@gmail.com\n12345678");
    	
    	assertThrows(NoSuchElementException.class ,() -> {
    		App.main(null);
    	});
    }
    
    

}




