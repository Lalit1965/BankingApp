# BankingApp
## Console-Based Banking Application - README

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
│   ├── utils/          # DBConnection.java, InputValidator.java
│   └── sql/            # BankApp.sql (database setup)
├── .gitignore
└── README.md
```
---

## 🚀 Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

* Java Development Kit (JDK) 11 or higher
* MySQL Server
* An IDE like IntelliJ IDEA or VS Code

### Installation & Setup

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/Lalit1965/BankingApp.git](https://github.com/Lalit1965/BankingApp.git)
    cd BankingApp
    ```

2.  **Set up the MySQL Database:**
    * Open your MySQL client and create a new database named `bank`.
        ```sql
        CREATE DATABASE bank;
        ```
    * Run the script located at `src/sql/BankApp.sql` to create the required tables.

3.  **Configure Database Connection:**
    * Open the file `src/main/java/org/example/utils/DBConnection.java`.
    * Update the `USER` and `PASSWORD` fields with your local MySQL username and password.

4.  **Run the Application:**
    * Open the project in your IDE.
    * Locate and run the `Main.java` file.

---

## 💻 Usage

Once the application is running, you will see a menu in the console. Follow the on-screen prompts:

* **Create Account**: Enter a unique account number, the account holder's name, and an initial deposit amount.
* **Deposit**: Provide the account number and the amount you wish to deposit.
* **Withdraw**: Provide the account number and the amount to withdraw. The transaction will fail if funds are insufficient.
* **List Accounts**: Displays a formatted table of all accounts and their balances.
