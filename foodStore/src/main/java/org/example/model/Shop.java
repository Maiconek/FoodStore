package org.example.model;

import org.example.decorator.ExpiredProduct;
import org.example.decorator.LuxuryProduct;
import org.example.factory.FoodFactory;
import org.example.model.products.Product;
import org.example.observer.Observer;
import org.example.visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Shop implements Observer {
    private static Shop instance;
    private List<Product> products;
    private List<FoodFactory> factories;

    public static double turnOver;
    private double previousTurnOver;

    private Shop() {
        products = new ArrayList<>();
        factories = new ArrayList<>();
    }

    public static synchronized Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getRandomProductFromList(List<Product> products) {
        Random random = new Random();
        Product product = products.get(random.nextInt(products.size()));
        return product;
    }

    public void updateInventory() {
        Iterator<Product> iterator = products.iterator();
        List<Product> newProducts = new ArrayList<>();
        Random random = new Random();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getAmount() == 0) {
                iterator.remove();
                FoodFactory factory = factories.get(random.nextInt(factories.size()));
                Product newProduct = factory.createProduct(3);
                newProducts.add(newProduct);
                System.out.println("Replaced " + product.getName() + " with " + newProduct.getName());
            } else if(checkIfProductExpiredOrLuxury(product)) {
                iterator.remove();
            }
        }

        products.addAll(newProducts);
    }

    public void printInventory() {
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    public void addFactory(FoodFactory factory) {
        factories.add(factory);
    }
    public double getTurnOver() {
        return turnOver;
    }

    public double getPreviousTurnOver() {
        return previousTurnOver;
    }

    public void setPreviousTurnOver() {
        previousTurnOver = turnOver;
    }

    public void adjustPrices(double inflationRate) {
        for (Product product : products) {
            product.calculatePrice(inflationRate);
        }
    }

    public void spawnLuxuryOrExpired() {
        Product product = getRandomProductFromList(products);
        Random random = new Random();
        int number = random.nextInt(2);
        if(number == 0) {
            LuxuryProduct lp = new LuxuryProduct(product);
//            System.out.println("Zrespiłem luksa " + lp.getName() + " amount " + lp.getAmount());
            addProduct(lp);
        } else {
            ExpiredProduct ep = new ExpiredProduct(product);
//            System.out.println("Zrespiłem biedaka " + ep.getName() + " amount " + ep.getAmount());
            addProduct(ep);
        }
    }

    public boolean checkIfProductExpiredOrLuxury(Product product) {
        if(product.getClass() == LuxuryProduct.class || product.getClass() == ExpiredProduct.class) {
            return true;
        }
        return false;
    }

    @Override
    public void update(double inflationRate) {
        System.out.printf("Shop: Received new inflation rate: %.2f\n", inflationRate);
        adjustPrices(inflationRate);
    }

    public void checkInflation(Visitor visitor) {
        visitor.visit(Bank.getInstance());
    }
}

