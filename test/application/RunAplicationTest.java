package application;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import com.br.onlineshoppingsystem.application.App;

import POG.RunnerThread;

public class RunAplicationTest {

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
    
}




