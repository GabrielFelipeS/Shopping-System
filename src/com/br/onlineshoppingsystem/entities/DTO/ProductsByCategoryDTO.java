package com.br.onlineshoppingsystem.entities.DTO;

import java.util.List;
import com.br.onlineshoppingsystem.entities.categories.Category;
import com.br.onlineshoppingsystem.entities.Products;

public record ProductsByCategoryDTO(String categoryName, List<Products> selectedProducts) {
	public Products get(int id) {
		return selectedProducts.get(id);
	}
	
	public int size() {
		return selectedProducts.size();
	}
	
	public Category getCategoryEnum() {
		return Category.valueOf(categoryName);
	}

	public List<Products> getProductsToSelect() {
		return selectedProducts;
	}
}
