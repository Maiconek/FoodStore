package org.example.visitor;

import org.example.model.Bank;

public interface Visitor {
    void visit(Bank bank);
}
