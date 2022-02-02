package com.bnta.flights;

import com.bnta.customer.Customer;

import java.util.Arrays;
import java.util.Objects;

public class Airline {
    // name
    // flights array
    private String name;
    private Flights[] flights;
    private Customer[] customers;

    public String getAirlineName() {
        return name;
    }
    public Flights[] getFlights() {
        return flights;
    }
    public Customer[] getCustomers(){
        return customers;
    }
    public void setName(){
        this.name = "MJMC Airline Ltd.";
    }

    public void setFlights(Flights[] flights) {
        this.flights = flights;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(name, airline.name) && Arrays.equals(flights, airline.flights);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(flights);
        return result;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", flights=" + Arrays.toString(flights) +
                '}';
    }
}
