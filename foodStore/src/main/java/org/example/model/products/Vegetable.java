package org.example.model.products;

public class Vegetable extends Product {
    public Vegetable(int amount) {
        name = "Broccoli";
        productionCost = 2;
        markup = 1;
        this.amount = amount;
    }
}
