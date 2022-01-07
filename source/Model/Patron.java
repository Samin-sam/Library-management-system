package source.Model;

public class Patron {
    private int id;
    private String name;
    private String departmentName;
    private String email;
    private String contactNo;
    private String address;
    private double amount;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //GETTER
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDepartmentName() {
        return departmentName;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getAddress() {
        return address;
    }

    public double getAmount() {
        return amount;
    } 

    public  void showInfo() {
        
    }
}