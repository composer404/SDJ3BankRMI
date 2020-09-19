package main.java.BankData;

import main.java.TransferedObjects.User;
import main.java.TransferedObjects.UserTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDataDAOImpl extends Database implements BankDataDAO
{
  public BankDataDAOImpl()
  {
  }

  @Override
  public Connection getConnection() throws SQLException
  {
    return super.getConnection();
  }

  @Override
  public User loginRequest(String username, String password)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM user_account WHERE username = ? AND password = ?;");
      statement.setString(1, username);
      statement.setString(2, password);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String userType = resultSet.getString("user_type");
        double balance = resultSet.getDouble("balance");

        return switch (userType)
            {
              case "administrator" -> new User(username, password,
                  UserTypes.ADMINISTRATOR, balance);
              case "clerk" -> new User(username, password, UserTypes.CLERK,
                  balance);
              case "customer" -> new User(username, password,
                  UserTypes.CUSTOMER, balance);
              default -> null;
            };
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override
  public void addNewUserRequest(User user)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO user_account (username,password,user_type,balance) VALUES (?,?,?,?) ON CONFLICT ON CONSTRAINT unique_username DO NOTHING; ");
      statement.setString(1, user.getUsername());
      statement.setString(2, user.getPassword());
      statement.setString(3, user.getType().toString());
      statement.setDouble(4, user.getBalance());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override
  public void withdrawRequest(User user, double withdraw)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("UPDATE user_account SET balance = ? WHERE username = ?;");
      statement.setDouble(1, user.getBalance() - withdraw);
      statement.setString(2, user.getUsername());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override
  public void insertMoney(User user, double amount)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("UPDATE user_account SET balance = ? WHERE username = ?;");
      statement.setDouble(1, user.getBalance() + amount);
      statement.setString(2, user.getUsername());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override
  public double getUserBalance(String username)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT balance FROM user_account WHERE username = ?;");
      statement.setString(1, username);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        double balance = resultSet.getDouble("balance");
        return balance;
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return 0;
  }
}
