package org.example.model.products;

public class Meat extends Product {
    public Meat(int amount) {
        name = "Meat";
        productionCost = 20;
        markup = 0.5;
        this.amount = amount;
    }
}
