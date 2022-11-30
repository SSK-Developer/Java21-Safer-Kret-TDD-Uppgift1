package org.example.model;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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

    public void addBook(Book book){
        books.add(book);
    }
}
