package Configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static Configurations.Configs.*;

public class DBHandler {
    static Connection dbConnection;

    public static Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString  ="jdbc:mysql://"+dbHost+":"
                +dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection= DriverManager.getConnection(connectionString, dbUser,dbPass);
        return dbConnection;
}
}
