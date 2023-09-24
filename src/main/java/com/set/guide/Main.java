package com.set.guide;

public class Main {
    public static void main(String[] args) {
        Trip oslo = new Trip("Oslo", 100);
        Trip sarp = new Trip("Sarpsborg", 200);
        TripList tripList = new TripList();

        tripList.addTrip(oslo);
        tripList.addTrip(sarp);

        System.out.println(tripList);

        tripList.deleteTrip(oslo);

        System.out.println(tripList);

    }
}
