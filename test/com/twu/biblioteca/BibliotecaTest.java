package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

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

        String welcomeMessage = "Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!\n";

        String userInput = "1";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        BibliotecaApp.main(placeholder);

        assertThat(outputContent.toString(), startsWith(welcomeMessage));

    }

    @Test
    public void shouldReturnListOfBooks() {

        String[] bookArray = { "LoTR", "Twilight", "Jumanji" };

        String userInput = "1";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        BibliotecaApp.main(placeholder);

        for (int i = 0; i < bookArray.length; i++) {
          assertThat(outputContent.toString(), containsString(bookArray[i]));
        }

    }

    @Test
    public void shouldShowBookAuthors() {

        String[] authorArray = { "Tolkien", "Stephanie Meyer", "John Smith" };

        String userInput = "1";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        BibliotecaApp.main(placeholder);

        for (int i = 0; i < authorArray.length; i++) {
            assertThat(outputContent.toString(), containsString(authorArray[i]));
        }

    }

    @Test
    public void shouldListPublicationYear() {

        String[] yearArray = { "1948", "2005", "2000" };

        String userInput = "1";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        BibliotecaApp.main(placeholder);

        for (int i = 0; i < yearArray.length; i++) {
            assertThat(outputContent.toString(), containsString(yearArray[i]));
        }

    }

    @Test
    public void shouldPromptMainMenu() {

        String[] mainMenuItems = { "~~Main Menu~~", "1. List all books", "2. Something", "3. Exit" };

        String userInput = "1";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        BibliotecaApp.main(placeholder);

        for (int i = 0; i < mainMenuItems.length; i++) {
            assertThat(outputContent.toString(), containsString(mainMenuItems[i]));
        }
    }

    @Test
    public void shouldErrorOnIncorrectResponse() {

        String menuError = "Please select a valid option!";

        String userInput = "2382937";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        BibliotecaApp.main(placeholder);

        assertThat(outputContent.toString(), containsString(menuError));

    }
}
