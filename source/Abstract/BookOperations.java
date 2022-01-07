package source.Abstract;

import source.Model.*;

public interface BookOperations {
    public void insertBook(Book b);

    public void removeBook(Book b);

    public boolean getBook(String b, boolean bool);

    public void showAllBook(Book b);
}