package dataAccess;

import model.Department;

import java.sql.*;

public class DepartmentDataBaseAccess {

    private Connection connection;

    public DepartmentDataBaseAccess() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktab_58", "root", "password");
    }
    
    public void save(Department d) throws SQLException {

        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("INSERT INTO department(Department_name,phon) values ('%s','%s')", d.getName(), d.getPhone());
            statement.executeUpdate(sqlQuery);
            System.out.println("\u001B[32m" + "operation done successfully!" + "\u001B[0m");
        } else {
            System.out.println("cannot access to database");
        }
    }
    
    public void updateDepartmentName(String name, int departmentId) throws SQLException {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                String sqlQuery = String.format("UPDATE department\n" +
                        "SET Department_name ='%s'" +
                        "WHERE DepartmentID ='%d'", name, departmentId);
                int i = statement.executeUpdate(sqlQuery);
                System.out.println("\u001B[32m" + "operation done successfully!" + "\u001B[0m");
            } else {
                System.out.println("cannot access to database");
            }
        } catch (NullPointerException e) {
            System.out.println("invalid department id!");
        }
    }

    
}
