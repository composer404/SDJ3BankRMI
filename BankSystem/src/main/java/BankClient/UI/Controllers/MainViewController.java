package main.java.BankClient.UI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.BankClient.Network.BankClientRMI;
import main.java.BankClient.UI.ViewHandler;
import main.java.TransferedObjects.LoggedUser;
import main.java.TransferedObjects.User;
import main.java.TransferedObjects.UserTypes;

import java.rmi.RemoteException;

public class MainViewController {

    @FXML private Label warningLabel;
    @FXML private TextField loginTextField;
    @FXML private PasswordField passwordTextField;

    private ViewHandler viewHandler;
    private BankClientRMI clientRMI;
    private LoggedUser loggedUser;

   public void init(ViewHandler viewHandler)
   {
       this.viewHandler = viewHandler;
       warningLabel.setVisible(false);
       this.clientRMI = viewHandler.getClientRMI();
       loggedUser = LoggedUser.getLoggedUser();
   }

    public void onLoginAction() throws RemoteException {
        User user = clientRMI.loginRequest(loginTextField.getText(), passwordTextField.getText());
        if(user != null)
            loggedUser.login(user);
        if(user != null && user.getType() == UserTypes.ADMINISTRATOR)
            viewHandler.openAdminView();
        if(user != null && user.getType() == UserTypes.CUSTOMER)
            viewHandler.openCustomerView();
        if(user != null && user.getType() == UserTypes.CLERK)
            viewHandler.openClerkView();
        else
            warningLabel.setVisible(true);
    }
}
