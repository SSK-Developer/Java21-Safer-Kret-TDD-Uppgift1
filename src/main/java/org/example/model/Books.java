package org.example.model;

import java.util.ArrayList;
import java.util.List;


public class Books {

    public final ArrayList<Book> books;

    public Books() {
        books = new ArrayList<>();
        books.add(new Book(1, "Dream Town",  "Fiction",  "David Baldacci",  "22-01-01", 100));
        books.add(new Book(2, "Book Lovers",  "Fiction",  "Emily Henry",  "22-02-02", 100));
        books.add(new Book(3, "Abandoned in Death",  "Horror",  "J.D. Robb",  "22-03-03", 100));
        books.add(new Book(4, "The Paris Apartment",  "Romance",  "Lucy Foley",  "22-04-04", 100));
    }

    public List<Book> getBooks() {
        return books;
    }
}
