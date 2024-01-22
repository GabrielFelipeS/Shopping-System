package com.br.onlineshoppingsystem.view;

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
		System.out.println("1. Electronics");
		System.out.println("2. Clothing");
		System.out.println("3. Books");
		System.out.println("4. Back to menu");
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
}
