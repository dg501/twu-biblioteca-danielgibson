package com.twu.biblioteca;

public class LoginInfo {

    private final String libraryIdNum;
    private final String password;

    public LoginInfo(String libraryIdNum, String password) {
        this.libraryIdNum = libraryIdNum;
        this.password = password;
    }

    public String getLibraryIdNum() {
        return libraryIdNum;
    }


    // There were no security requirements, so I'm guessing this is ok for the sake of the story!
    public String getPassword() {
        return password;
    }


}
