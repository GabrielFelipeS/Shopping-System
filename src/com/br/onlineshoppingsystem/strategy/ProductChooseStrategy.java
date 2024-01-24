package com.br.onlineshoppingsystem.strategy;

import com.br.onlineshoppingsystem.DTO.ProductsByCategoryDTO;
import com.br.onlineshoppingsystem.model.enums.Category;

public class ProductChooseStrategy {
	
	public static ProductsByCategoryDTO getProductsByCategoryDTOBy(String id) {
		return getProductsByCategoryDTOBy(Integer.valueOf(id));
	}

	public static ProductsByCategoryDTO getProductsByCategoryDTOBy(int index) {
		var pcs = Category.values();
		
		return pcs[index - 1].getProductsByCategoryDTO();
	}

	

}
