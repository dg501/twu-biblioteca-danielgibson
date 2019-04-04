package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class BibliotecaTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private PrintStream initialOutput = System.out;
    private InputStream inputStream = System.in;

    String[] placeholder;

    @Mock LoginInfo logInf = new LoginInfo("123-4567","password");

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

        textMock.provideLines("6");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), startsWith(welcomeMessage));
    }

    @Test
    public void shouldReturnBookSpecifications() {

        String[] bookArray = { "LoTR", "Twilight", "Jumanji" };
        String[] authorArray = { "Tolkien", "Stephanie Meyer", "John Smith" };
        String[] yearArray = { "1948", "2005", "2000" };

        textMock.provideLines("1","6");

        BibliotecaApp.main(placeholder);

        for (int i = 0; i < bookArray.length; i++) {
          assertThat(outputContent.toString(), containsString(bookArray[i]));
          assertThat(outputContent.toString(), containsString(authorArray[i]));
          assertThat(outputContent.toString(), containsString(yearArray[i]));
        }

    }

    @Test
    public void shouldPromptMainMenu() {

        String[] mainMenuItems = {
                "1. List of books",
                "2. Checkout a book",
                "3. Return a book",
                "4. Display movies",
                "5. Checkout a movie",
                "6. Exit"
        };

        textMock.provideLines("6");

        BibliotecaApp.main(placeholder);

        for (int i = 0; i < mainMenuItems.length; i++) {
            assertThat(outputContent.toString(), containsString(mainMenuItems[i]));
        }
    }

    @Test
    public void shouldErrorOnIncorrectResponse() {

        String menuError = "Please select a valid option!";

        textMock.provideLines("59","6");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), containsString(menuError));

    }

    @Test
    public void shouldExitAppWhenISelectOption() {

        textMock.provideLines("6");
        exit.expectSystemExitWithStatus(0);

        BibliotecaApp.main(placeholder);
    }

    @Test
    public void shouldFilterBookByCheckout() {

        textMock.provideLines("2","500-3854","1234","LoTR","1","6");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), not(containsString("LoTR")));

    }

    @Test
    public void shouldDisplaySuccessMessageOnBookCheckout() {

        textMock.provideLines("2","500-3854","1234","LoTR","6");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldDisplayFailureMessageOnBookCheckout() {

        textMock.provideLines("2","500-3854","1234","Sabriel","6");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), containsString("Sorry, that book is not available"));
    }

    @Test
    public void shouldReturnBookAndUpdateStatus() {

        textMock.provideLines("2","500-3854","1234","LoTR","1","3","500-3854","1234","LoTR","1","6");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), containsString("LoTR"));

    }

    @Test
    public void shouldDisplayReturnBookMessageOnSuccess() {

        textMock.provideLines("2","500-3854","1234","Jumanji","3","500-3854","1234","Jumanji","6");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), containsString("Thank you for returning the book"));
    }

    @Test
    public void shouldShowErrorMessageWhenReturningUnknownBook() {

        textMock.provideLines("3","500-3854","1234","The Great Gatsby","6");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), containsString("That is not a valid book"));
    }

    @Test
    public void shouldShowMovieList() {

        String[] nameArray = { "Avengers", "Inception", "Braveheart" };
        String[] directorArray = { "Anthony Russo", "Christopher Nolan", "Mel Gibson" };
        String[] ratingArray = { "10", "8", "9" };

        textMock.provideLines("4","6");

        BibliotecaApp.main(placeholder);

        for (int i = 0; i < nameArray.length; i++) {
            assertThat(outputContent.toString(), containsString(nameArray[i]));
            assertThat(outputContent.toString(), containsString(directorArray[i]));
            assertThat(outputContent.toString(), containsString(ratingArray[i]));
        }
    }

    @Test
    public void shouldCheckoutMovieSuccessfully() {

        textMock.provideLines("5","Inception","4","6");

        BibliotecaApp.main(placeholder);
        assertThat(outputContent.toString(), not(containsString("Inception")));
    }

    @Test
    public void shouldFailLoginToAccountWhenCheckingBookOut() {

        textMock.provideLines("2",logInf.getLibraryIdNum(),logInf.getPassword(),"6");

        BibliotecaApp.main(placeholder);
        assertThat(logInf, is(notNullValue()));
        assertThat(outputContent.toString(), containsString("Incorrect login. Returning to main menu"));

    }

    @Test
    public void shouldPassLoginToAccountWhenCheckingBookOut() {

        textMock.provideLines("2","500-3854","1234","s","6");

        BibliotecaApp.main(placeholder);
        assertThat(logInf, is(notNullValue()));
        assertThat(outputContent.toString(), containsString("Sorry, that book is not available"));

    }

    @Test
    public void shouldDisplayDetailsOnSuccessRequest() {

        textMock.provideLines("7","500-3854","1234","6");

        BibliotecaApp.main(placeholder);
        assertThat(logInf, is(notNullValue()));
        assertThat(outputContent.toString(), containsString("Daniel"));
    }
}
