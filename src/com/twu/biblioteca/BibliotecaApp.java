package com.twu.biblioteca;

import java.util.Scanner;

import static com.twu.biblioteca.EntertainmentItems.checkItemStatus;
import static com.twu.biblioteca.EntertainmentItems.displayList;

public class BibliotecaApp {

    public static void main(String[] args) {

        Book[] listOfBooks = new Book[3];
        Movie[] collectionOfMovies = new Movie[3];

        String[] titleList = {"LoTR", "Twilight", "Jumanji"};
        String[] authorList = {"Tolkien", "Stephanie Meyer", "John Smith"};
        String[] publicationList = {"1948", "2005", "2000"};

        String[] nameList = {"Avengers", "Inception", "Braveheart"};
        String[] yearList = {"2018", "2010", "1995"};
        String[] directorList = {"Anthony Russo", "Christopher Nolan", "Mel Gibson"};
        String[] ratingList = {"10", "8", "9"};

        for (int i = 0; i < listOfBooks.length; i++) {
            listOfBooks[i] = new Book(titleList[i], authorList[i], publicationList[i]);
            collectionOfMovies[i] = new Movie(nameList[i], directorList[i], yearList[i], ratingList[i]);
        }

        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!");

        Scanner scan = new Scanner(System.in);
        String userInput = "";

        do {
            System.out.println("\n1. List of books [1]\n2. Checkout a book [2]\n3. Return a book [3]\n4. Display " +
                    "movies [4]\n5. Checkout a movie [5]\n6. Exit [6]\n");

            if (scan.hasNextLine()) {

                userInput = scan.nextLine();

                switch (userInput) {

                    case "1":
                        displayList(listOfBooks);
                        break;

                    case "2":
                        System.out.println("\nSelect book title:");
                        userInput = scan.nextLine();

                        if (checkItemStatus(listOfBooks,userInput)) {
                            System.out.println("Thank you! Enjoy the book");
                        } else { System.out.println("Sorry, that book is not available"); }

                        break;

                    case "3":
                        System.out.println("\nBook you are returning:");
                        userInput = scan.nextLine();

                        if (checkItemStatus(listOfBooks, userInput)) {
                            System.out.println("Thank you for returning the book");
                        } else { System.out.println("That is not a valid book to return"); }

                        break;

                    case "4":
                        displayList(collectionOfMovies);
                        break;

                    case "5":
                        //checkout movies
                        break;

                    case "6":
                        break;

                    default:
                        System.out.println("\nPlease select a valid option!");
                        break;
                }
            }
        } while (!userInput.equals("6"));
    }
}
