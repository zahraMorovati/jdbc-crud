package model;

import myDate.MyDate;

import java.util.Date;
import java.util.stream.IntStream;

public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private int userID;
    private MyDate birthDate;
    private int departmentID;

    int[] userIdList = new int[0];

    public Employee(String first_name, String last_name, int userID, MyDate birthDate, int departmentID) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.userID = userID;
        this.birthDate = birthDate;
        this.departmentID = departmentID;
    }

    public Employee(String first_name, String last_name, MyDate birthDate, int departmentID) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthDate = birthDate;
        this.departmentID = departmentID;
        setUserID();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID() {
        this.userID = randomUserID();
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int[] addToArray(int[] array, int element) {

        int[] newArray = new int[array.length + 1];
        IntStream.range(0, array.length).forEach(i -> newArray[i] = array[i]);
        newArray[array.length] = element;
        return newArray;
    }

    public boolean checkRandomUserID(int userID, int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == userID)
                return false;

        return true;
    }

    public int randomUserID() {
        int min = 1000000;
        int max = 9999999;
        int randomUserID = (int) Math.floor(Math.random() * (max - min + 1) + min);
        if (checkRandomUserID(randomUserID, userIdList)) {
            userIdList = addToArray(userIdList, randomUserID);
            return randomUserID;
        } else {
            return randomUserID();
        }

    }
}
