package org.example.model;

import org.example.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank implements Observer {
    private static Bank instance;
    private double inflationRate;
    private double previousInflationRate;
    private double taxRevenue;
    private double previousTaxRevenue;
    private List<Observer> observers;
    private Shop shop;

    public Bank(double inflationRate) {
        this.inflationRate = inflationRate;
        observers = new ArrayList<>();
        shop = Shop.getInstance();
    }

    public static synchronized Bank getInstance() {
        if (instance == null) {
            instance = new Bank(0.1);
        }
        return instance;
    }

    public double getInflationRate() {
        return inflationRate;
    }

    public double getPreviousInflationRate() {
        return previousInflationRate;
    }

    public void calculateTaxRevenue() {
        previousTaxRevenue = taxRevenue * (1 + inflationRate - previousInflationRate);
        taxRevenue = inflationRate * Shop.turnOver;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(inflationRate);
        }
    }

    @Override
    public void update(double newInflationRate) {
        Random random = new Random();
        previousInflationRate = inflationRate;
        int n = random.nextInt(2);
        if(previousTaxRevenue > taxRevenue) {
            this.inflationRate = newInflationRate * 1.01;
            System.out.println("Bank: Updating inflation rate to " + this.inflationRate);
        } else {
            this.inflationRate = newInflationRate * 0.99;
            System.out.println("Bank: Updating inflation rate to " + this.inflationRate);

        }

        notifyObservers();
    }

}
