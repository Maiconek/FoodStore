package org.example.strategy;

import org.example.model.Bank;
import org.example.model.Customer;
import org.example.model.Shop;
import org.example.model.products.Drink;
import org.example.model.products.Product;

import java.util.List;

public class DrinkShoppingStrategy extends AbstractShoppingStrategy {
    @Override
    public void shop(Customer customer, List<Product> products, Bank bank) {
        List<Product> drinks = filterProductsByType(products, Drink.class, bank);

        // Implementacja zakupów szukających nowości
        if (!drinks.isEmpty()) {
            buyProduct(drinks.get(0), customer, bank);
        } else {
            return;
        }
    }
}
