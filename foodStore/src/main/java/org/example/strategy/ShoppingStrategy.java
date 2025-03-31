package org.example.strategy;

import org.example.model.Bank;
import org.example.model.Customer;
import org.example.model.products.Product;

import java.util.List;

public interface ShoppingStrategy {
    void shop(Customer customer, List<Product> products, Bank bank);
}