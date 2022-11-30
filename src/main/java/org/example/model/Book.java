package org.example.model;

public class Book {

    //states
    private int id;
    private int rate = 0;
    private String name;
    private String genre;
    private String author;
    private String publish_date;
    private boolean isLoaned;
    private int price;

    //Constructor
    public Book(int id, String name, String genre, String author, String publish_date, int price) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.publish_date = publish_date;
        this.price = price;
        isLoaned = false;
    }

    //Behaviours
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned(boolean loaned) {
        isLoaned = loaned;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
