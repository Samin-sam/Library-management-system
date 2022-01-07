package source.Abstract;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import source.Model.*;

public interface StudentOperations {
    public void insertStudent(Student s);

    public void removeStudent(Student s);

    public Student getStudent(Student s);

    public void showAllStudent(Student s) throws FileNotFoundException, UnsupportedEncodingException, IOException;
}