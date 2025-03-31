package org.example.model.products;

public class Fruit extends Product {
    public Fruit(int amount) {
        name = "Orange";
        productionCost = 4;
        markup = 1;
        this.amount = amount;
    }
}
