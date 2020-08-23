package examples;

import java.sql.*;

public class Main3StatementExercises {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(Configuration.URL, Configuration.USER, Configuration.PASSWORD);
        Statement statement = connection.createStatement();

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS user (id BIGINT NOT NULL AUTO_INCREMENT, " +
                "username VARCHAR(50)," +
                " password VARCHAR(50)," +
                " PRIMARY KEY(id))");

        statement.executeUpdate("INSERT INTO user(username, password) VALUES " +
                "('userOne', 'passwordOne'), " +
                "('userTwo', 'passwordTwo'), " +
                "('userThree', 'passwordThree'), " +
                "('userFour', 'passwordFour')," +
                "('userFive', 'passwordFive'), " +
                "('userSix', 'passwordSix')");

        ResultSet
                resultSet = statement.executeQuery("SELECT username FROM user");
        while (resultSet.next()){
            String username = resultSet.getString("username");
            System.out.println(username);
        }
        statement.executeUpdate("DELETE FROM user");

        statement.close();
        connection.close();
    }
}
