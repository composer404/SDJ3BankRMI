package main.java.BankData;

import main.java.TransferedObjects.User;

import java.rmi.RemoteException;

public interface BankDataDAO
{
  User loginRequest(String username, String password);
  void addNewUserRequest(User user);
  void withdrawRequest(User user, double withdraw);
  void insertMoney(User user, double amount);
  double getUserBalance (String username);
}
