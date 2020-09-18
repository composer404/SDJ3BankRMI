package main.java.BankClient.Network;

import main.java.BankServer.Network.BankServer;
import main.java.TransferedObjects.LoggedUser;
import main.java.TransferedObjects.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BankClientRMI {

    BankServer server;

    public void startClient()throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 2910);
        server = (BankServer) registry.lookup("Server");

    }

    public User loginRequest(String username, String password) throws RemoteException {
        return server.loginRequest(username, password);
    }

    public void addNewUserRequest(User newUser) throws RemoteException {
        server.addNewUserRequest(newUser);
    }

    public boolean withdrawRequest(double withdraw) throws RemoteException {
        return server.withdrawRequest(LoggedUser.getLoggedUser().getUser(), withdraw);
    }

    public void insertMoney(double amount) throws RemoteException {
        server.insertMoney(LoggedUser.getLoggedUser().getUser(), amount);
    }
}
