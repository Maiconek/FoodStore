package org.example;

import org.example.decorator.ExpiredProduct;
import org.example.decorator.LuxuryProduct;
import org.example.facade.EconomyFacade;
import org.example.factory.*;
import org.example.model.*;
import org.example.model.products.Drink;
import org.example.model.products.Meat;
import org.example.model.products.Product;
import org.example.model.products.Vegetable;
import org.example.strategy.*;
import org.example.visitor.InflationVisitor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EconomyFacade economyFacade = new EconomyFacade();

        // inicjalizacja sklepu
        MeatFactory meatFactory = MeatFactory.getInstance();
        SnackFactory snackFactory = SnackFactory.getInstance();
        VegetableFactory vegetableFactory = VegetableFactory.getInstance();
        FruitFactory fruitFactory = FruitFactory.getInstance();
        DrinkFactory drinkFactory = DrinkFactory.getInstance();

        economyFacade.addProduct(meatFactory.createProduct(5));
        economyFacade.addProduct(snackFactory.createProduct(5));
        economyFacade.addProduct(vegetableFactory.createProduct(5));
        economyFacade.addProduct(fruitFactory.createProduct(5));
        economyFacade.addProduct(drinkFactory.createProduct(5));

        economyFacade.addFactory(meatFactory);
        economyFacade.addFactory(snackFactory);
        economyFacade.addFactory(vegetableFactory);
        economyFacade.addFactory(fruitFactory);
        economyFacade.addFactory(drinkFactory);

        // inicjalizacja klientów
        VegetableShoppingStrategy vs = new VegetableShoppingStrategy();
        DrinkShoppingStrategy ds = new DrinkShoppingStrategy();
        DefaultStrategy df = new DefaultStrategy();
        ExpiredShoppingStrategy es = new ExpiredShoppingStrategy();
        LuxuryShoppingStrategy lp = new LuxuryShoppingStrategy();

        Customer michal = new Customer("Michal", 100, df);
        Customer albert = new Customer("Albert", 70, df);
        Customer franek = new Customer("Franek", 10, df);
        Customer janek = new Customer("Janek", 100, vs);
        Customer dawid = new Customer("Dawid", 60, ds);
        Customer poor = new Customer("Orzel", 10, es);
        Customer luxury = new Customer("Robert", 500, lp);

        economyFacade.addCustomer(michal);
        economyFacade.addCustomer(albert);
        economyFacade.addCustomer(franek);
        economyFacade.addCustomer(janek);
        economyFacade.addCustomer(dawid);
        economyFacade.addCustomer(poor);
        economyFacade.addCustomer(luxury);


        // inicjalizacja FeedbackSystem
        FeedbackSystem fs = new FeedbackSystem(economyFacade);
        fs.run(20);
    }
}

// Singleton (done)
// Factory (done)
// Dekorator (done)
// Fasada (done)
// Strategia (done)
// Obserwator (done)
// Visitor (done)
