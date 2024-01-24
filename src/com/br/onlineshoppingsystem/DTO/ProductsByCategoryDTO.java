package com.br.onlineshoppingsystem.DTO;

import java.util.List;

import com.br.onlineshoppingsystem.model.entities.Products;
import com.br.onlineshoppingsystem.model.enums.Category;

public record ProductsByCategoryDTO(String categoryName, List<Products> selectedProducts) {
	public Products get(int id) {
		return selectedProducts.get(id);
	}
	
	public int size() {
		return selectedProducts.size();
	}
	
	public Category getCategoryEnum() {
		return Category.valueOf(categoryName.toUpperCase());
	}

	public List<Products> getProductsToSelect() {
		return selectedProducts;
	}
}
