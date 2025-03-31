package org.example.strategy;

import org.example.model.Bank;
import org.example.model.Customer;
import org.example.model.Shop;
import org.example.model.products.Product;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractShoppingStrategy implements ShoppingStrategy {
    protected List<Product> filterProductsByType(List<Product> products, Class<?> productType, Bank bank) {
        return products.stream()
                .filter(productType::isInstance)
                .collect(Collectors.toList());
    }

    protected void buyProduct(Product product, Customer customer, Bank bank) {
        if (product.calculatePrice(bank.getInflationRate()) <= customer.getBudget() && product.getAmount() > 0) {
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

