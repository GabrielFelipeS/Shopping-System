package com.br.onlineshoppingsystem.model.enums;

import com.br.onlineshoppingsystem.DTO.ProductsByCategoryDTO;
import com.br.onlineshoppingsystem.model.entities.categories.Books;
import com.br.onlineshoppingsystem.model.entities.categories.Clothing;
import com.br.onlineshoppingsystem.model.entities.categories.Eletronics;

public enum Category {
	ELETRONICS(new ProductsByCategoryDTO("Eletronics", new Eletronics().getEletronics())),
	CLOTHING(new ProductsByCategoryDTO("Clothing", new Clothing().getClothings())),
	BOOKS(new ProductsByCategoryDTO("Books", new Books().getBooks()));

	private ProductsByCategoryDTO productsByCategoryDTO;

	private Category(ProductsByCategoryDTO productsByCategoryDTO) {
		this.productsByCategoryDTO = productsByCategoryDTO;
	}
	
	public ProductsByCategoryDTO getProductsByCategoryDTO() {
		return productsByCategoryDTO;
	}
}
