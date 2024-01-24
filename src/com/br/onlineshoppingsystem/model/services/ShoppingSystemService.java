package com.br.onlineshoppingsystem.model.services;

import java.util.Arrays;
import java.util.List;

import com.br.onlineshoppingsystem.model.enums.Category;
import com.br.onlineshoppingsystem.model.enums.EMenuOption;
import com.br.onlineshoppingsystem.model.enums.EPaymentMethod;
import com.br.onlineshoppingsystem.view.TerminalView;

public class ShoppingSystemService {

	public static EMenuOption getMenuChoice(String choice) {
		if (!containsChoice(Arrays.asList("1", "2", "3", "4", "5", "6"), choice))
			return EMenuOption.EXCEPTIONS;

		return EMenuOption.values()[Integer.parseInt(choice) - 1];
	}

	public static EPaymentMethod getPaymentChoice(String choice) {
		if (!containsChoice(Arrays.asList("1", "2", "3", "4", "5"), choice))
			return EPaymentMethod.EXCEPTIONS;

		return EPaymentMethod.values()[Integer.parseInt(choice) - 1];
	}
	
	public static boolean containsChoice(List<String> options, String choice) {
		return options.contains(choice);
	}
	
	public static boolean containsChoice(String choice) {
		int i = Integer.parseInt(choice);
		return i > 0 && i <= Category.values().length;
	}


	public static boolean exit() {
		TerminalView.exit();
		return true;
	}
}
