package com.bnta.customer;

import com.bnta.flights.FlightNumber;
import com.bnta.flights.Flights;
import com.bnta.flights.Airline;
import com.bnta.flights.Locations;

import java.util.Objects;

public class Customer {

    private String name;
    private String email;
    private int id;
    private int phoneNumber;
    private int passportNumber;
    private Luggage luggage;
    private Flights flights;
    // 1. customers/ user
    // name
    // email
    // id (random generator)
    // phone number
    // passport number?
    // luggage?

    //default constructor
    //public Customer(){}

    //constructor for just name
    //public Customer(String name){
    //    this.name = name;
    //}

   // Customer(String name);

    public Customer(String name, String email, int id, int phoneNumber, int passportNumber, Luggage luggage, Flights flights){
        this.name = name;
        this.email = email;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
        this.luggage = luggage;
        this.flights = flights;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public int getPassportNumber(){
        return passportNumber;
    }
    public void setPassportNumber(int passportNumber){
        this.passportNumber = passportNumber;
    }

    public Luggage getLuggage() {
        return luggage;
    }
    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public Flights getFlight() {
        return flights;
    }
    public void setFlight(Flights flights) {
        this.flights = flights;
    }

    public void setFlights(Flights flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && phoneNumber == customer.phoneNumber && passportNumber == customer.passportNumber && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && luggage == customer.luggage && Objects.equals(flights, customer.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, id, phoneNumber, passportNumber, luggage, flights);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", passportNumber=" + passportNumber +
                ", luggage=" + luggage+
                ", flights=" + flights +
                '}';
    }
}
