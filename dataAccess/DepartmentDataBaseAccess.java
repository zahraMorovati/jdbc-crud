package dataAccess;

import model.Department;

import java.sql.*;

public class DepartmentDataBaseAccess {

    private Connection connection;

    public DepartmentDataBaseAccess() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktab_58", "root", "password");
    }

    
}
