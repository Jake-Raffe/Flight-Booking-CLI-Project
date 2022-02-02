package com.bnta.flights;

import java.util.Arrays;
import java.util.Objects;

public class Airline {
    // name
    // flights array
    private String name;
    private Flights[] flights;

    public String getAirlineName() {
        return name;
    }
    public Flights[] getFlights() {
        return flights;
    }

    public void setFlights(
                   Flights[] flights) {
        this.name = "MJMC Airline Ltd.";
        this.flights = flights;
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
