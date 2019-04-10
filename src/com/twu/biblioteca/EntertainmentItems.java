package com.twu.biblioteca;

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



}
