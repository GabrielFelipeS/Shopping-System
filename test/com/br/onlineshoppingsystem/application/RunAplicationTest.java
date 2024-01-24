package com.br.onlineshoppingsystem.application;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.br.onlineshoppingsystem.UtilSetIn;

public class RunAplicationTest extends UtilSetIn {

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




