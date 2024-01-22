package com.br.onlineshoppingsystem.entities;

import com.br.onlineshoppingsystem.entities.categories.Category;

public class Products {
    private String name;
    private String description;
    private Double price;
    private Category category;

    public Products(){
    }

    public Products(String name, String description, Double price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
    
    public String toString() {
    	return String.format("%s - %s $.2f", this.getName(), this.getDescription(), this.getPrice());
    }
}
