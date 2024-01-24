package com.br.onlineshoppingsystem.model.entities.categories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.br.onlineshoppingsystem.model.entities.Products;
import com.br.onlineshoppingsystem.model.enums.Category;

public class Books extends Products {

    // Default storage
    private List<Products> books = new ArrayList<>(Arrays.asList(
            new Products("To Kill a Mockingbird by Harper Lee", "A classic novel that addresses issues of racism and moral growth in the American South.", 12.99, Category.BOOKS),
            new Products("The Great Gatsby by F. Scott Fitzgerald", "A novel set in the 1920s, exploring themes of wealth, excess, and the American Dream.", 10.49, Category.BOOKS),
            new Products("Becoming by Michelle Obama", "A memoir by the former First Lady, recounting her personal journey and experiences in the White House.", 18.99, Category.BOOKS)
    ));


    public Books() {
    }
    
    // TODO Refactoring
/*
    public Books(String name, String description, Double price, List<Products> books) {
        super(name, description, price, Category.BOOKS);
        this.books = books;
    }
*/
    public List<Products> getBooks() {
        return books;
    }
}
