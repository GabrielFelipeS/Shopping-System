package com.br.onlineshoppingsystem.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.br.onlineshoppingsystem.UtilSetIn;
import com.br.onlineshoppingsystem.domain.Customer;
import com.br.onlineshoppingsystem.model.entities.Products;
import com.br.onlineshoppingsystem.model.entities.ShoppingCart;
import com.br.onlineshoppingsystem.model.entities.ShoppingCartItems;
import com.br.onlineshoppingsystem.model.enums.Category;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShoppingSystemControllerTest extends UtilSetIn{

	@Test
	public void choiceADD_TO_CART() {
		setIn("2\n1\n3\n25\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, new ShoppingCart()));
		});
	}
	
	@Test
	public void choiceADD_TO_CART2() {
		setIn("2\n3\n1\n25\n6\n");
		Products product = new Products("To Kill a Mockingbird by Harper Lee", "product teste", 2500.0, Category.BOOKS);
		Products product2 = new Products("The Great Gatsby by F. Scott Fitzgerald", "product teste", 2500.0, Category.BOOKS);
		Products product3 = new Products("Becoming by Michelle Obama", "product teste", 2500.0, Category.BOOKS);
		

		List<ShoppingCartItems> list = 
				new ArrayList<ShoppingCartItems>(
						Arrays.asList(
								new ShoppingCartItems(product, 10), 
								new ShoppingCartItems(product2, 20), 
								new ShoppingCartItems(product3, 20)
							)
						);
		
		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null,
					new ShoppingCart(list)));
		});
	}

	@Test
	public void choiceADD_TO_CARTandCanel() {
		setIn("2\n1\n4\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, new ShoppingCart()));
		});
	}

	@Test
	public void choiceADD_TO_CARTandVIEW_CART() {
		setIn("2\n1\n3\n25\n3\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, new ShoppingCart()));
		});
	}

	@Test
	public void choiceVIEW_CART() {
		setIn("3\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, new ShoppingCart()));
		});
	}

	@Test
	public void choiceREMOVE_FROM_CART() {
		setIn("4\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, new ShoppingCart()));
		});
	}
	
	@Test
	public void choiceREMOVE_FROM_CART2() {
		setIn("4\n1\n5\n6\n");
		Products product = new Products("To Kill a Mockingbird by Harper Lee", "product teste", 2500.0, Category.BOOKS);
		Products product2 = new Products("The Great Gatsby by F. Scott Fitzgerald", "product teste", 2500.0, Category.BOOKS);
		Products product3 = new Products("Becoming by Michelle Obama", "product teste", 2500.0, Category.BOOKS);
		

		List<ShoppingCartItems> list = 
				new ArrayList<ShoppingCartItems>(
						Arrays.asList(
								new ShoppingCartItems(product, 10), 
								new ShoppingCartItems(product2, 20), 
								new ShoppingCartItems(product3, 20)
							)
						);
		
		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null,
					new ShoppingCart(list)));
		});
	}
	
	@Test
	public void choiceREMOVE_FROM_CART3() {
		setIn("4\n1\n50\n1\n5\n6\n");
		Products product = new Products("To Kill a Mockingbird by Harper Lee", "product teste", 2500.0, Category.BOOKS);
		Products product2 = new Products("The Great Gatsby by F. Scott Fitzgerald", "product teste", 2500.0, Category.BOOKS);
		Products product3 = new Products("Becoming by Michelle Obama", "product teste", 2500.0, Category.BOOKS);
		

		List<ShoppingCartItems> list = 
				new ArrayList<ShoppingCartItems>(
						Arrays.asList(
								new ShoppingCartItems(product, 10), 
								new ShoppingCartItems(product2, 20), 
								new ShoppingCartItems(product3, 20)
							)
						);
		
		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null,
					new ShoppingCart(list)));
		});
	}
	
	@Test
	public void choiceREMOVE_FROM_CART4() {
		setIn("4\n1\n10\n6\n");
		Products product = new Products("To Kill a Mockingbird by Harper Lee", "product teste", 2500.0, Category.BOOKS);
		Products product2 = new Products("The Great Gatsby by F. Scott Fitzgerald", "product teste", 2500.0, Category.BOOKS);
		Products product3 = new Products("Becoming by Michelle Obama", "product teste", 2500.0, Category.BOOKS);
		

		List<ShoppingCartItems> list = 
				new ArrayList<ShoppingCartItems>(
						Arrays.asList(
								new ShoppingCartItems(product, 10), 
								new ShoppingCartItems(product2, 20), 
								new ShoppingCartItems(product3, 20)
							)
						);
		
		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null,
					new ShoppingCart(list)));
		});
	}

	@Test
	public void choiceADD_TO_CARTandREMOVE_FROM_CART() {
		setIn("2\n1\n3\n25\n4\n1\n20\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, new ShoppingCart()));
		});
	}

	@Test
	public void choiceADD_TO_CARTIncorrectQuantity() {
		setIn("2\n1\n3\nabacate\n3\n25\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, new ShoppingCart()));
		});
	}

	@Test
	public void choiceCHECKOUT() {
		setIn("5\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, new ShoppingCart()));
		});
	}

	@Test
	public void checkoutTest() {
		setIn("5\n5\n6\n");

		assertDoesNotThrow(() -> {
			Products product = new Products("product", "product teste", 2500.0, Category.BOOKS);

			new ShoppingSystemController().choiceOfMenus(new Customer("Gabriel", "gabriel@gmail.com", 0000000L,
					new ShoppingCart(new ArrayList<>(Arrays.asList(new ShoppingCartItems(product, 25))))));
		});
	}

	// Criar uma classe para guardar esses testes
	@Test
	public void choiceOfMenusElectornicsTest() {
		setIn("1\n1\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, null));
		});
	}

	@Test
	public void choiceOfMenusClothingicsTest() {
		setIn("1\n2\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, null));
		});
	}

	@Test
	public void choiceOfMenusBooksTest() {
		setIn("1\n3\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, null));
		});
	}

	@Test
	public void choiceOfMenusBackToMenuTest() {
		setIn("1\n4\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, null));
		});
	}

	@Test
	public void choiceOfMenusOutBoundTest() {
		setIn("1\n10\n1\n6\n");

		assertDoesNotThrow(() -> {
			new ShoppingSystemController().choiceOfMenus(new Customer(null, null, null, null));
		});
	}

	
}
