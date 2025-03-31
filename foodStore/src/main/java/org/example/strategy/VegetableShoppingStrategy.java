package org.example.strategy;

import org.example.model.*;
import org.example.model.products.Product;
import org.example.model.products.Vegetable;

import java.util.List;

public class VegetableShoppingStrategy extends AbstractShoppingStrategy {
    @Override
    public void shop(Customer customer, List<Product> products, Bank bank) {
        List<Product> vegetables = filterProductsByType(products, Vegetable.class, bank);

        // Implementacja zakupów szukających nowości
        if (!vegetables.isEmpty()) {
            buyProduct(vegetables.get(0), customer, bank);
        } else {
            return;
        }
    }
}
