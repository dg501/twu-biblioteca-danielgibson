package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!\n");
        System.out.println("~~Main Menu~~\n\n1. List all books [1]\n2. Something [2]\n3. Placeholder [3]\n");

        Scanner scan = new Scanner(System.in);
        String userInput = scan.next();

        switch(userInput) {

            case "1":
                displayBooks();
                break;

            case "2":
                //do something
                break;

            case "3":
                //something else
                break;
        }
    }

    public static void displayBooks() {

        String[] bookList = {"LoTR", "Twilight", "Jumanji"};
        String[] authorList = {"Tolkien", "Stephanie Meyer", "John Smith"};
        String[] publicationList = {"1948", "2005", "2000"};

        for (int i = 0; i < bookList.length; i++) {

            String book = bookList[i];
            String author = authorList[i];
            String publication = publicationList[i];
            String format = "%-20s||%-20s||%10s%n";

            System.out.format(format, book, author, publication);

        }
    }
}
