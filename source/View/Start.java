package source.View;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import source.Model.*;
import source.Abstract.*;

public class Start {
    public static void main(String[] args) {
        int i = 1;
        int n;
        double d;
        String str;
        Library lib = new Library();
        System.out.println("Welcome to the Library Management System\n\n");
        while (i != 0) {
            System.out.println("1: Student Management\n");
            System.out.println("2: Teacher Management\n");
            System.out.println("3: Book Management\n");
            System.out.println("4: Basic Operations\n");
            System.out.println("0: Exit\n");
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            if (i == 1) {
                StudentOperations student = new Library();
                Student s = new Student();
                int a = 1;
                while (a != 0) {
                    System.out.println("1: Insert Student\n");
                    System.out.println("2: Remove Student\n");
                    System.out.println("3: Show All students\n");
                    System.out.println("0: Exit\n");
                    a = sc.nextInt();
                    if (a == 1) {
                        System.out.println("Enter Student ID: \n");
                        n = sc.nextInt();
                        s.setStudentId(n);
                        sc.nextLine();
                        System.out.println("Enter Student Address: \n");
                        str = sc.nextLine();
                        s.setAddress(str);
                        System.out.println("Enter Amount: \n");
                        d = sc.nextDouble();
                        s.setAmount(d);
                        sc.nextLine();
                        System.out.println("Enter Student Contact No: \n");
                        str = sc.nextLine();
                        s.setContactNo(str);
                        System.out.println("Enter Student Department: \n");
                        str = sc.nextLine();
                        s.setDepartmentName(str);
                        System.out.println("Enter Student Email Address: \n");
                        str = sc.nextLine();
                        s.setEmail(str);
                        System.out.println("Enter Student Guardian No: \n");
                        str = sc.nextLine();
                        s.setGuardianContactNo(str);
                        System.out.println("Enter Student Guardian Name: \n");
                        str = sc.nextLine();
                        s.setGuardianName(str);
                        System.out.println("Enter Student Name: \n");
                        str = sc.nextLine();
                        s.setName(str);
                        System.out.println("Enter Student LibraryID: \n");
                        n = sc.nextInt();
                        s.setId(n);
                        sc.nextLine();
                        student.insertStudent(s);
                    } else if (a == 2) {
                        System.out.println("Enter Student ID: \n");
                        n = sc.nextInt();
                        sc.nextLine();
                        Student st = new Student();
                        st.setStudentId(n);
                        student.removeStudent(st);
                    } else if (a == 3) {
                        try {
                            student.showAllStudent(s);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (a > 3) {
                        System.out.println("Wrong Input!");
                        continue;
                    }
                }
            } else if (i == 2) {
                TeacherOperations teacher = new Library();
                Teacher s = new Teacher();
                int a = 1;
                while (a != 0) {
                    System.out.println("1: Insert Teacher\n");
                    System.out.println("2: Remove Teacher\n");
                    System.out.println("3: Show All Teacher\n");
                    System.out.println("0: Exit\n");
                    a = sc.nextInt();
                    if (a == 1) {
                        System.out.println("Enter Teacher ID: \n");
                        n = sc.nextInt();
                        s.setId(n);
                        sc.nextLine();
                        System.out.println("Enter Teacher Name: \n");
                        str = sc.nextLine();
                        s.setName(str);
                        System.out.println("Enter Teacher Address: \n");
                        str = sc.nextLine();
                        s.setAddress(str);
                        System.out.println("Enter Amount: \n");
                        d = sc.nextDouble();
                        s.setAmount(d);
                        sc.nextLine();
                        System.out.println("Enter Teacher Contact No: \n");
                        str = sc.nextLine();
                        s.setContactNo(str);
                        System.out.println("Enter Teacher Department: \n");
                        str = sc.nextLine();
                        s.setDepartmentName(str);
                        System.out.println("Enter Teacher Email Address: \n");
                        str = sc.nextLine();
                        s.setEmail(str);
                        System.out.println("Enter Teacher LibraryID: \n");
                        str = sc.nextLine();
                        s.setTeacherId(str);
                        teacher.insetTeacher(s);
                    } else if (a == 2) {
                        System.out.println("Enter Teacher ID: \n");
                        n = sc.nextInt();
                        sc.nextLine();
                        Teacher tc = new Teacher();
                        tc.setId(n);
                        teacher.removeTeacher(tc);
                    } else if (a == 3) {
                        try {
                            teacher.showAllTeacher(s);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (a > 3) {
                        System.out.println("Wrong Input!");
                        continue;
                    }
                }

            } else if (i == 3) {
                BookOperations book = new Library();
                Book b = new Book();
                int a = 1;
                while (a != 0) {
                    System.out.println("1: Insert Book\n");
                    System.out.println("2: Remove Book\n");
                    System.out.println("3: Show All Book\n");
                    System.out.println("0: Exit\n");
                    a = sc.nextInt();
                    if (a == 1) {
                        System.out.println("Enter Book ID: \n");
                        n = sc.nextInt();
                        b.setId(n);
                        sc.nextLine();
                        System.out.println("Enter Book title: \n");
                        str = sc.nextLine();
                        b.setTitle(str);
                        System.out.println("Enter Book Author name: \n");
                        str = sc.nextLine();
                        b.setAuthorName(str);
                        System.out.println("Enter Publisher name: \n");
                        str = sc.nextLine();
                        b.setPublisherName(str);
                        System.out.println("Enter price: \n");
                        d = sc.nextDouble();
                        sc.nextLine();
                        b.setPrice(d);
                        System.out.println("Enter copy no: \n");
                        n = sc.nextInt();
                        sc.nextLine();
                        b.setNoOfCopy(n);
                        book.insertBook(b);
                    } else if (a == 2) {
                        System.out.println("Enter Book ID: \n");
                        n = sc.nextInt();
                        sc.nextLine();
                        b.setId(n);
                        book.removeBook(b);
                    } else if (a == 3) {
                        try {
                            book.showAllBook(b);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (a > 3) {
                        System.out.println("Wrong Input!");
                        continue;
                    }
                }

            } else if (i == 4) {
                System.out.println("1. Borrow Book");
                System.out.println("2. Return Book");
                System.out.println("3. Generate Fine");
                int a = sc.nextInt();
                sc.nextLine();
                Library library = new Library();
                if (a == 1) {

                    System.out.println("Enter Library ID: ");
                    String id = sc.nextLine();
                    System.out.println("Enter Book ID: ");
                    String bookID = sc.nextLine();
                    if (library.getBook(bookID, false)) {
                        try {
                            Random rand = new Random();
                            String randInt = String.valueOf(rand.nextInt(100));
                            String pattern = "MM/dd/yyyy HH:mm:ss";
                            DateFormat df = new SimpleDateFormat(pattern);
                            Date today = Calendar.getInstance().getTime();
                            String todayAsString = df.format(today);
                            PrintWriter writer = new PrintWriter("Borrow: " + id + randInt + ".txt", "UTF-8");
                            writer.write(
                                    "BorrowerID: " + id + " " + "BookID: " + bookID + " " + "Date: " + todayAsString);
                            writer.close();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        System.out.println("Book no found or out of copy!");

                    }
                } else if (a == 2) {
                    System.out.println("Enter Library ID: ");
                    String id = sc.nextLine();
                    System.out.println("Enter Book ID: ");
                    String bookID = sc.nextLine();
                    library.getBook(bookID, true);
                    try {
                        Random rand = new Random();
                        String randInt = String.valueOf(rand.nextInt(100));
                        String pattern = "MM/dd/yyyy HH:mm:ss";
                        DateFormat df = new SimpleDateFormat(pattern);
                        Date today = Calendar.getInstance().getTime();
                        String todayAsString = df.format(today);
                        PrintWriter writer = new PrintWriter("Return: " + id + randInt + ".txt", "UTF-8");
                        writer.write("BorrowerID: " + id + " " + "BookID: " + bookID + " " + "Date: " + todayAsString);
                        writer.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else if (a == 3) {
                    System.out.println("Input ID: ");
                    String id = sc.nextLine();
                    System.out.println("Enter Fine");
                    String fine = sc.nextLine();
                    System.out.println("Enter Reason");
                    String reason = sc.nextLine();
                    try {
                        Random rand = new Random();
                        String randInt = String.valueOf(rand.nextInt(100));
                        String pattern = "MM/dd/yyyy HH:mm:ss";
                        DateFormat df = new SimpleDateFormat(pattern);
                        Date today = Calendar.getInstance().getTime();
                        String todayAsString = df.format(today);
                        PrintWriter writer = new PrintWriter("Fine: " + id + randInt + ".txt", "UTF-8");
                        writer.write("Library ID: " + id + " " + "Fine: " + fine + " " + "Reason: " + reason + " "
                                + "Date: " + todayAsString);
                        writer.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    System.out.println("Wrong input!");
                    continue;
                }

            } else if (i > 4) {
                System.out.println("Wrong Input! Please try again.");
                continue;
            }
        }
    }
}