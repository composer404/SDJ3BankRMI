package main.java.BankServer;

import main.java.BankServer.Network.BankServer;
import main.java.BankServer.Network.BankServerImplementation;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        BankServer bankServer = new BankServerImplementation();
        Registry registry = LocateRegistry.createRegistry(2910);
        registry.bind("Server", bankServer);
        System.out.println("Server is starting...");
    }
}
