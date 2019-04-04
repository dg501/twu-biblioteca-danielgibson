package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.*;

import static org.junit.Assert.*;

public class LoginInfoTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void setupStream() {
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void flushStream() {
        outputContent.reset();
    }

    @Mock private LoginInfo logInf = new LoginInfo("123-4567", "password");

    @Test
    public void shouldCreateLoginInfoObject() {
        assertSame(logInf.getLibraryIdNum(),"123-4567");
        assertSame(logInf.getPassword(),"password");
    }

}
