package employee.management.system;

import java.net.ConnectException;
import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection connection;
    public Statement statement;

    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","5515");
            statement=connection.createStatement();//Prepares the connection to run SQL queries.
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
