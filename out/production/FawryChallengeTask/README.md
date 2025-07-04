# 🛒 Java E-Commerce System

A simple console-based Java application that simulates a basic e-commerce system, focusing on **product modeling**, **cart management**, **stock validation**, **shipping**, and **checkout** logic.

---

## 📦 Features

- Define `Components.Product.Product`s with:
  - Name, price, and quantity
  - Optional expiration date (for items like Components.Concrete.Cheese or Biscuits)
  - Optional shipping weight (for shippable items like TVs and Components.Concrete.Cheese)

- Components.Product.Product types include:
  - Expirable (e.g., Components.Concrete.Cheese, Biscuits)
  - Shippable (e.g., Components.Concrete.Cheese, Components.Concrete.TV)
  - Non-expirable/non-shippable (e.g., Mobile scratch cards)

- **Components.Cart.Cart system** with validation:
  - Add product to cart with quantity
  - Reject expired items or requests beyond available stock
  - Handles product validation before addition

- **Checkout system**:
  - Computes:
    - Order subtotal
    - Shipping fees (based on product weights)
    - Total amount
    - Components.Customer.Customer's remaining balance
  - Rejects checkout if:
    - Components.Cart.Cart is empty
    - Any item is expired
    - Components.Customer.Customer balance is insufficient

---

## 🧠 Domain Concepts

- `Components.Product.Product`: base class with `name`, `price`, and `quantity`
- `Expirable`: interface with `getExpiryDate()`
- `Shippable`: interface with `getWeight()` and `getName()`
- `Components.Cart.Cart`: holds cart items and handles validation
- `Components.Customer.Customer`: holds customer info and balance
- `Components.Market.Market`: holds product stock and exposes stock-checking methods
- `Components.ShippingService.ShippingService`: calculates shipping fees for shippable products
- `CartItem`: binds a product with a user-requested quantity

---

## 🚀 How to Run

1. Make sure you have Java 8 or higher installed.
2. Compile all `.java` files:
   ```bash
   javac *.java
