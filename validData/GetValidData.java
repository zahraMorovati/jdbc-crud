package validData;
import myDate.MyDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GetValidData {
    public static String getValidName(String message, Scanner scanner) {
        System.out.print(message);
        String name = scanner.next();
        if (name.matches("[a-zA-Z]*")) {
            return name;
        } else {
            System.out.println("\033[0;31m" + "invalid input!" + "\u001B[0m");
            return getValidName(message, scanner);
        }
    }

    public static MyDate getValidDate(Scanner scanner) {
        try {
            System.out.print("enter birth date (year month day):");
            MyDate birthDate = new MyDate(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            return birthDate;
        } catch (InputMismatchException e) {
            System.out.println("\033[0;31m" + "invalid date!" + "\u001B[0m");
            return getValidDate(scanner);
        }
    }

    public static String getValidPhoneNumber(String message, Scanner scanner) {
        System.out.print(message);
        String phoneNumber = scanner.next();
        String str = phoneNumber.substring(0);
        if (isNumeric(str)) {
            return phoneNumber;
        } else {
            System.out.println("\033[0;31m" + "invalid phone number!" + "\u001B[0m");
            return getValidPhoneNumber(message, scanner);
        }
    }

    public static int getValidInt(String message, Scanner scanner) {
        System.out.print(message);
        String str = scanner.next();
        if (isNumeric(str)) {
            return Integer.parseInt(str);
        } else {
            System.out.println("\033[0;31m" + "invalid input!" + "\u001B[0m");
            return getValidInt(message, scanner);
        }
    }

    public static int getValidChoice(String message, Scanner scanner, int maxChoice) {
        int number = getValidInt(message, scanner);
        for (int i = 1; i < maxChoice + 1; i++) {
            if (i == number) {
                return number;
            }
        }
        System.out.println("\033[0;31m" + "invalid choice!" + "\u001B[0m");
        return getValidChoice(message, scanner, maxChoice);
    }

    public static boolean isNumeric(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        try {
            Double.parseDouble(str);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }

    }
}
