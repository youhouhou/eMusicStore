package com.emusicstore.Service.impl;

import com.emusicstore.DAO.CartItemDAO;
import com.emusicstore.Service.CartItemService;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 泽宏 on 2016/8/26.
 */

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDAO cartItemDAO;

    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDAO.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart) {
        cartItemDAO.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductID(int productID){
        return cartItemDAO.getCartItemByProductID(productID);
    }
}
