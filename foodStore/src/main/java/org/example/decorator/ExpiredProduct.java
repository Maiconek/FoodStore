package org.example.decorator;

import org.example.model.products.Product;

public class ExpiredProduct extends ProductDecorator {
    private static final double DISCOUNT = 0.5; // Zniżka dla przeterminowanego produktu

    public ExpiredProduct(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public double calculatePrice(double inflationRate) {
        double productionCost = decoratedProduct.getProductionCost();
        double markup = decoratedProduct.getMarkup();
        return (productionCost * 0.5) * (1 + inflationRate) * (1 + (markup * 0.5));
    }

}
