package com.br.onlineshoppingsystem.entities;

import com.br.onlineshoppingsystem.entities.DTO.ProductsByCategoryDTO;
import com.br.onlineshoppingsystem.entities.categories.Books;
import com.br.onlineshoppingsystem.entities.categories.Clothing;
import com.br.onlineshoppingsystem.entities.categories.Eletronics;

public enum ProductChooseStrategy {
	ELECTRONICS(new ProductsByCategoryDTO("Electronics", new Eletronics().getEletronics())),
	CLOTHING(new ProductsByCategoryDTO("Clothing", new Clothing().getClothings())),
	BOOKS(new ProductsByCategoryDTO("Books", new Books().getBooks()));

	private ProductsByCategoryDTO productsByCategoryDTO;

	private ProductChooseStrategy(ProductsByCategoryDTO productsByCategoryDTO) {
		this.productsByCategoryDTO = productsByCategoryDTO;
	}

	public static ProductsByCategoryDTO getProductsByCategoryDTOBy(String id) {
		return getProductsByCategoryDTOBy(Integer.valueOf(id));
	}

	public static ProductsByCategoryDTO getProductsByCategoryDTOBy(int index) {
		var pcs = ProductChooseStrategy.values();
		
		if (index <= 0 || index > pcs.length)
			throw new IndexOutOfBoundsException("out of bounds for getProductsByCategoryDTOBy");

		return pcs[index - 1].getProductsByCategoryDTO();
	}

	public ProductsByCategoryDTO getProductsByCategoryDTO() {
		return productsByCategoryDTO;
	}

}
