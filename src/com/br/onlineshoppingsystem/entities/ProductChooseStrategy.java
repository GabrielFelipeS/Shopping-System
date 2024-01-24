package com.br.onlineshoppingsystem.entities;

import com.br.onlineshoppingsystem.entities.DTO.ProductsByCategoryDTO;
import com.br.onlineshoppingsystem.entities.categories.Category;

public class ProductChooseStrategy {
	
	public static ProductsByCategoryDTO getProductsByCategoryDTOBy(String id) {
		return getProductsByCategoryDTOBy(Integer.valueOf(id));
	}

	public static ProductsByCategoryDTO getProductsByCategoryDTOBy(int index) {
		var pcs = Category.values();
		
		if (index <= 0 || index > pcs.length)
			return null;

		return pcs[index - 1].getProductsByCategoryDTO();
	}

	

}
