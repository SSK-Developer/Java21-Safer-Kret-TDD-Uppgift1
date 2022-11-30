package org.example;

public class BookingRequest {

    private boolean goodOrBad;
    private String userID;
    private String bookName;
    private int Pay;
    boolean paid;

    public BookingRequest(String userID, String bookName, int pay, boolean paid) {
        this.userID = userID;
        this.bookName = bookName;
        Pay = pay;
        this.paid = paid;
    }

    public BookingRequest(String bookName, boolean goodOrBad) {
        this.bookName = bookName;
        this.goodOrBad = goodOrBad;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPay() {
        return Pay;
    }

    public void setPay(int pay) {
        Pay = pay;
    }

    public boolean goodOrBad() {
        return goodOrBad;
    }

    public void setGoodOrBad(boolean goodOrBad) {
        this.goodOrBad = goodOrBad;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
