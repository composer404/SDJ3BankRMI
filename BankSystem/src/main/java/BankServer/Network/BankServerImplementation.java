package main.java.BankServer.Network;

import main.java.BankData.BankDataDAOImpl;
import main.java.BankServer.BusinessLogic.Operations;
import main.java.TransferedObjects.User;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankServerImplementation implements BankServer{

    private Operations dataManager;

    public BankServerImplementation() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        dataManager = new Operations(new BankDataDAOImpl());
    }

    @Override
    public User loginRequest(String username, String password) {
        return dataManager.getUser(username, password);
    }

    @Override
    public void addNewUserRequest(User newUser) throws RemoteException {
        dataManager.addNewUser(newUser);
    }

    @Override
    public boolean withdrawRequest(User user, double withdraw) throws RemoteException {
        return dataManager.withdrawMoney(user, withdraw);
    }

    @Override
    public void insertMoney(User user, double amount) throws RemoteException {
        dataManager.insertMoney(user, amount);
    }
}
