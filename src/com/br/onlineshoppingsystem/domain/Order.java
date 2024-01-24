package com.br.onlineshoppingsystem.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.br.onlineshoppingsystem.model.entities.ShoppingCartItems;

public class Order {
    private List<ShoppingCartItems> productsShoppingCart;
    private Customer customer;
    private LocalDateTime orderDate;
    private Double orderTotal;

    public Order(List<ShoppingCartItems> productsShoppingCart, Customer customer, LocalDateTime orderDate, Double orderTotal) {

        this.productsShoppingCart = productsShoppingCart;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    public List<ShoppingCartItems> getProducts() {
        return productsShoppingCart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public boolean paymentValidate(int choose){
        return choose > 0 && choose <= 4;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }
}
