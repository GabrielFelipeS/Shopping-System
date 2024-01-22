package application;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.br.onlineshoppingsystem.application.App;

import POG.RunnerThread;

public class RunAplicationTest {
/*
    @Test
    public synchronized void runTest() {
    	boolean isExecuted = true;
    	
    	try {
    	//	App.main(null);  
    		RunnerThread.runThread(new String[] {"Gabriel", "gabriel@gmail.com", "54503901", "6"});
    		App.main(null);
    	} catch(Exception e) {
    		isExecuted = false;
    	}
    	assertTrue(isExecuted);
    }
  */  
    
    @Test
    public void shouldTakeUserInput() {
        //InputOutput inputOutput= new InputOutput();
    	boolean isExecuted = true;
    	try {
    		String input = "Gabriel\ngabriel@gmail.com\n54503901\n6\n";
    		InputStream in = new ByteArrayInputStream(input.getBytes());
    		System.setIn(in);
    		App.main(null);
    	} catch(Exception e) {
    		isExecuted = false;
    	}
    	assertTrue(isExecuted);
    }
}




