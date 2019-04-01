package com.twu.biblioteca;


import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        assertThat(welcomeMessage, IsEqual.equalTo(outputContent.toString()));

    }
}
