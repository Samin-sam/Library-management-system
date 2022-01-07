package source.Model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Book {
    private int id;
    private String title;
    private String subtitle;
    private String authorName;
    private String publisherName;
    private double price;
    private int noOfCopy;

    public Book(){
    }

    // SETTER FUNCTION
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNoOfCopy(int noOfCopy) {
        this.noOfCopy = noOfCopy;
    }

    // GETTER FUNCTION

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public double getPrice() {
        return price;
    }

    public int getNoOfCopy() {
        return noOfCopy;
    }
}