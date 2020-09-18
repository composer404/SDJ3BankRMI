package main.java.TransferedObjects;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private UserTypes type;
    private double balance;

    public User(String username,String password, UserTypes type, int balance)
    {
        this.username = username;
        this.password = password;
        this.type = type;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserTypes getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public void withdrawMoney(double amount){
        balance -= amount;
    }

    public void insertMoney(double amount){
        balance += amount;
    }
}
