package com.emusicstore.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by 泽宏 on 2016/8/24.
 */
public class BillingAddress implements Serializable {

    private static final long serialVersionUID = -6091579459463730482L;

    @Id
    @GeneratedValue
    private int billingAddressID;
    private String apartmentNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    @OneToOne
    private Customer customer;

    public int getBillingAddressID() {
        return billingAddressID;
    }

    public void setBillingAddressID(int billingAddressID) {
        this.billingAddressID = billingAddressID;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "BillingAddress{" +
                "apartmentNumber='" + apartmentNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
