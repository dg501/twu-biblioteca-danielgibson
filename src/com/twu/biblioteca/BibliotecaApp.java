package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        String[] bookList = { "LoTR", "Twilight", "Jumanji"};

        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!\n");

        for (int i = 0; i < bookList.length; i++) {
            System.out.println(bookList[i] + '\n');
        }

    }
}
