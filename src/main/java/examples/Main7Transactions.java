package examples;

import java.sql.*;

import static examples.Configuration.*;

public class Main7Transactions {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE user SET username='Ambrozy' WHERE id=43");
        Savepoint savepoint = connection.setSavepoint();
        statement.executeUpdate("UPDATE user SET username='Eustachy' WHERE id=44");
        connection.rollback(savepoint);
        statement.executeUpdate("UPDATE user SET username='Bozydar' WHERE id=45");


        connection.commit();
        statement.close();
        connection.close();
    }
}
