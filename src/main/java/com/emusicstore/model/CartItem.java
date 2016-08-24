package com.emusicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 泽宏 on 2016/8/22.
 */

@Entity
//serilizable is used for later spring web flow module
public class CartItem implements Serializable {


    private static final long serialVersionUID = 4019853624864468223L;

    @Id
    @GeneratedValue
    private int cartItemID;

    @ManyToOne
    @JoinColumn(name="cartID")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;


    private int quantity;
    private double totalPrice;

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getProductPrice();
    }

    public int getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(int cartItemID) {
        this.cartItemID = cartItemID;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
