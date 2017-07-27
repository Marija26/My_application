package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Admin on 02.07.2017.
 */
public class DBUtil {
    private static Connection connection;

    public static Connection getConnection(){
        if(connection != null){
            return connection;
        }else {
            try{
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "werter");
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}
