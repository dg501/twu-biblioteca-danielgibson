package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

public class BibliotecaTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private PrintStream initialOutput = System.out;

    String[] placeholder;

    @Before
    public void setupStream() {
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void flushStream() {
        System.setOut(initialOutput);
    }

    @Test
    public void shouldReturnWelcomeMessage() {

        BibliotecaApp.main(placeholder);
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!\n";

        assertThat(outputContent.toString(), startsWith(welcomeMessage));


    }

    @Test
    public void shouldReturnListOfBooks() {

        BibliotecaApp.main(placeholder);
        String[] bookArray = { "LoTR", "Twilight", "Jumanji" };

        for (int i = 0; i < bookArray.length; i++) {
          assertThat(outputContent.toString(), containsString(bookArray[i]));
        }

    }

    @Test
    public void shouldShowBookAuthors() {

        BibliotecaApp.main(placeholder);
        String[] authorArray = { "Tolkien", "Stephanie Meyer", "John Smith" };

        for (int i = 0; i < authorArray.length; i++) {
            assertThat(outputContent.toString(), containsString(authorArray[i]));
        }


    }

    @Test
    public void shouldListPublicationYear() {

        BibliotecaApp.main(placeholder);
        String[] yearArray = { "1948", "2005", "2000" };

        for (int i = 0; i < yearArray.length; i++) {
            assertThat(outputContent.toString(), containsString(yearArray[i]));
        }


    }
}
