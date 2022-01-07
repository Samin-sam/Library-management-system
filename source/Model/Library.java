package source.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import source.Abstract.*;

public class Library implements StudentOperations, BookOperations, TeacherOperations {
    private String libraryName;
    private String address;
    private ArrayList<Patron> patrons = new ArrayList<Patron>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private int noOfBooks;
    private Librarian librarian;

    public Library() {
        try {
            loadBookData();
            String studentFileName = "students.txt";
            String teacherFileName = "teacher.txt";
            String bookFileName = "books.txt";
            File file1 = new File(studentFileName);
            File file2 = new File(teacherFileName);
            File file3 = new File(bookFileName);
            FileInputStream fis1 = new FileInputStream(file1);
            FileInputStream fis2 = new FileInputStream(file2);
            FileInputStream fis3 = new FileInputStream(file3);
            InputStreamReader isr1 = new InputStreamReader(fis1, "utf-8");
            InputStreamReader isr2 = new InputStreamReader(fis2, "utf-8");
            InputStreamReader isr3 = new InputStreamReader(fis3, "utf-8");
            BufferedReader br1 = new BufferedReader(isr1);
            BufferedReader br2 = new BufferedReader(isr2);
            BufferedReader br3 = new BufferedReader(isr3);
            String line1, line2, line3;
            Patron p;
            String[] strArray;
            while ((line1 = br1.readLine()) != null) {
                p = new Patron();
                strArray = line1.split(",");
                p.setId(Integer.valueOf(strArray[1]));
                p.setName(strArray[2]);
                p.setDepartmentName(strArray[4]);
                p.setEmail(strArray[5]);
                p.setAddress(strArray[6]);
                p.setContactNo(strArray[7]);
                p.setAmount(Double.valueOf(strArray[8]));
                patrons.add(p);
            }
            while ((line2 = br2.readLine()) != null) {
                p = new Patron();
                strArray = line2.split(",");
                p.setId(Integer.valueOf(strArray[1]));
                p.setName(strArray[2]);
                p.setDepartmentName(strArray[3]);
                p.setEmail(strArray[4]);
                p.setAddress(strArray[5]);
                p.setContactNo(strArray[6]);
                p.setAmount(Double.valueOf(strArray[7]));
                patrons.add(p);
            }
            Book b;
            while ((line3 = br3.readLine()) != null) {
                b = new Book();
                strArray = line3.split(",");
                b.setTitle(strArray[1]);
                b.setId(Integer.valueOf(strArray[0]));
                b.setAuthorName(strArray[2]);
                b.setPublisherName(strArray[3]);
                b.setPrice(Double.valueOf(strArray[4]));
                b.setNoOfCopy(Integer.valueOf(strArray[5]));
                books.add(b);
            }
        } catch (Exception e) {
            System.out.println(e + " From constructor");
        }
    }

