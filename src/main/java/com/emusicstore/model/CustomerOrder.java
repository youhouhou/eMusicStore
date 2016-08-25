package com.emusicstore.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 泽宏 on 2016/8/24.
 */
@Entity
public class CustomerOrder implements Serializable {


    private static final long serialVersionUID = 2983360377227484514L;

    @Id
    @GeneratedValue
    private int customerOrderID;

    @OneToOne
    @JoinColumn(name = "cartID")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "customerID")
    private Customer customer;


    @OneToOne
    @JoinColumn(name = "shippingAddressID")
    private ShippingAddress shippingAddress;

    public int getCustomerOrderID() {
        return customerOrderID;
    }

    public void setCustomerOrderID(int customerOrderID) {
        this.customerOrderID = customerOrderID;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
