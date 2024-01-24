package com.br.onlineshoppingsystem.entities.categories;

import com.br.onlineshoppingsystem.entities.DTO.ProductsByCategoryDTO;

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
