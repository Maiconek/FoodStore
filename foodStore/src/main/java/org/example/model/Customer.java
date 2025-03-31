package org.example.model;

import org.example.model.products.Product;
import org.example.observer.Observer;
import org.example.strategy.ShoppingStrategy;

import java.util.List;

public class Customer implements Observer {
    private String name;
    private double budget;
    private double startBudget;
    private ShoppingStrategy shoppingStrategy;
    private Bank bank;


    public Customer(String name, double budget, ShoppingStrategy shoppingStrategy) {
        this.name = name;
        this.budget = budget;
        this.shoppingStrategy = shoppingStrategy;
        this.bank = Bank.getInstance();
    }

    public void shop(List<Product> products) {
        startBudget = budget;
//        System.out.println(startBudget);
        shoppingStrategy.shop(this, products, bank);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void calculateBudget(double inflationRate) {
        if(bank.getPreviousInflationRate() > bank.getInflationRate()) {
            setBudget(startBudget - (startBudget * inflationRate));
        } else {
            setBudget(startBudget + (startBudget * inflationRate));
        }

    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public ShoppingStrategy getShoppingStrategy() {
        return shoppingStrategy;
    }

    public void setShoppingStrategy(ShoppingStrategy shoppingStrategy) {
        this.shoppingStrategy = shoppingStrategy;
    }

    @Override
    public void update(double inflationRate) {
        calculateBudget(inflationRate);
    }
}
