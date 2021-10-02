package dataAccess;

import model.Employee;

import java.sql.*;

public class EmployeeDataBaseAccess {

    private Connection connection;

    public EmployeeDataBaseAccess() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktab_58", "root", "george1378");
    }
	
	public void save(Employee e) throws SQLException {

        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("INSERT INTO employee" +
                    "(first_name,last_name,UserID,BirthDate,DepartmentID)" +
                    " values ('%s','%s','%d','%s','%d')", e.getFirst_name(), e.getLast_name(), e.getUserID(), e.getBirthDate().toString(), e.getDepartmentID());
            int i = statement.executeUpdate(sqlQuery);
            if (i != 0)
                System.out.println("\u001B[32m" + "operation done successfully!" + "\u001B[0m");
            else
                System.out.println("operation failed!");
        } else {
            System.out.println("cannot access to database");
        }
    }

}
