package main.java.BankData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database
{
  // DATABASE INITIALIZATION CODE
  /*
  CREATE DATABASE bankrmi;
  CREATE TABLE user_account (
      username VARCHAR PRIMARY KEY,
      password VARCHAR NOT NULL,
      user_type VARCHAR NOT NULL,
      balance NUMERIC(7,2) NOT NULL
  );
   */
  public Database()
  {
    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  public Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/dummy",
        "postgres", "29312112");
  }
}
