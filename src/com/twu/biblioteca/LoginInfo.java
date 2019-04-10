package com.twu.biblioteca;

import java.util.Scanner;

public class LoginInfo {

    private String libraryIdNum;
    private String password;
    private String name;
    private String email;
    private Integer phoneNo;

    public LoginInfo(String libraryIdNum, String password) {
        this.libraryIdNum = libraryIdNum;
        this.password = password;
    }

    public LoginInfo(String name, String email, Integer phoneNo) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getLibraryIdNum() {
        return libraryIdNum;
    }


    // There were no security requirements, so I'm guessing this is ok for the sake of the story!
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public String displayPrivateInfo(LoginInfo logInf) {
        return ("\nName: " +  logInf.getName()
                + "\nEmail: " + logInf.getEmail()
                + "\nPhone Number: " + logInf.getPhoneNo());
    }

    public static Boolean loginToAccount(Scanner scan, LoginInfo logInf) {

        System.out.println("Please login.\n\nLibrary Number:");
        String libNum = scan.nextLine();

        System.out.println("\nPassword:");
        String pwd = scan.nextLine();

        if (libNum.equals(logInf.getLibraryIdNum()) && pwd.equals(logInf.getPassword())) {
            return true;
        } else {
            System.out.println("Incorrect username or password. Returning to main menu");
            return false;
        }
    }
}
