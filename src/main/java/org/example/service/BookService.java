package org.example.service;

import org.example.model.Books;

import java.util.ArrayList;

public class BookService {

    private Books books = new Books();
    private ArrayList<String> availableBooks = new ArrayList<>();


    public ArrayList<String> searchByRate(int rating) {
        ArrayList<String> availableBooks = new ArrayList<>();
        for (var item : books.getBooks()) {

            if (item.getRate() == rating) {
                System.out.println(item.getName());
                availableBooks.add(item.getName());
            }

        }
        return availableBooks;
    }

    public ArrayList<String> getAvailableBooks() {
        ArrayList<String> availableBooks = new ArrayList<>();
        for (var item : books.getBooks()) {
            if (item.isLoaned() == false) {
                System.out.println(item.getName());
                availableBooks.add(item.getName());
            }
        }
        return availableBooks;
    }

    public ArrayList<String> searchBook(String userSearchInput) {
        ArrayList<String> availableBooks = new ArrayList<>();
        for (var item : books.getBooks()) {
            if (item.getName().equalsIgnoreCase(userSearchInput) || item.getAuthor().equalsIgnoreCase(userSearchInput) || item.getGenre().equalsIgnoreCase(userSearchInput) || item.getPublish_date().equalsIgnoreCase(userSearchInput)) {
                System.out.println(item.getName());
                availableBooks.add(item.getName());
            }
        }
        return availableBooks;
    }
}
