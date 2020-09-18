package main.java.BankClient.UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.java.BankClient.Network.BankClientRMI;
import main.java.BankClient.UI.ViewHandler;
import java.rmi.RemoteException;

public class CustomerViewController {

    @FXML private Label warningLabel;
    @FXML private TextField amountTextField;
    private ViewHandler viewHandler;
    private BankClientRMI clientRMI;

    public void init(ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        clientRMI = viewHandler.getClientRMI();
        warningLabel.setVisible(false);
    }

    public void onWithdrawAction() throws RemoteException {
        boolean result = clientRMI.withdrawRequest(Double.parseDouble(amountTextField.getText()));
        if(!result)
            warningLabel.setVisible(true);
    }

    public void onLogoutAction() {
        viewHandler.openMainView();
    }
}
