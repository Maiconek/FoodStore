package org.example.decorator;

import org.example.model.products.Product;

public class LuxuryProduct extends ProductDecorator {
    private static final double LUXURY_MARKUP = 1.5; // Dodatkowy markup dla produktu luksusowego

    public LuxuryProduct(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public double calculatePrice(double inflationRate) {
        // Dodajemy dodatkowy markup dla produktu luksusowego
        double productionCost = decoratedProduct.getProductionCost();
        double markup = decoratedProduct.getMarkup();
        return (productionCost * 2) * (1 + inflationRate) * (1 + (markup * 1.5));
    }
}
