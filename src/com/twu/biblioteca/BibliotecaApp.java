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
            System.out.println("\n1. List of books [1]\n2. Checkout a book [2]\n3. Return a book [3]\n4. Exit [4]\n");

            if (scan.hasNextLine()) {

                userInput = scan.nextLine();

                switch (userInput) {

                    case "1":
                        displayBooks(listOfBooks);
                        break;

                    case "2":
                        System.out.println("\nSelect book title:");
                        userInput = scan.nextLine();

                        if (checkBookStatus(listOfBooks,userInput)) {
                            System.out.println("Thank you! Enjoy the book");
                        } else { System.out.println("Sorry, that book is not available"); }

                        break;

                    case "3":
                        System.out.println("\nBook you are returning:");
                        userInput = scan.nextLine();

                        if (checkBookStatus(listOfBooks, userInput)) {
                            System.out.println("Thank you for returning the book");
                        } else { System.out.println("That is not a valid book to return"); }

                        break;

                    case "4":
                        break;

                    default:
                        System.out.println("\nPlease select a valid option!");
                        break;
                }
            }
        } while (!userInput.equals("4"));
    }

    public static void displayBooks(Book[] bookList) {

        for (Book book : bookList) {

            if (!book.getCheckOut()) {
                String format = "%-20s||%-20s||%10s%n";
                System.out.format(format, book.getTitle(), book.getAuthor(), book.getPublication());
            }
        }

    }

    public static boolean checkBookStatus(Book[] bookList, String title) {

        for (Book book : bookList) {

            if (book.getTitle().equals(title) && book.getCheckOut() == false) {
                book.setCheckOut(true);
                return true;
            }

            else if (book.getTitle().equals(title) && book.getCheckOut() == true) {
                book.setCheckOut(false);
                return true;
            }
        }

        return false;

    }
}
