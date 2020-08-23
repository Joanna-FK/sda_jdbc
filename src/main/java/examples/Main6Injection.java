package examples;

import java.sql.*;

import static examples.Configuration.*;

public class Main6Injection {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println(login("Jan", "password1", connection));
        System.out.println(login("Ala", "wrongPassword", connection));
        System.out.println(login("Ala", "'OR '1'='1", connection));
        System.out.println(securedLogin("Ala", "'OR '1'='1", connection));
        System.out.println(securedLogin("Ala", "password2", connection));
    }

    private static boolean securedLogin(String username, String password, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        boolean isLogged = resultSet.next();
        preparedStatement.close();
        return isLogged;
    }

    private static boolean login(String username, String password, Connection connection) throws SQLException {
      //  "SELECT * FROM user WHERE username='Jan' AND password='password1'"
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "'");
        boolean isLogged = resultSet.next();

        statement.close();
        return isLogged;
    }
}
