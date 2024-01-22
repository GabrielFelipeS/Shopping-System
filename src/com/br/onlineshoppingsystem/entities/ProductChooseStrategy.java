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
    	if(index <= 0) throw new IndexOutOfBoundsException("out of bounds for getProductsByCategoryDTOBy");
    	
    	return ProductChooseStrategy.values()[index - 1].getProductsByCategoryDTO();	
    }
    
    
    private ProductsByCategoryDTO getProductsByCategoryDTO() {
    	return productsByCategoryDTO;
    }
	

    // Outros métodos, se necessário...
}
