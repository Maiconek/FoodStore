package org.example.factory;

import org.example.model.products.Drink;
import org.example.model.products.Product;

public class DrinkFactory implements FoodFactory {
    private static DrinkFactory instance;

    private DrinkFactory() {

    }

    public static synchronized DrinkFactory getInstance() {
        if (instance == null) {
            instance = new DrinkFactory();
        }
        return instance;
    }
    @Override
    public Product createProduct(int amount) {
        return new Drink(amount);
    }
}
