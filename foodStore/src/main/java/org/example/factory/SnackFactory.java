package org.example.factory;

import org.example.model.products.Product;
import org.example.model.products.Snack;

public class SnackFactory implements FoodFactory {
    private static SnackFactory instance;

    private SnackFactory() {

    }

    public static synchronized SnackFactory getInstance() {
        if (instance == null) {
            instance = new SnackFactory();
        }
        return instance;
    }
    @Override
    public Product createProduct(int amount) {
        return new Snack(amount);
    }
}
