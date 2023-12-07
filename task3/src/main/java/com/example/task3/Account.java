package com.example.task3;

public class Account {
    private int id; //Account number or id
    private double balance; //Account balance
    private static double annualInterestRate = 0;
    private final java.util.Date dateCreated; //Date of account opening

    public Account() {
        dateCreated = new java.util.Date();
    }

    //Constructor which takes in account number and balance as parameters
    public Account(int newId, double newBalance) {
        id = newId;
        balance = newBalance;
        dateCreated = new java.util.Date();
    }

    //Getter function which returns account id
    public int getId() {
        return id;
    }

    //Getter function to obtain account balance
    public double getBalance() {
        return balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;

    }

    //Setter function to set account id
    public void setId(int newId) {
        id = newId;
    }

    //Setter function to set account balance
    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 1200);
    }

    //This function returns the date of account creation
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    //This function is used to withdraw amount and reduce the balance
    public void withdraw(double amount) {
        balance -= amount;
    }
    //This function is used to deposit money and increase the balance
    public void deposit(double amount) {
        balance += amount;
    }
}
