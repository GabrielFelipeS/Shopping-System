package com.br.onlineshoppingsystem;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UtilSetIn {
	protected void setIn(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
}
