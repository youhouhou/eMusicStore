package com.emusicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 泽宏 on 2016/8/22.
 */

@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = -3556608061044383556L;

    @Id
    @GeneratedValue
    private int cartID;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name="customerID")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}
