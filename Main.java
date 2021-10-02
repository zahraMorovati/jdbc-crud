import dataAccess.DepartmentDataBaseAccess;
import dataAccess.EmployeeDataBaseAccess;
import model.Department;
import model.Employee;
import myDate.MyDate;
import java.sql.SQLException;
import java.util.Scanner;

import static validData.GetValidData.*;

public class Main {

      public static void main(String[] args) throws SQLException, ClassNotFoundException {

        printMenu();
    }

    public static void printMenu() throws SQLException, ClassNotFoundException {
        DepartmentDataBaseAccess departmentDataAccess = new DepartmentDataBaseAccess();
        EmployeeDataBaseAccess employeeDataAccess = new EmployeeDataBaseAccess();
        Scanner scanner = new Scanner(System.in);
        System.out.println("*********** welcome *************");
        int choice = getValidChoice("department ---> 1)save 2)update_name  3)print_department_list        4)delete" +
                "\nemployee   ---> 5)save 6)update_name  7)print_department_employees   8)delete" +
                "\n9)exit ----> enter your choice: ", scanner, 9);


        switch (choice) {

            case 1: {
                String name = getValidName("enter department name: ", scanner);
                String phone = getValidPhoneNumber("enter phone number:", scanner);
                Department department = new Department(name, phone);
                departmentDataAccess.save(department);
                printMenu();
            }
            break;
            case 2: {
                int id = getValidInt("enter department id:", scanner);
                String name = getValidName("enter department name: ", scanner);
                departmentDataAccess.updateDepartmentName(name, id);
                printMenu();
            }
            break;
            case 3: {
                departmentDataAccess.printDepartments();
                printMenu();
            }
            break;
            case 4: {
                int id = getValidInt("enter department id:", scanner);
                departmentDataAccess.delete(id);
                printMenu();
            }
            break;
            case 5: {
                String first_name = getValidName("enter first name:", scanner);
                String last_name = getValidName("enter last name:", scanner);
                MyDate birthDate = getValidDate(scanner);
                int departmentID = getValidInt("enter department id:", scanner);
                Employee employee = new Employee(first_name, last_name, birthDate, departmentID);
                employeeDataAccess.save(employee);
                printMenu();

            }
            break;
            case 6: {
                int id = getValidInt("enter employee id:", scanner);
                String first_name = getValidName("enter first name:", scanner);
                String last_name = getValidName("enter last name:", scanner);
                employeeDataAccess.updateName(first_name, last_name, id);
                printMenu();
            }
            break;
            case 7: {
                int id = getValidInt("enter department id:", scanner);
                employeeDataAccess.printDepartmentEmployees(id);
                printMenu();
            }
            break;
            case 8: {
                int id = getValidInt("enter employee id:", scanner);
                employeeDataAccess.delete(id);
                printMenu();
            }
            case 9: {
                System.exit(0);
            }
            default: {
                System.out.println("\033[0;31m" + "invalid choice!" + "\u001B[0m");
                printMenu();
            }

        }

    }
}
