package main.java.BankClient;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.BankClient.Network.BankClientRMI;
import main.java.BankClient.UI.ViewHandler;

public class BankClientApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        System.setProperty("java.security.policy", "security.policy");

        //if (System.getSecurityManager() == null)
         //   System.setSecurityManager(new RMISecurityManager());

        BankClientRMI clientRMI = new BankClientRMI();
        ViewHandler viewHandler = new ViewHandler(clientRMI);

        clientRMI.startClient();
        viewHandler.start();
    }
}
