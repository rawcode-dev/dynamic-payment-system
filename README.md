# 💳 Dynamic Payment System - MVP 2

A Spring Boot backend project demonstrating **Strategy Design Pattern** in a realistic, extensible payment system. This is the **MVP 2 (Minimum Viable Product)** version of the system, where different payment methods are supported via request-specific DTOs and mapped to their respective strategies in a type-safe, production-style architecture.

---

## 🚀 MVP 2 Features

✅ Process payments through multiple payment methods  
✅ Handles payment logic based on dynamic strategy resolution  
✅ Uses DTO-specific strategies (e.g., Credit Card, UPI, PayPal)  
✅ Clean architecture, pluggable strategies  
✅ Built with extensibility and real-world design patterns

---

## 🧠 Design Patterns Used

### 🧩 Strategy Design Pattern
Each payment method has its own `PaymentStrategy<T extends PaymentRequestDto>`, making logic for each method isolated and extensible.

### 🧰 Registry-Based Strategy Lookup
A custom `PaymentStrategyRegistry` maps each DTO type (e.g., `CreditCardRequestDto`) to its strategy, avoiding casting and maintaining type safety.

---

