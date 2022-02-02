package com.bnta.flights;

import java.time.LocalDateTime;

public class Flights {
    private String flightNumber;
    private Locations startLocation;
    private Locations endLocation;
    private LocalDateTime dateTime;
    private double price;
    private Customer[] customersBooked;


    public String getFlightNumber() {
        return flightNumber;
    }
    public Locations getStartLocation() {
        return startLocation;
    }
    public Locations getEndLocation() {
        return endLocation;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public double getPrice() {
        return price;
    }
    public Customer[] getCustomersBooked() {
        return customersBooked;
    }

    public void setFlights(
            String flightNumber,
            Locations startLocation,
            Locations endLocation,
            LocalDateTime dateTime,
            double price,
            Customer[] customersBooked) {
        this.flightNumber = flightNumber;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.dateTime = dateTime;
        this.price = price;
        this.customersBooked = customersBooked;
    }
}
