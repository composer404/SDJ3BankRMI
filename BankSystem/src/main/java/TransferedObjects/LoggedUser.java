package main.java.TransferedObjects;

public class LoggedUser {

    private static LoggedUser loggedUser;
    private User user;

    public static LoggedUser getLoggedUser()
    {
        if(loggedUser == null)
            loggedUser = new LoggedUser();
        return loggedUser;
    }

    public void login(User user)
    {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
