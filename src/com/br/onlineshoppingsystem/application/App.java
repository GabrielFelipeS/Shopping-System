package com.br.onlineshoppingsystem.application;

import java.util.Locale;

import com.br.onlineshoppingsystem.controller.ShoppingSystemController;


public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        ShoppingSystemController shoppingSystem = new ShoppingSystemController();
        shoppingSystem.run();

    }
}
