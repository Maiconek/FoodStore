package org.example.factory;

import org.example.model.products.Product;

public interface FoodFactory {
    Product createProduct(int amount);
}
