package main.java.BankClient.UI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.BankClient.Network.BankClientRMI;
import main.java.BankClient.UI.ViewHandler;
import main.java.TransferedObjects.User;
import main.java.TransferedObjects.UserTypes;

import java.rmi.RemoteException;

public class AdminViewController {

    @FXML private TextField usernameTextField;
    @FXML private ComboBox<UserTypes> accountTypeTextField;
    @FXML private PasswordField passwordTextField;
    private ViewHandler viewHandler;
    private BankClientRMI clientRMI;

    public void init(ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        this.clientRMI = viewHandler.getClientRMI();

        ObservableList<UserTypes> accountTypes = FXCollections.observableArrayList();
        accountTypes.add(UserTypes.CUSTOMER);
        accountTypes.add(UserTypes.ADMINISTRATOR);
        accountTypes.add(UserTypes.CLERK);

        accountTypeTextField.setItems(accountTypes);
    }

    public void onCreateAction() throws RemoteException {
        if(usernameTextField != null && !usernameTextField.getText().equals(""))
            clientRMI.addNewUserRequest(new User(usernameTextField.getText(), passwordTextField.getText(), accountTypeTextField.getValue(), 0));
    }

    public void onLogoutAction() {
        viewHandler.openMainView();
    }
}
