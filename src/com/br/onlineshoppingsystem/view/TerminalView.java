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
     
     public static void printChoiceAvailabelProducts() {
    	  System.out.println("\n1. Electronics");
          System.out.println("2. Clothing");
          System.out.println("3. Books");
          System.out.println("4. Back to menu");
          System.out.print("Please choose a category to view its products or back to menu: ");
     }
}
