package main.java.BankServer.BusinessLogic;

import main.java.TransferedObjects.User;
import main.java.TransferedObjects.UserTypes;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    private List<User> users;

    public Operations(){
        users = new ArrayList<>();

        //Temporary data for testing instead of database

        User user1 = new User("bob","bobsen", UserTypes.CUSTOMER, 1000);
        User user2 = new User("tom", "tomsen", UserTypes.CLERK, 100);
        User user3 = new User("admin","admin", UserTypes.ADMINISTRATOR, 300000);

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public User getUser(String username, String password)
    {
        for(User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public void addNewUser(User newUser)
    {
        users.add(newUser);
    }

    public boolean withdrawMoney(User user, double withdraw) {
        for(User user1 : users){
            if(user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword())){
                if(user1.getBalance() > withdraw) {
                    user1.withdrawMoney(withdraw);
                    return true;
                }
            }
        }
        return false;
    }

    public void insertMoney(User user, double amount) {
        for (User user1 : users) {
            if (user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword())) {
                user1.insertMoney(amount);
            }
        }
    }
}
