package org.example.model.products;

public class Snack extends Product {
    public Snack(int amount) {
        name = "Snack";
        productionCost = 4;
        markup = 1;
        this.amount = amount;
    }
}
