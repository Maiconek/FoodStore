package org.example.decorator;

import org.example.model.products.Product;

public abstract class ProductDecorator extends Product {
    protected Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public String getName() {
        return decoratedProduct.getName();
    }

    @Override
    public double getProductionCost() {
        return decoratedProduct.getProductionCost();
    }

    @Override
    public double getMarkup() {
        return decoratedProduct.getMarkup();
    }

    @Override
    public int getAmount() {
        return decoratedProduct.getAmount();
    }

    @Override
    public void setAmount(int amount) {
         this.amount = amount;
    }


    @Override
    public double calculatePrice(double inflationRate) {
        return decoratedProduct.calculatePrice(inflationRate);
    }
}