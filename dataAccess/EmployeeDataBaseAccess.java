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

    public void updateName(String first_name, String last_name, int employeeID) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("UPDATE employee\n" +
                    "SET First_name ='%s'" +
                    ", Last_name ='%s'" +
                    "WHERE EmployeeID ='%d'", first_name, last_name, employeeID);
            int i=statement.executeUpdate(sqlQuery);
            if (i != 0)
                System.out.println("\u001B[32m" + "operation done successfully!" + "\u001B[0m");
            else
                System.out.println("invalid employee id!");
        } else {
            System.out.println("cannot access to database");
        }
    }

    public void printDepartmentEmployees(int departmentID) throws SQLException {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                String sqlQuery = String.format("select * from employee where DepartmentID='%d' ", departmentID);
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {

                    String id = resultSet.getString(1);
                    String first_name = resultSet.getString(2);
                    String last_name = resultSet.getString(3);
                    String userID = resultSet.getString(4);
                    String birthDate = resultSet.getString(5);
                    String departmentId = resultSet.getString(6);
                    System.out.println("id= " + id);
                    System.out.println("name= " + first_name + " " + last_name);
                    System.out.println("user id= " + userID);
                    System.out.println("birth date= " + birthDate);
                    System.out.println("department id= " + departmentId);
                }
                if(!resultSet.wasNull()){
                    System.out.println("there is no employee with this department id!");
                }
                resultSet.close();
            } else {
                System.out.println("cannot access to database");
            }
        } catch (NullPointerException nullPointerException) {
            System.out.println("there is no employee with this department id!");
        }

    }

    public void delete(int employeeID) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("delete from employee where EmployeeID='%d'", employeeID);
            int i=statement.executeUpdate(sqlQuery);
            if (i != 0)
                System.out.println("\u001B[32m" + "operation done successfully!" + "\u001B[0m");
            else
                System.out.println("invalid employee id!");

        } else {
            System.out.println("cannot access to database");
        }

    }
}
