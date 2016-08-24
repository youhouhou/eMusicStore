package com.emusicstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by 泽宏 on 2016/8/24.
 */

@Entity
public class ShippingAddress implements Serializable {


    private static final long serialVersionUID = 989191150380037359L;
    @Id
    @GeneratedValue
    private int ShippingAddressID;
    private String apartmentNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    @OneToOne
    private Customer customer;

    public int getShippingAddressID() {
        return ShippingAddressID;
    }

    public void setShippingAddressID(int shippingAddressID) {
        ShippingAddressID = shippingAddressID;
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
        return "ShippingAddress{" +
                "apartmentNumber='" + apartmentNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
