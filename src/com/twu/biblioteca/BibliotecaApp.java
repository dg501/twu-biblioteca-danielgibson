package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Book[] listOfBooks = new Book[3];

        String[] titleList = {"LoTR", "Twilight", "Jumanji"};
        String[] authorList = {"Tolkien", "Stephanie Meyer", "John Smith"};
        String[] publicationList = {"1948", "2005", "2000"};

        for (int i = 0; i < listOfBooks.length; i++) {
            listOfBooks[i] = new Book(titleList[i], authorList[i], publicationList[i]);
        }

        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!");

        Scanner scan = new Scanner(System.in);
        String userInput = "";

        do {
            System.out.println("\n1. List of books [1]\n2. Checkout a book [2]\n3. Exit [3]\n");

            if (scan.hasNextLine()) {

                userInput = scan.nextLine();

                switch (userInput) {

                    case "1":
                        displayBooks(listOfBooks);
                        break;

                    case "2":
                        System.out.println("\nSelect book title:");
                        userInput = scan.nextLine();

                        for(Book book : listOfBooks) {

                            if (book.getTitle().equals(userInput)) {
                                book.setCheckOut();
                                System.out.println("Thank you! Enjoy the book");
                            }

                        }
                        break;

                    case "3":
                        break;

                    default:
                        System.out.println("\nPlease select a valid option!");
                        break;
                }
            }
        } while (!userInput.equals("3"));
    }

    public static void displayBooks(Book[] bookList) {

        for (Book book : bookList) {

            if (!book.getCheckOut()) {
                String format = "%-20s||%-20s||%10s%n";
                System.out.format(format, book.getTitle(), book.getAuthor(), book.getPublication());
            }
        }

    }
}
