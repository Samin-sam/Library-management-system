package source.Model;

public class Librarian {
    private String name;
    private String LibrarianId;
    private double salary;
    private int age;

    //SETTER METHOD
    public void setName(String name) {
        this.name = name;
    }
    public void setID(String LibrarianId) {
        this.LibrarianId = LibrarianId;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //GETTER METHOD
    public String getName() {
        return name;
    }

    public String getID() {
        return LibrarianId;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}