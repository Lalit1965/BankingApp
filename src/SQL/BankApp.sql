-- Use your database, create if not exists
CREATE DATABASE IF NOT EXISTS bank;
USE bank;

-- Drop old tables if they exist
DROP TABLE IF EXISTS Transactions;
DROP TABLE IF EXISTS Accounts;

-- Create Accounts table (user-provided account numbers)
CREATE TABLE Accounts (
  accountNumber INT NOT NULL PRIMARY KEY,
  accountHolder VARCHAR(100) NOT NULL,
  balance DOUBLE NOT NULL
);

-- Create Transactions table
CREATE TABLE Transactions (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  accountNumber INT NOT NULL,
  type VARCHAR(20) NOT NULL,
  amount DOUBLE NOT NULL,
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (accountNumber) REFERENCES Accounts(accountNumber)
);

-- Insert a test account with a specific account number
INSERT INTO Accounts (accountNumber, accountHolder, balance) VALUES (1, 'Test', 1000);

-- Verify accounts table
SELECT * FROM Accounts;

-- Verify transactions table (should be empty)
SELECT * FROM Transactions;
