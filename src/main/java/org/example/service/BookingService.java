package org.example.service;

import org.example.BookingRequest;
import org.example.model.Books;

import java.util.ArrayList;

public class BookingService {

    private Books books;
    private PaymentService paymentService;

    public BookingService(PaymentService paymentService) {
        this.paymentService = paymentService;
        books = new Books();
    }

    public boolean loanBook(BookingRequest bookingRequest) {
        for (var item : books.getBooks()) {

            if (item.getName().equalsIgnoreCase(bookingRequest.getBookName()) && !item.isLoaned() && bookingRequest.getPay() >= item.getPrice() && bookingRequest.isPaid()) {
                item.setLoaned(true);
                System.out.println("Book loaned: " + item.getName());
                System.out.println("Book price: " + item.getPrice());
                paymentService.pay(bookingRequest.getPay());
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(BookingRequest bookingRequest) {
        for (var item : books.getBooks()) {

            if (item.getName().equalsIgnoreCase(bookingRequest.getBookName()) && item.isLoaned() == true) {

                if (bookingRequest.goodOrBad() == true) {
                    item.setRate(item.getRate() + 1);
                    System.out.println(item.getRate());
                }

                item.setLoaned(false);
                System.out.println("Book returned: " + item.getName());

                return true;
            }
        }
        return false;
    }

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
