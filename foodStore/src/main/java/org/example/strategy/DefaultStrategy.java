package org.example.strategy;

import org.example.model.Bank;
import org.example.model.Customer;
import org.example.model.Shop;
import org.example.model.products.Drink;
import org.example.model.products.Product;

import java.util.List;
import java.util.Random;

public class DefaultStrategy implements ShoppingStrategy {
    @Override
    public void shop(Customer customer, List<Product> products, Bank bank) {
        Random random = new Random();
        Product product = products.get(random.nextInt(products.size()));
        if (product.calculatePrice(bank.getInflationRate()) <= customer.getBudget()) {
            customer.setBudget(customer.getBudget() - product.calculatePrice(bank.getInflationRate()));
            Shop.turnOver += product.calculatePrice(bank.getInflationRate());
            product.setAmount(product.getAmount() - 1);
            System.out.println(customer.getName() + " Bought: " + product.getName());
            System.out.printf("Remaining budget: $%.2f\n", customer.getBudget());
        } else {
            System.out.println(customer.getName() + " bought nothing");
        }
    }
}
