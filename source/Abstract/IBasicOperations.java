package source.Abstract;
import source.Model.*;

interface IBasicOperations {
    void borrow(Patron p, Book b);
    void returnBook(Patron p, Book b);
    void fine(Patron p, double amount);
}