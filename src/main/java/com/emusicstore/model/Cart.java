package com.emusicstore.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 泽宏 on 2016/8/22.
 */
public class Cart {
    private String cartID;
    private Map<String,CartItem> cartItems;
    private double grandTotal;

    private Cart(){
        cartItems = new HashMap<String, CartItem>();
        grandTotal = 0;
    }

    public Cart(String cartID){
        this();
        this.cartID = cartID;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

     public void addCartItem(CartItem item){
         String productID = item.getProduct().getProductID();

         if(cartItems.containsKey(productID)){
             CartItem existingCartItem = cartItems.get(productID);
             existingCartItem.setQuantity(existingCartItem.getQuantity()+item.getQuantity());
             cartItems.put(productID,existingCartItem);
         }else{
             cartItems.put(productID,item);
         }
         updateGrandTotal();
     }

     public void removeCartItem(CartItem item){
         String productID = item.getProduct().getProductID();
         cartItems.remove(productID);
         updateGrandTotal();
     }

     public void updateGrandTotal(){
         grandTotal = 0;
         for(CartItem item : cartItems.values()){
             grandTotal = grandTotal + item.getTotalPrice();
         }
     }

}
