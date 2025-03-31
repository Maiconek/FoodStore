package org.example.visitor;

import org.example.model.Bank;

public class InflationVisitor implements Visitor {
    private double inflationRate;

    public InflationVisitor(double inflationRate) {
        this.inflationRate = inflationRate;
    }

    @Override
    public void visit(Bank bank) {
        bank.update(inflationRate);
    }
}
