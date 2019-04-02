package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!");

        Scanner scan = new Scanner(System.in);
        String userInput = "";

        do {
            System.out.println("\n1. List of books [1]\n2. Something [2]\n3. Exit [3]\n");

            if (scan.hasNextLine()) {

                userInput = scan.nextLine();

                switch (userInput) {

                    case "1":
                        displayBooks();
                        break;

                    case "2":
                        //do something
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
