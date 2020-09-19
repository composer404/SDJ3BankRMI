package main.java.BankServer.BusinessLogic;

import main.java.BankData.BankDataDAO;
import main.java.TransferedObjects.User;
import main.java.TransferedObjects.UserTypes;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    private BankDataDAO bankDataDAO;

    public Operations(BankDataDAO bankDataDAO)
    {
        this.bankDataDAO = bankDataDAO;
    }

    public User getUser(String username, String password)
    {
        return bankDataDAO.loginRequest(username, password);
    }

    public void addNewUser(User newUser)
    {
        bankDataDAO.addNewUserRequest(newUser);
    }

    public boolean withdrawMoney(User user, double withdraw) {
        double currentUserBalance = bankDataDAO.getUserBalance(user.getUsername());
        if (currentUserBalance < withdraw)
            return false;
        else
        {
            bankDataDAO.withdrawRequest(user, withdraw);
            return true;
        }
    }

    public void insertMoney(User user, double amount) {
        bankDataDAO.insertMoney(user, amount);
    }
}
