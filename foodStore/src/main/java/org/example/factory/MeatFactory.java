package org.example.factory;

import org.example.model.products.Meat;
import org.example.model.products.Product;

public class MeatFactory implements FoodFactory {
    private static MeatFactory instance;

    private MeatFactory() {

    }

    public static synchronized MeatFactory getInstance() {
        if (instance == null) {
            instance = new MeatFactory();
        }
        return instance;
    }
    @Override
    public Product createProduct(int amount) {
        return new Meat(amount);
    }
}
