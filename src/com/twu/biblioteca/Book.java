package com.twu.biblioteca;

public class Book extends EntertainmentItems {

    private boolean checkoutBook = false;

    public Book(String title, String author, String publication) {
        super(title, author, publication);
    }

    public boolean getCheckOut() {
        return checkoutBook;
    }

    public void setCheckOut(boolean checkoutBook) {
        this.checkoutBook = checkoutBook;
    }

}
