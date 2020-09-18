package main.java.BankClient.UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.BankClient.Network.BankClientRMI;
import main.java.BankClient.UI.Controllers.AdminViewController;
import main.java.BankClient.UI.Controllers.ClerkViewController;
import main.java.BankClient.UI.Controllers.CustomerViewController;
import main.java.BankClient.UI.Controllers.MainViewController;

import java.io.IOException;

public class ViewHandler {

    private BankClientRMI clientRMI;
    private Stage mainStage;
    private Scene mainScene;
    private FXMLLoader loader;

    private MainViewController mainController;
    private AdminViewController adminController;
    private ClerkViewController clerkViewController;
    private CustomerViewController customerViewController;

    public ViewHandler(BankClientRMI clientRMI)
    {
        this.clientRMI = clientRMI;
    }


    public void start()
    {
        mainStage = new Stage();
        openMainView();
    }

    public void openMainView()
    {
        try
        {
            loader= new FXMLLoader(getClass().getClassLoader().getResource("fxml/MainView.fxml"));
            Parent root = loader.load();


            mainController = loader.getController();
            mainController.init(this);
            mainStage.setTitle("Simple Bank RMI System");
            mainScene = new Scene(root);


        } catch (IOException e) {
            e.printStackTrace();
        }
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    public void openAdminView() {
        try
        {
            loader= new FXMLLoader(getClass().getClassLoader().getResource("fxml/AdminView.fxml"));
            Parent root = loader.load();

            adminController = loader.getController();
            adminController.init(this);
            mainStage.setTitle("Simple Bank RMI System - Admin View");
            mainScene = new Scene(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
        mainStage.setWidth(400);
        mainStage.setHeight(300);
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    public void openClerkView() {
        try
        {
            loader= new FXMLLoader(getClass().getClassLoader().getResource("fxml/ClerkView.fxml"));
            Parent root = loader.load();

            clerkViewController = loader.getController();
            clerkViewController.init(this);
            mainStage.setTitle("Simple Bank RMI System - Clerk View");
            mainScene = new Scene(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
        mainStage.setWidth(400);
        mainStage.setHeight(300);
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    public void openCustomerView() {
        try
        {
            loader= new FXMLLoader(getClass().getClassLoader().getResource("fxml/CustomerView.fxml"));
            Parent root = loader.load();

            customerViewController = loader.getController();
            customerViewController.init(this);
            mainStage.setTitle("Simple Bank RMI System - Customer View");
            mainScene = new Scene(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
        mainStage.setWidth(400);
        mainStage.setHeight(300);
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    public BankClientRMI getClientRMI() {
        return clientRMI;
    }
}
