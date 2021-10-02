package model;

public class Department {

    private int departmentID;
    private String name;
    private String phone;

    public Department(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Department(int departmentID, String name, String phone) {
        this.departmentID = departmentID;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return departmentID;
    }

    public void setId(int id) {
        this.departmentID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
