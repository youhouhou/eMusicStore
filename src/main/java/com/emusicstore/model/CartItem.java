package com.emusicstore.model;

/**
 * Created by 泽宏 on 2016/8/22.
 */
public class CartItem {
    private Product product;
    private int quantity;
    private double totalPrice;

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getProductPrice();
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
