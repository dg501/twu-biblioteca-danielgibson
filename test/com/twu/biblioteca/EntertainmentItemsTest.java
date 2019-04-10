package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class EntertainmentItemsTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setupStream() {
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void flushStream() {
        outputContent.reset();
    }

    @Mock private EntertainmentItems entertainmentItems = new EntertainmentItems("title","creator","year");

    @Test
    public void shouldCreateEntertainmentItemWithParameters() {

        String title = "title";
        String creator = "creator";
        String year = "year";

        assertThat(entertainmentItems.getTitle(), equalTo(title));
        assertThat(entertainmentItems.getCreator(), equalTo(creator));
        assertThat(entertainmentItems.getYear(), equalTo(year));

    }

    @Test
    public void shouldChangeCheckoutStatusOfItem() {
        assertFalse(entertainmentItems.getCheckOut());
    }

}
