package com.br.onlineshoppingsystem.model.entities.categories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.br.onlineshoppingsystem.model.entities.Products;
import com.br.onlineshoppingsystem.model.enums.Category;

public class Eletronics extends Products {
    private List<Products> eletronics = new ArrayList<>(Arrays.asList(
            new Products("Laptop", "High-performance laptop for work and gaming.", 999.99, Category.ELETRONICS),
            new Products("Smartphone", "The latest smartphone with advanced features.", 699.99, Category.ELETRONICS),
            new Products("Headphones", "Noise-canceling headphones for immersive audio.", 149.99, Category.ELETRONICS)
    ));
    
    public Eletronics() {
    }


    // TODO Refactoring
    /*
    public Eletronics(String name, String description, Double price, Category category, List<Products> eletronics) {
        super(name, description, price, category);
        this.eletronics = eletronics;
    }
    */
    
    public List<Products> getEletronics() {
        return eletronics;
    }
}
