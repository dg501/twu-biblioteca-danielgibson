package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        String[] bookList = { "LoTR", "Twilight", "Jumanji" };
        String[] authorList = { "Tolkien", "Stephanie Meyer", "John Smith" };
        String[] publicationList = { "1948", "2005", "2000" };

        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!\n");

        for (int i = 0; i < bookList.length; i++) {

            String book = bookList[i];
            String author = authorList[i];
            String publication = publicationList[i];
            String format = "%-20s||%-20s||%10s%n";

            System.out.format(format, book, author, publication);
        }

    }
}
