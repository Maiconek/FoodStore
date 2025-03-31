package org.example.factory;

import org.example.model.products.Product;
import org.example.model.products.Vegetable;

public class VegetableFactory implements FoodFactory {
    private static VegetableFactory instance;

    private VegetableFactory() {

    }

    public static synchronized VegetableFactory getInstance() {
        if (instance == null) {
            instance = new VegetableFactory();
        }
        return instance;
    }
    @Override
    public Product createProduct(int amount) {
        return new Vegetable(amount);
    }
}
