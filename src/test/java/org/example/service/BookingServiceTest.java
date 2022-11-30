package org.example.service;

import org.example.BookingRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class BookingServiceTest {


    private PaymentService paymentService;

    private BookingService bookingService;

    private BookService bookService;

    private ArgumentCaptor<Integer> payArgumentCaptor;

    @BeforeEach
    void setUp() {

        paymentService = mock(PaymentService.class);
        bookingService = new BookingService(paymentService);
        bookService = new BookService();
        payArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

    }

    @Test
    public void unLoanedBook_Should_Get_Loaned() {
        BookingRequest bookingRequestLoan = new BookingRequest("1", "Dream Town", 100, true);

        boolean requestLoanOnBookLovers = bookingService.loanBook(bookingRequestLoan);

        assertEquals(true, requestLoanOnBookLovers);
    }

    @Test
    public void Loaned_Book_Should_Return_True_When_Returned() {
        BookingRequest bookingRequestLoan = new BookingRequest("1", "Dream Town", 100, true);
        BookingRequest bookingRequestReturn = new BookingRequest("Dream Town", true);
        bookingService.loanBook(bookingRequestLoan);
        boolean requestReturnOnDreamTown = bookingService.returnBook(bookingRequestReturn);

        assertEquals(true, requestReturnOnDreamTown);
    }

    @Test
    public void loaned_Book_Should_Return_False_When_Tried_To_Get_Loaned() {

        BookingRequest bookingRequestLoan1 = new BookingRequest("1", "Dream Town", 100, true);
        BookingRequest bookingRequestLoan2 = new BookingRequest("2", "Dream Town", 100, true);

        //loaning the book
        bookingService.loanBook(bookingRequestLoan1);

        //trying to loand book again
        boolean requestLoanOnDreamTown2 = bookingService.loanBook(bookingRequestLoan2);

        assertNotEquals(true, requestLoanOnDreamTown2);
    }

    @Test
    public void should_Get_Book_Loaned_When_Paying_Right_Amount_Of_Money() {
        BookingRequest bookingRequestLoan1 = new BookingRequest("1", "Dream Town", 100, true);
        bookingService.loanBook(bookingRequestLoan1);

        verify(paymentService, times(1)).pay(payArgumentCaptor.capture());
        int amountToPay = payArgumentCaptor.getValue();

        assertEquals(100, amountToPay);
    }

    @Test
    public void search_Available_Books() {
        BookingRequest bookingRequestLoan1 = new BookingRequest("1", "Dream Town", 100, true);
        BookingRequest bookingRequestLoan2 = new BookingRequest("1", "Book Lovers", 100, true);

        bookingService.loanBook(bookingRequestLoan1);
        bookingService.loanBook(bookingRequestLoan2);

        ArrayList<String> actualList = bookingService.getAvailableBooks();
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Abandoned in Death");
        expectedList.add("The Paris Apartment");

        System.out.println("(actual) Available books: " + actualList.get(0) + "\n "
                + actualList.get(1));
        System.out.println("(expected) Available books: " + expectedList.get(0) + "\n "
                + expectedList.get(1));

        assertEquals(expectedList, actualList);

    }

    @Test
    public void search_By_Book_Author() {

        ArrayList<String> expected = bookingService.searchBook("David Baldacci");
        ArrayList<String> actual = new ArrayList<>();
        actual.add("Dream Town");

        assertEquals(expected, actual);
    }

    @Test
    public void search_By_Book_Name() {

        ArrayList<String> expected = bookingService.searchBook("Dream Town");
        ArrayList<String> actual = new ArrayList<>();
        actual.add("Dream Town");

        assertEquals(expected, actual);
    }

    @Test
    public void search_By_Book_Genre() {

        ArrayList<String> expected = bookingService.searchBook("Fiction");
        ArrayList<String> actual = new ArrayList<>();
        actual.add("Dream Town");
        actual.add("Book Lovers");

        assertEquals(expected, actual);
    }

    @Test
    public void search_By_Book_Rate() {
        BookingRequest bookingRequestLoan1 = new BookingRequest("1", "Dream Town", 100, true);
        BookingRequest bookingRequestReturn1 = new BookingRequest("Dream Town", true);
        BookingRequest bookingRequestLoan2 = new BookingRequest("1", "Book Lovers", 100, true);
        BookingRequest bookingRequestReturn2 = new BookingRequest("Book Lovers", true);

        bookingService.loanBook(bookingRequestLoan1);
        bookingService.loanBook(bookingRequestLoan2);
        bookingService.returnBook(bookingRequestReturn1);
        bookingService.returnBook(bookingRequestReturn2);

        bookingService.loanBook(bookingRequestLoan1);
        bookingService.loanBook(bookingRequestLoan2);
        bookingService.returnBook(bookingRequestReturn1);
        bookingService.returnBook(bookingRequestReturn2);

        ArrayList<String> actualList = bookingService.searchByRate(2);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Dream Town");
        expectedList.add("Book Lovers");

        System.out.println("(actual) Available books: " + actualList.get(0) + "\n "
                + actualList.get(1));
        System.out.println("(expected) Available books: " + expectedList.get(0) + "\n "
                + expectedList.get(1));

        assertEquals(expectedList, actualList);

    }

}