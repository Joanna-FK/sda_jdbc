package examples;

import java.sql.*;
import java.util.List;

import static examples.Configuration.*;

public class Main5PreparedStatementExercises {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        List<String> username = List.of("Jan", "Ala", "Mikolaj", "Ola");
        List<String> password = List.of("password1", "password2", "password3", "password4");

        if (username.size() != password.size()){
            throw  new RuntimeException("message");
        }

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(username, password) VALUE (?, ?)");
        for(int i=0; i<username.size(); i++){
            preparedStatement.setString(1, username.get(i));
            preparedStatement.setString(2, password.get(i));
            preparedStatement.executeUpdate();
        }

        preparedStatement.close();
        connection.close();
    }
}
