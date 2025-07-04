# 🛒 Java E-Commerce System

A simple console-based Java application that simulates a basic e-commerce system, focusing on **product modeling**, **cart management**, **stock validation**, **shipping**, and **checkout** logic.

---

## 📦 Features

- Define `Product`s with:
  - Name, price, and quantity
  - Optional expiration date (for items like Cheese or Biscuits)
  - Optional shipping weight (for shippable items like TVs and Cheese)

- Product types include:
  - Expirable (e.g., Cheese, Biscuits)
  - Shippable (e.g., Cheese, TV)
  - Non-expirable/non-shippable (e.g., Mobile scratch cards)

- **Cart system** with validation:
  - Add product to cart with quantity
  - Reject expired items or requests beyond available stock
  - Handles product validation before addition

- **Checkout system**:
  - Computes:
    - Order subtotal
    - Shipping fees (based on product weights)
    - Total amount
    - Customer's remaining balance
  - Rejects checkout if:
    - Cart is empty
    - Any item is expired
    - Customer balance is insufficient

---

## 🧠 Domain Concepts

- `Product`: base class with `name`, `price`, and `quantity`
- `Expirable`: interface with `getExpiryDate()`
- `Shippable`: interface with `getWeight()` and `getName()`
- `Cart`: holds cart items and handles validation
- `Customer`: holds customer info and balance
- `Market`: holds product stock and exposes stock-checking methods
- `ShippingService`: calculates shipping fees for shippable products
- `CartItem`: binds a product with a user-requested quantity

---

## 🚀 How to Run

1. Make sure you have Java 8 or higher installed.
2. Compile all `.java` files:
   ```bash
   javac *.java
