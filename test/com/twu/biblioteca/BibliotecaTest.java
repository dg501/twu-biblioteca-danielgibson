package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.*;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class BibliotecaTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private PrintStream initialOutput = System.out;
    private InputStream inputStream = System.in;

    String[] placeholder;

    @Rule
    public TextFromStandardInputStream textMock = emptyStandardInputStream();
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setupStream() {
        System.setOut(new PrintStream(outputContent));
        System.setIn(System.in);
    }

    @After
    public void flushStream() {
        System.setOut(initialOutput);
        System.setIn(inputStream);
        outputContent.reset();
    }

    @Test
    public void shouldReturnWelcomeMessage() {

        String welcomeMessage = "Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!\n";

        textMock.provideLines("3");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), startsWith(welcomeMessage));
    }

    @Test
    public void shouldReturnBookSpecifications() {

        String[] bookArray = { "LoTR", "Twilight", "Jumanji" };
        String[] authorArray = { "Tolkien", "Stephanie Meyer", "John Smith" };
        String[] yearArray = { "1948", "2005", "2000" };

        textMock.provideLines("1","3");

        BibliotecaApp.main(placeholder);

        for (int i = 0; i < bookArray.length; i++) {
          assertThat(outputContent.toString(), containsString(bookArray[i]));
          assertThat(outputContent.toString(), containsString(authorArray[i]));
          assertThat(outputContent.toString(), containsString(yearArray[i]));

        }

    }

    @Test
    public void shouldPromptMainMenu() {

        String[] mainMenuItems = { "1. List of books", "2. Checkout a book", "3. Exit" };

        textMock.provideLines("3");

        BibliotecaApp.main(placeholder);

        for (int i = 0; i < mainMenuItems.length; i++) {
            assertThat(outputContent.toString(), containsString(mainMenuItems[i]));
        }
    }

    @Test
    public void shouldErrorOnIncorrectResponse() {

        String menuError = "Please select a valid option!";

        textMock.provideLines("59","3");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), containsString(menuError));

    }

    @Test
    public void shouldExitAppWhenISelectOption() {

        textMock.provideLines("3");
        exit.expectSystemExitWithStatus(0);

        BibliotecaApp.main(placeholder);
    }

    @Test
    public void shouldFilterBookByCheckout() {

        textMock.provideLines("2","LoTR","1","3");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), not(containsString("LoTR")));

    }
}
