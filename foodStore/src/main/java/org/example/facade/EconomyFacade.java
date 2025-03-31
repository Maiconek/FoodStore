package org.example.facade;

import org.example.factory.FoodFactory;
import org.example.model.Bank;
import org.example.model.Customer;
import org.example.model.Shop;
import org.example.model.products.Product;
import org.example.visitor.InflationVisitor;
import org.example.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class EconomyFacade {
    private Bank bank;
    private Shop shop;
    private List<Customer> customers;

    public EconomyFacade() {
        this.bank = Bank.getInstance();
        this.shop = Shop.getInstance();
        this.customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        bank.addObserver(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        bank.removeObserver(customer);
    }

    public void checkInflation() {
        InflationVisitor visitor = new InflationVisitor(bank.getInflationRate());
        shop.checkInflation(visitor);
    }

    public void calculateTaxRevenue() {
        bank.calculateTaxRevenue();
    }

    public void addProduct(Product product) {
        shop.addProduct(product);
    }

    public List<Product> getProducts() {
        return shop.getProducts();
    }

    public void addFactory(FoodFactory factory) {
        shop.addFactory(factory);
    }


    public void shop(Customer customer, List<Product> products) {
        customer.shop(products);
    }

    public void spawnLuxuryOrExpired() {
        shop.spawnLuxuryOrExpired();
    }

    public void updateShopInventory() {
        shop.updateInventory();
    }

    public void printShopInventory() {
        shop.printInventory();
    }

    public void showShopTurnover() {
        shop.setPreviousTurnOver();
        System.out.printf("Sklep zarobil: %.2f\n", Shop.turnOver);
        Shop.turnOver = 0;
    }

}
