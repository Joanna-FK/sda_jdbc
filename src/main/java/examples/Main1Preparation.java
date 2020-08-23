package examples;

import java.sql.*;

public class Main1Preparation {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(Configuration.URL, Configuration.USER, Configuration.PASSWORD);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");
        while (resultSet.next()){
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            System.out.println(String.format("id: %s name: %s age: %s", id, name, age));
        }

        statement.close();
        connection.close();

    }
}
