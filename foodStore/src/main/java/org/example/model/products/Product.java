package org.example.model.products;

import org.example.decorator.ProductInterface;

public abstract class Product implements ProductInterface {
    protected String name;
    protected double productionCost;
    protected double markup;
    protected int amount;
    protected double price;

//    public Product(String name, double productionCost, double markup) {
//        this.name = name;
//        this.productionCost = productionCost;
//        this.markup = markup;
//    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getProductionCost() {
        return productionCost;
    }

    @Override
    public double getMarkup() {
        return markup;
    }

    @Override
    public int getAmount() {
        return amount;
    }
    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public double calculatePrice(double inflationRate) {
        return productionCost * (1 + inflationRate) * (1 + markup);
    }


}
