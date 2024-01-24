package com.br.onlineshoppingsystem.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.br.onlineshoppingsystem.DTO.ProductsByCategoryDTO;
import com.br.onlineshoppingsystem.domain.Customer;
import com.br.onlineshoppingsystem.domain.Order;
import com.br.onlineshoppingsystem.model.entities.Products;
import com.br.onlineshoppingsystem.model.entities.ShoppingCart;
import com.br.onlineshoppingsystem.model.entities.ShoppingCartItems;
import com.br.onlineshoppingsystem.model.entities.categories.Books;
import com.br.onlineshoppingsystem.model.entities.categories.Clothing;
import com.br.onlineshoppingsystem.model.entities.categories.Eletronics;
import com.br.onlineshoppingsystem.model.enums.Category;
import com.br.onlineshoppingsystem.model.enums.EMenuOption;
import com.br.onlineshoppingsystem.model.enums.EPaymentMethod;
import com.br.onlineshoppingsystem.model.exceptions.DomainException;
import com.br.onlineshoppingsystem.model.services.ShoppingSystemService;
import com.br.onlineshoppingsystem.model.services.paymentMethod.IPaymentMethod;
import com.br.onlineshoppingsystem.model.services.paymentMethod.Payment;
import com.br.onlineshoppingsystem.strategy.ProductChooseStrategy;
import com.br.onlineshoppingsystem.view.TerminalView;

