package source.Model;

public class Student extends Patron {
    private int studentId;
    private String guardianName;
    private String guardianContactNo;

    //SETTER METHOD
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public void setGuardianName(String guardianName){
        this.guardianName = guardianName;
    }

    public void setGuardianContactNo(String guardianContactNo){
        this.guardianContactNo = guardianContactNo;
    }

    //GETTER METHOD
    public int getStudentId(){
        return studentId;
    }

    public String getGuardianName(){
        return guardianName;
    }

    public String getGuardianContactNo(){
        return guardianContactNo;
    }
}