package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.*;

import static org.junit.Assert.*;

public class BookTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setupStream() {
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void flushStream() {
        outputContent.reset();
    }

    @Mock private Book book = new Book("title", "author", "publication");

    @Test
    public void shouldCreateBookWithAttributes() {
        assertSame(book.getTitle(),"title");
        assertSame(book.getAuthor(),"author");
        assertSame(book.getPublication(),"publication");
    }

    @Test
    public void shouldAlterBookCheckoutStatus() {
        assertFalse(book.getCheckOut());
    }

}
