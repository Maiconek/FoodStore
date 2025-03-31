package org.example.factory;

import org.example.model.products.Fruit;
import org.example.model.products.Product;

public class FruitFactory implements FoodFactory {
    private static FruitFactory instance;

    private FruitFactory() {

    }

    public static synchronized FruitFactory getInstance() {
        if (instance == null) {
            instance = new FruitFactory();
        }
        return instance;
    }
    @Override
    public Product createProduct(int amount) {
        return new Fruit(amount);
    }
}
