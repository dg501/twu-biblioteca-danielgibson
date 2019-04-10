package com.twu.biblioteca;

import com.sun.tools.javac.comp.Enter;

import java.util.Scanner;

public class EntertainmentItems {

    protected final String title;
    protected final String creator;
    protected final String year;
    protected boolean checkoutItem = false;

    public EntertainmentItems(String title, String creator, String year) {
        this.title = title;
        this.creator = creator;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public String getYear() {
        return year;
    }

    public boolean getCheckOut() {
        return checkoutItem;
    }

    public void setCheckOut(boolean checkoutItem) {
        this.checkoutItem = checkoutItem;
    }

    public static void displayList(EntertainmentItems[] itemList) {

        for (EntertainmentItems item : itemList) {

            if (!item.getCheckOut()) {
                String format = "%-20s||%-20s||%10s%n";
                System.out.format(format, item.getTitle(), item.getCreator(), item.getYear());
            }
        }

    }

    public static Boolean checkItemStatus(EntertainmentItems[] itemList, String title) {

        for (EntertainmentItems item : itemList) {

            if (item.getTitle().equals(title) && item.getCheckOut() == false) {
                item.setCheckOut(true);
                return true;
            }

            else if (item.getTitle().equals(title) && item.getCheckOut() == true) {
                item.setCheckOut(false);
                return true;
            }
        }

        return false;

    }

    public static void checkoutItem(EntertainmentItems[] itemList, Scanner scan) {

        System.out.println("\nSelect the title:");
        String title = scan.nextLine();

        for (EntertainmentItems item : itemList) {

            if (checkItemStatus(itemList, title) && item instanceof Book) {
                System.out.println("Thank you! Enjoy the book");
                break;
            } else if (item instanceof Book) {
                System.out.println("Sorry, that book is not available");
                break;
            }

            if (checkItemStatus(itemList, title) && item instanceof Movie) {
                System.out.println("Enjoy your movie!");
                break;
            } else if (item instanceof Movie) {
                System.out.println("Sorry this movie is unavailable");
                break;
            }

        }

    }

    public static void returnItem(EntertainmentItems[] itemList, Scanner scan) {

        System.out.println("\nTitle of item you are returning:");
        String title = scan.nextLine();

        for (EntertainmentItems item : itemList) {

            if (checkItemStatus(itemList, title) && item instanceof Book){
                System.out.println("Thank you for returning the book");
                break;
            } else if (item instanceof Book) {
                System.out.println("That is not a valid book to return");
                break;
            }

            if (checkItemStatus(itemList, title) && item instanceof Movie) {
                System.out.println("Thank you for returning the movie");
                break;
            } else if (item instanceof Movie) {
                System.out.println("Invalid movie title.");
                break;
            }

        }
    }
}