public class ShoppingSystemController implements IPaymentMethod {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		new ShoppingSystemController()
		.choiceOfMenus(new Customer("Gabriel", "gabriel@gmail.com", 0000000L, new ShoppingCart()));

	}
	
	public static boolean containsChoice(List<String> options, String choice) {
		return options.contains(choice);
	}
	
	public void run() {
		TerminalView.printWelcome();

		System.out.println("\n-- To create a personalized cart for you, we need you sign up --\n");

		Customer customer = CustomerController.enterCustomerInformation();

		choiceOfMenus(customer);
	}

	void choiceOfMenus(Customer customer) {
		boolean finishProgram = false;
		while (true) {

			TerminalView.menuDisplay();

			EMenuOption choiceFromEMenuOptions = getMenuChoice();

			switch (choiceFromEMenuOptions) {
			case BROWSE_PRODUCTS -> browseProducts(new Eletronics(), new Books(), new Clothing());
			case ADD_TO_CART -> addToCart(new Eletronics(), new Books(), new Clothing(), customer);
			case VIEW_CART -> viewCart(customer);
			case REMOVE_FROM_CART -> removeItemFromCart(new Eletronics(), new Books(), new Clothing(), customer);
			case CHECKOUT -> checkout(customer);
			case EXIT -> finishProgram = ShoppingSystemService.exit();
			default -> System.out.println("\nInvalid option. Please try again.");
			}

			if (finishProgram)
				break;
		}
	}

	public void browseProducts(Eletronics eletronics, Books book, Clothing clothing) {

		TerminalView.printAvaibleProduct();

		String productChoose;
		do {
			TerminalView.printChoiceAvailabelProducts();
			productChoose = sc.next();

		} while (!ShoppingSystemService.containsChoice(Arrays.asList("1", "2", "3", "4"), productChoose));
		if (productChoose.equals("4")) return;
		
		ProductsByCategoryDTO productsByCategory = ProductChooseStrategy.getProductsByCategoryDTOBy(productChoose);
		
		System.out.println("\nHere are the products in the " + productsByCategory.categoryName() + " category:\n");
		
		int tam = productsByCategory.size();
		for (int i = 0; i < tam; i++) {
			Products product = productsByCategory.get(i);
			System.out.println((i + 1) + ". " + product);
		}

	}

	public void addToCart(Eletronics eletronics, Books book, Clothing clothing, Customer customer) {
		TerminalView.printToAddCart();
		System.out.println("\nFrom what category:");
				
		String addOptionProductsfromCategory;
		do {
			TerminalView.printChoiceAvailabelProducts();
			System.out.print("Your choice: ");
			addOptionProductsfromCategory = sc.nextLine();

		} while (!ShoppingSystemService.containsChoice(addOptionProductsfromCategory));

		ProductsByCategoryDTO productsByCategory = ProductChooseStrategy.getProductsByCategoryDTOBy(addOptionProductsfromCategory);
		
		defaultFunctionalityAddToCart(productsByCategory.getCategoryEnum(), customer, eletronics, book, clothing, productsByCategory.getProductsToSelect());
	}

	private void defaultFunctionalityAddToCart(Category productToAdd, Customer customer, Eletronics eletronics,
			Books book, Clothing clothing, List<Products> productsToSelect) {

		int quantity;
		String optionAddCart;

		while (true) {

			TerminalView.simplifiedViewProducts(productsToSelect);

			System.out.print("Your choice to add to cart: ");
			optionAddCart = sc.next();

			if (optionAddCart.equals("4"))
				return;

			System.out.print("Quantity: ");
			String quantityInput = sc.next();

			if (ShoppingSystemService.containsChoice(Arrays.asList("1", "2", "3"), optionAddCart)) {
				try {

					quantity = Integer.parseInt(quantityInput);
					if (quantity > 0)
						break;
					else
						throw new NumberFormatException();

				} catch (NumberFormatException e) {
					System.out.println("\nPlease enter valid values!");
				}
			} else {
				System.out.println("\nPlease enter valid values!");
			}
		}

		var pcs = productToAdd.getProductsByCategoryDTO();
		
		customer.addToShoppingCart(pcs.get(Integer.parseInt(optionAddCart) - 1), quantity);
		
		System.out.println("\nSuccessfully added!");

	}



	public void viewCart(Customer customer) {
		int totalItems = 0;

		System.out.println();
		System.out.println("╔═══════════════════════════════╗");
		System.out.println("║           VIEW CART           ║");
		System.out.println("╚═══════════════════════════════╝\n");

		List<ShoppingCartItems> cartItems = customer.getShoppingCart().getItems();

		if (cartItems.isEmpty()) {
			System.out.println();
			System.out.println("--- YOUR CAR IS EMPTY! ---");
			return;
		}

		for (int i = 0; i < customer.getShoppingCart().getItems().size(); i++) {

			ShoppingCartItems cartItem = customer.getShoppingCart().getItems().get(i);

			int quantity = cartItem.getQuantity();
			double itemTotalCost = quantity * cartItem.getProduct().getPrice();

			System.out.println((i + 1) + ". " + cartItem.getProduct().getName() + " (Qty: " + quantity + ") - $"
					+ String.format("%.2f", itemTotalCost));
			totalItems += quantity;

		}

		double totalCost = customer.getShoppingCart().totalCost();

		System.out.println("\nTotal Items: " + totalItems);
		System.out.println("Total Cost: $" + String.format("%.2f", totalCost));

	}

	public void removeItemFromCart(Eletronics eletronics, Books book, Clothing clothing, Customer customer) {

		System.out.println();
		System.out.println("╔═══════════════════════════════╗");
		System.out.println("║           REMOVE ITEM         ║");
		System.out.println("╚═══════════════════════════════╝\n");

		List<ShoppingCartItems> cartItems = customer.getShoppingCart().getItems();

		// will print the message and return to menu
		if (cartItems.isEmpty()) {
			System.out.println("\n--- YOUR CAR IS EMPTY! ---");
			return;
		}

		// To view all products
		simplifiedViewShoppingCartItems(cartItems);

		List<String> arrayContainsChoice = new LinkedList<>();
		for (int i = 1; i <= cartItems.size(); i++) {
			arrayContainsChoice.add(Integer.toString(i));
		}

		while (true) {

			System.out.print("Choice to remove: ");
			String choice = sc.nextLine();

			if (choice.equals(Integer.toString(cartItems.size() + 1)))
				return;

			System.out.print("Quantity to remove: ");
			String quantityToRemoveInput = sc.nextLine();

			int quantityToRemove;

			if (containsChoice(arrayContainsChoice, choice)) {

				try {
					quantityToRemove = Integer.parseInt(quantityToRemoveInput);
System.out.println(quantityToRemove);
					
					ShoppingCartItems itemToRemove = customer.getShoppingCart().getItems()
							.get(Integer.parseInt(choice) - 1);

					boolean isSucess = customer.removeQuantityItem(itemToRemove.getProduct(), quantityToRemove);
					
					if(isSucess) {
						break;
					} else {
						throw new DomainException("\nInvalid quantity!\n");	
					}
					

				} catch (NumberFormatException | DomainException e) {

					if (e instanceof DomainException)
						System.out.println(e.getMessage());
					else
						System.out.println("\nInvalid option!\n");

					// to view shopping cart products
					simplifiedViewShoppingCartItems(cartItems);
				}

			} else { // if does not match any option

				System.out.println("\nInvalid option!\n");
				simplifiedViewShoppingCartItems(cartItems);

			}
		}
	}

	private void simplifiedViewShoppingCartItems(List<ShoppingCartItems> shoppingCartItemsList) {
		for (int i = 0; i < shoppingCartItemsList.size(); i++) {

			String nameItem = shoppingCartItemsList.get(i).getProduct().getName();
			int itemQuantity = shoppingCartItemsList.get(i).getQuantity();

			System.out.println((i + 1) + ". " + nameItem + " (Qty: " + itemQuantity + ")");
		}
		System.out.println((shoppingCartItemsList.size() + 1) + ". Back to menu");
	}

	public void checkout(Customer customer) {

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		List<ShoppingCartItems> shoppingCartItemsList = customer.getShoppingCart().getItems();

		if (shoppingCartItemsList.isEmpty()) {
			System.out.println("\n--- YOUR ORDER IS EMPTY! ---");
			return;
		}

		Double totalCostOrder = customer.getShoppingCart().totalCost();

		Order order = new Order(shoppingCartItemsList, customer, LocalDateTime.now(), totalCostOrder);
		
		List<ShoppingCartItems> orderCostumerItems = order.getCustomer().getShoppingCart().getItems();
		int totalItems = 0;

		System.out.println("╔═══════════════════════════════╗");
		System.out.println("║            CHECKOUT           ║");
		System.out.println("╚═══════════════════════════════╝");
		System.out.println("\nYour order summary:");

		for (int i = 0; i < orderCostumerItems.size(); i++) {

			Double price = orderCostumerItems.get(i).getProduct().getPrice() * orderCostumerItems.get(i).getQuantity();
			int quantity = orderCostumerItems.get(i).getQuantity();
			System.out.println((i + 1) + ". " + orderCostumerItems.get(i).getProduct().getName() + "(Qty: " + quantity
					+ ")" + " - $" + String.format("%.2f", price));

			totalItems += quantity;
		}

		String formatDate = order.getOrderDate().format(df);

		System.out.println("\nTotal Items: " + totalItems);
		System.out.println("Order at: " + formatDate);
		System.out.println("Total Different Items: " + orderCostumerItems.size());
		System.out.println("Total Cost: $" + String.format("%.2f", order.getOrderTotal()));

		String orderName = order.getCustomer().getName();
		String orderNameCapitalized = orderName.substring(0, 1).toUpperCase() + orderName.substring(1);
		String orderEmail = order.getCustomer().getEmail();
		long orderShippingAddress = order.getCustomer().getShippingAddress();

		System.out.println("\nShipping address:");
		System.out.println("Name: " + orderNameCapitalized);
		System.out.println("Email: " + orderEmail);
		System.out.println("Shipping address: " + orderShippingAddress);

		System.out.println("\nSelect Payment Method:");

		System.out.println("1. Credit Card");
		System.out.println("2. Bank transfer");
		System.out.println("3. Pix");
		System.out.println("4. Bitcoin");

		EPaymentMethod paymentMethodChoice = getPaymentChoice();

		Payment paymentMethod = new Payment();

		switch (paymentMethodChoice) {
		case CREDITCARD -> paymentMethod.creditCard(totalCostOrder);
		case BANKTRANSFER -> paymentMethod.bankTransfer(totalCostOrder);
		case PIX -> paymentMethod.pix(totalCostOrder);
		case BITCOIN -> paymentMethod.bitcoin(totalCostOrder);
		case EXCEPTIONS -> {
			System.out.println("\nInvalid option. Please try again!");
			return;
		}

		}

		orderCostumerItems.clear();
	}

	public EMenuOption getMenuChoice() {

		System.out.print("Your choice: ");
		String choice = sc.nextLine();
		System.err.println(choice);

		return ShoppingSystemService.getMenuChoice(choice);
	}

	public EPaymentMethod getPaymentChoice() {
		System.out.print("Please choose an option: ");
		String choice = sc.nextLine();

		return ShoppingSystemService.getPaymentChoice(choice);
	}
}
