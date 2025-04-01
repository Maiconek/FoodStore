# FoodStore
This project was developed as part of the "Design Patterns" course in university.

## Overview

FoodStore is a food store economy simulation in which three primary entities interact with each other:

1. **Store** - sells and produces new products every round. It verifies inflation at the beginning of every round to adjust its prices according to that.
2. **Bank** - regulates inflation and monitors store revenue. If the store sells fewer in a round than it did in the previous one, the bank decreases inflation. If the store sells more, inflation increases.
3. **Customer** - has a list of products to buy and follows a specific buying plan. Each customer has a specific budget and may decide not to buy if product prices exceed that budget.

## Design Patterns Implemented

The following design patterns are used in the project:

- **Singleton** - Ensures a single instance of significant components such as the Bank.
- **Abstract Factory** - Provides an interface to produce different types of products.
- **Facade** - Enables complex interactions among the Store, Bank, and Customers.
- **Observer** - Enables objects to react to changing inflation dynamically.
- **Strategy** - Defines different buying strategies for customers.
- **Decorator** - Adds or changes product attributes dynamically.


