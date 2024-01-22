package com.br.onlineshoppingsystem.entities.DTO;

import java.util.List;

import com.br.onlineshoppingsystem.entities.Products;

public record listProductsByCategory(List<Products> selectedProducts, String categoryName) {
	
}