    @Override
    public void insertBook(Book b) {
        books.add(b);
        String line = "\n" + b.getId() + "," + b.getTitle() + "," + b.getAuthorName() + "," + b.getPublisherName() + ","
                + b.getPrice() + "," + b.getNoOfCopy();
        try {
            FileWriter fw = new FileWriter("books.txt", true);
            fw.write(line);
            fw.close();
            System.out.println(line);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeBook(Book b) {
        ArrayList<String> arr = new ArrayList<>();
        int n = 0;
        try {
            String fileName = "books.txt";
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(String.valueOf(b.getId()))) {
                    n = 1;
                    continue;
                }
                arr.add(line);
            }
            br.close();
            FileWriter myWriter = new FileWriter("books.txt");
            for (int i = 0; i < arr.size(); i++) {
                myWriter.write(arr.get(i) + "\n");
            }
            myWriter.close();
            if (n == 1) {
                System.out.println(b.getId() + " is deleted!");
            } else if (n == 0) {
                System.out.println(b.getId() + " is not exist!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public boolean getBook(String b, boolean bool) {
        System.out.println(books.get(0).getId());
        int bookID = Integer.valueOf(b);
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == bookID) {
                if (books.get(i).getNoOfCopy() == 0) {
                    return false;
                } else {
                    if (bool == false) {
                        int copyNo = books.get(i).getNoOfCopy() - 1;
                        books.get(i).setNoOfCopy(copyNo);
                        updateBook(copyNo, bookID);
                        return true;
                    } else if (bool == true) {
                        int copyNo = books.get(i).getNoOfCopy() + 1;
                        books.get(i).setNoOfCopy(copyNo);
                        updateBook(copyNo, bookID);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void showAllBook(Book b) {
        try {
            String fileName = "books.txt";
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void insertStudent(Student s) {
        patrons.add(s);
        String line = "\n" + s.getStudentId() + "," + s.getId() + "," + s.getName() + "," + s.getGuardianName() + ","
                + s.getDepartmentName() + "," + s.getEmail() + "," + s.getAddress() + "," + s.getContactNo() + ","
                + s.getAmount();
        try {
            FileWriter fw = new FileWriter("students.txt", true);
            fw.write(line);
            fw.close();
            System.out.println(line);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeStudent(Student s) {
        ArrayList<String> arr = new ArrayList<>();
        int n = 0;
        try {
            String fileName = "students.txt";
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(String.valueOf(s.getStudentId()))) {
                    n = 1;
                    continue;
                }
                arr.add(line);
            }
            br.close();
            FileWriter myWriter = new FileWriter("students.txt");
            for (int i = 0; i < arr.size(); i++) {
                myWriter.write(arr.get(i) + "\n");
            }
            myWriter.close();
            if (n == 1) {
                System.out.println(s.getStudentId() + " is deleted!");
            } else if (n == 0) {
                System.out.println(s.getStudentId() + " is not exist!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Student getStudent(Student s) {

        return s;
    }

    @Override
    public void showAllStudent(Student s) {
        try {
            String fileName = "students.txt";
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void insetTeacher(Teacher t) {
        patrons.add(t);
        String line = "\n" + t.getTeacherId() + "," + t.getId() + "," + t.getName() + "," + t.getDepartmentName() + ","
                + t.getEmail() + "," + t.getAddress() + "," + t.getContactNo() + "," + t.getAmount();
        try {
            FileWriter fw = new FileWriter("teacher.txt", true);
            fw.write(line);
            fw.close();
            System.out.println(line);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeTeacher(Teacher t) {
        ArrayList<String> arr = new ArrayList<>();
        int n = 0;
        try {
            String fileName = "teacher.txt";
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(String.valueOf(t.getId()))) {
                    n = 1;
                    continue;
                }
                arr.add(line);
            }
            br.close();
            FileWriter myWriter = new FileWriter("teacher.txt");
            for (int i = 0; i < arr.size(); i++) {
                myWriter.write(arr.get(i) + "\n");
            }
            myWriter.close();
            if (n == 1) {
                System.out.println(t.getId() + " is deleted!");
            } else if (n == 0) {
                System.out.println(t.getId() + " is not exist!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Teacher getTeacher(Teacher t) {
        return t;
    }

    @Override
    public void showAllTeacher(Teacher t) {
        try {
            String fileName = "teacher.txt";
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void loadBookData() {
        try {
            String fileName = "books.txt";
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            String[] arr;
            Book b;
            while ((line = br.readLine()) != null) {
                arr = line.split(",");
                b = new Book();
                b.setId(Integer.valueOf(arr[0]));
                b.setTitle(arr[1]);
                b.setAuthorName(arr[2]);
                b.setPublisherName(arr[3]);
                b.setPrice(Double.valueOf(arr[4]));
                b.setNoOfCopy(Integer.valueOf(arr[5]));
                books.add(b);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateBook(int d, int s) {
        try {
            String copyNo = String.valueOf(d);
            String bookId = String.valueOf(s);
            File originaFile = new File("books.txt");
            BufferedReader br = new BufferedReader(new FileReader(originaFile));
            File tempFile = new File("tempbooks.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line;
            String[] strArray;
            while ((line = br.readLine()) != null) {
                strArray = line.split(",");
                if (line.contains(bookId)) {
                    if (strArray[5] != null || !strArray[5].trim().isEmpty()) {
                        line = strArray[0] + "," + strArray[1] + "," + strArray[2] + "," + strArray[3] + ","
                                + strArray[4] + "," + copyNo;
                    }
                }
                pw.println(line);
                pw.flush();
            }
            pw.close();
            br.close();
            if (!originaFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            if (!tempFile.renameTo(originaFile)) {
                System.out.println("Could not rename file");
            }
        } catch (

        Exception e) {
            System.out.println(e);
        }
    }

}