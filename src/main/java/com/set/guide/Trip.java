package com.set.guide;

public class Trip {

    private String location;
    private int price;

    public Trip(String location, int price) {
        this.location = location;
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "(Location: " + location + ", Price: " + price + "kr)";
    }
}
