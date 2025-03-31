package org.example.strategy;

import org.example.decorator.ExpiredProduct;
import org.example.decorator.LuxuryProduct;
import org.example.model.Bank;
import org.example.model.Customer;
import org.example.model.Shop;
import org.example.model.products.Product;

import java.util.List;

public class LuxuryShoppingStrategy extends AbstractShoppingStrategy {
    @Override
    public void shop(Customer customer, List<Product> products, Bank bank) {
        List<Product> luxury = filterProductsByType(products, LuxuryProduct.class, bank);
        if (!luxury.isEmpty()) {
            buyProduct(luxury.get(0), customer, bank);
        }
    }
}
