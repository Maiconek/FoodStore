package org.example.strategy;

import org.example.decorator.ExpiredProduct;
import org.example.decorator.ProductDecorator;
import org.example.model.Bank;
import org.example.model.Customer;
import org.example.model.Shop;
import org.example.model.products.Drink;
import org.example.model.products.Product;

import java.util.List;

public class ExpiredShoppingStrategy extends AbstractShoppingStrategy {
    @Override
    public void shop(Customer customer, List<Product> products, Bank bank) {
//        System.out.println(products);
        List<Product> expired = filterProductsByType(products, ExpiredProduct.class, bank);
        if (!expired.isEmpty()) {
            buyProduct(expired.get(0), customer, bank);
        } else {
            return;
        }
    }
}
