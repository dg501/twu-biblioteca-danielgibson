package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.*;

import static com.twu.biblioteca.LoginInfo.loginToAccount;
import static org.hamcrest.core.IsEqual.equalTo;
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
    @Mock private LoginInfo accInf = new LoginInfo("name", "email", 12345678);

    @Test
    public void shouldCreateLoginInfoObject() {

        String libNum = "123-4567";
        String pwd = "password";

        assertThat(logInf.getLibraryIdNum(),equalTo(libNum));
        assertThat(logInf.getPassword(),equalTo(pwd));

    }

    @Test
    public void shouldCreateAccountInfoObject() {

        String name = "name";
        String email = "email";
        Integer phoneNo = 12345678;

        assertThat(accInf.getName(),equalTo(name));
        assertThat(accInf.getEmail(),equalTo(email));
        assertThat(accInf.getPhoneNo(),equalTo(phoneNo));

    }

    @Test
    public void shouldLoginToAccountSuccessfully() {

        String libNum = "123-4567";
        String pwd = "password";

        assertTrue(loginToAccount(libNum, pwd, logInf));
    }

}
