package org.example.model.products;

public class Drink extends Product{
    public boolean sparkling;

    public Drink(int amount) {
        name = "Coca Cola";
        productionCost = 10;
        markup = 1;
        this.amount = amount;
        sparkling = true;
    }
}
