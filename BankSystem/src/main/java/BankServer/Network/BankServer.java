package main.java.BankServer.Network;

import main.java.TransferedObjects.User;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankServer extends Remote {
    User loginRequest(String username, String password) throws RemoteException;
    void addNewUserRequest(User newUser) throws RemoteException;
    boolean withdrawRequest(User user, double withdraw) throws RemoteException;
    void insertMoney(User user, double amount) throws RemoteException;
}
