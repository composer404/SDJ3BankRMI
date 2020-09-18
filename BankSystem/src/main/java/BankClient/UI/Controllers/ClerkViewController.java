package main.java.BankClient.UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.java.BankClient.Network.BankClientRMI;
import main.java.BankClient.UI.ViewHandler;

import java.rmi.RemoteException;

public class ClerkViewController {

    @FXML private Label warningLabel;
    @FXML private TextField amountTextField;
    private BankClientRMI clientRMI;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler)
    {
        warningLabel.setVisible(false);
        this.viewHandler = viewHandler;
        clientRMI = viewHandler.getClientRMI();
    }

    public void onWithdrawAction() throws RemoteException {
        boolean result = clientRMI.withdrawRequest(Double.parseDouble(amountTextField.getText()));
        if(!result)
            warningLabel.setVisible(true);

    }

    public void onInsertAction() throws RemoteException {
        clientRMI.insertMoney(Double.parseDouble(amountTextField.getText()));
    }

    public void onLogoutAction() {
        viewHandler.openMainView();
    }
}
