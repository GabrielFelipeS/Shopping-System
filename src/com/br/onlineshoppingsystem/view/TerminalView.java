package com.br.onlineshoppingsystem.view;

import java.util.List;

import com.br.onlineshoppingsystem.entities.ProductChooseStrategy;
import com.br.onlineshoppingsystem.entities.Products;

public class TerminalView {
	public static void printWelcome() {
		System.out.println();
		System.out.println("    ╔═══════════════════════════════╗");
		System.out.println("    ║                               ║");
		System.out.println("    ║   WELCOME TO SHOPPING SYSTEM  ║");
		System.out.println("    ║                               ║");
		System.out.println("    ╚═══════════════════════════════╝");
	}

	public static void printAvaibleProduct() {
		System.out.println();
		System.out.println("╔════════════════════════════════╗");
		System.out.println("║  AVAILABLE PRODUCT CATEGORIES  ║");
		System.out.println("╚════════════════════════════════╝");
	}

	public static void printToAddCart() {
		System.out.println();
		System.out.println("╔═══════════════════════════════╗");
		System.out.println("║          ADD TO CART          ║");
		System.out.println("╚═══════════════════════════════╝");
	}

	public static void printChoiceAvailabelProducts() {
		var pcs = ProductChooseStrategy.values();
		int i;
		for(i = 1;i <= pcs.length; i++) {
			System.out.printf("%d. %s\n", i, ProductChooseStrategy.getProductsByCategoryDTOBy(i).categoryName());
		}
		
		System.out.printf("%d. Back to menu\n", i);
		System.out.print("Please choose a category to view its products or back to menu: ");
	}

	public static void menuDisplay() {
		System.out.println("════════════════════════════════════");
		System.out.println("\nMain menu:");
		System.out.println("1. Browse Products");
		System.out.println("2. Add to cart");
		System.out.println("3. View cart");
		System.out.println("4. Remove from cart");
		System.out.println("5. Checkout");
		System.out.println("6. Exit");
	}

	public static void exit() {
		System.out.println();
		System.out.println("    ╔═══════════════════════════════╗");
		System.out.println("    ║                               ║");
		System.out.println("    ║  THANKS FOR USING OUR SYSTEM! ║");
		System.out.println("    ║                               ║");
		System.out.println("    ╚═══════════════════════════════╝");
	}

	public static void simplifiedViewProducts(List<Products> productsToSelect) {
		for (int i = 0; i < productsToSelect.size(); i++) {
			Products product = productsToSelect.get(i);
			System.out.println((i + 1) + ". " + product);
		}
		System.out.println("4. Back to menu");

	}
}
