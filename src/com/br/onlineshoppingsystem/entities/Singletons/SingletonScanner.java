package com.br.onlineshoppingsystem.entities.Singletons;

import java.util.Scanner;

public class SingletonScanner {
	private static Scanner sc = null;
	
	public static Scanner getInstence() {
		if(sc == null) {
			sc = new Scanner(System.in);
		}
		return sc;
	}
}
