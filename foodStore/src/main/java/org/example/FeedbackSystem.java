package org.example;

import org.example.facade.EconomyFacade;
import org.example.model.Customer;


public class FeedbackSystem {
    private final EconomyFacade economyFacade;

    public FeedbackSystem(EconomyFacade economyFacade) {
        this.economyFacade = economyFacade;
    }

    public void run(int numIterations) {
        for(int i = 0; i < numIterations; i++) {
            System.out.println("\nTura => " + (i + 1));
            economyFacade.spawnLuxuryOrExpired();

            for(Customer customer : economyFacade.getCustomers()) {
                economyFacade.shop(customer, economyFacade.getProducts());
            }

            economyFacade.calculateTaxRevenue();
            economyFacade.updateShopInventory();
            economyFacade.checkInflation();
            economyFacade.showShopTurnover();
        }
    }
}
