# BankingApp
# Console-Based Banking Application - README

## Project Overview
A console-based banking application written in **Java** using **JDBC** to interact with a **MySQL** database.  
Simulates real-world banking operations with features like account creation, deposits, withdrawals, and account listing, while demonstrating **OOP**, **data persistence**, and **input validation**.

---

## Features

### User Features
- Create bank accounts with account number, holder name, and initial deposit.  
- Deposit money into existing accounts with validation checks.  
- Withdraw money with insufficient balance protection.  
- List all bank accounts with current balances.  

### Admin / System Features
- Persistent storage of accounts and transactions using MySQL.  
- Input validation for positive transaction amounts.  
- Transaction logging for deposits and withdrawals.  

---

## Technology Stack
- **Language:** Java  
- **Database:** MySQL  
- **Database Access:** JDBC  
- **Development Tools:** IntelliJ IDEA, Git  
- **Concepts:** Object-Oriented Programming (OOP), Data Structures, Version Control, Exception Handling  

---

## Project Structure

```text
BankingApp/
├── src/
│   ├── main/           # Main application entry point (Main.java)
│   ├── model/          # BankAccount.java, Transaction.java
│   ├── service/        # AccountService.java, TransactionService.java
│   └── utils/          # DBConnection.java, InputValidator.java
├── .gitignore
└── README.md
│── README.md
