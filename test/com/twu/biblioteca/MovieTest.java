package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.*;

import static org.junit.Assert.*;

public class MovieTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setupStream() {
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void flushStream() {
        outputContent.reset();
    }

    @Mock private Movie movie = new Movie("title", "director", "year", "0");

    @Test
    public void shouldCreateMovieWithAttributes() {
        assertSame(movie.getTitle(),"title");
        assertSame(movie.getCreator(),"director");
        assertSame(movie.getYear(),"year");
        assertSame(movie.getRating(), "0");
    }

    @Test
    public void shouldAlterMovieCheckoutStatus() {
        assertFalse(movie.getCheckOut());
    }

}
