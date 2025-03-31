package org.example.decorator;

public interface ProductInterface {
    String getName();
    double getProductionCost();
    double getMarkup();
    int getAmount();
    void setAmount(int amount);
    double calculatePrice(double inflationRate);
}