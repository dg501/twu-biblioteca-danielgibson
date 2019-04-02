package com.twu.biblioteca;

public class Book {

    private final String title;
    private final String author;
    private final String publication;
    private boolean checkoutBook = false;

    public Book(String title, String author, String publication) {
        this.title = title;
        this.author = author;
        this.publication = publication;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication() {
        return publication;
    }

    public boolean getCheckOut() {
        return checkoutBook;
    }

    public void setCheckOut() {
        this.checkoutBook = true;
    }

}
