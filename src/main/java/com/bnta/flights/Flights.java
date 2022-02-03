package com.bnta.flights;

import com.bnta.customer.Customer;
import com.bnta.customer.Luggage;

import java.time.LocalDateTime;

public class Flights {
    private FlightNumber flightNumber;
    private Locations startLocation;
    private Locations endLocation;
    private String dateTime;
    private double price;
    public Customer[] customersBooked;


    public FlightNumber getFlightNumber() {
        return flightNumber;
    }
    public Locations getStartLocation() {
        return startLocation;
    }
    public Locations getEndLocation() {
        return endLocation;
    }
    public String getDateTime() {
        return dateTime;
    }
    public double getPrice() {
        return price;
    }
    public Customer[] getCustomersBooked() {
        return customersBooked;
    }
    public void setCustomersBooked(Customer[] customerBooking){
        this.customersBooked = customerBooking;
    }

    public void setFlights(
            FlightNumber flightNumber,
            Locations startLocation,
            Locations endLocation,
            String dateTime,
            double price,
            Customer[] customerBooking) {
        this.flightNumber = flightNumber;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.dateTime = dateTime;
        this.price = price;
        this.customersBooked = customerBooking;
    }

}
