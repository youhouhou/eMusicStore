package com.emusicstore.Service.impl;

import com.emusicstore.DAO.CartDAO;
import com.emusicstore.Service.CartService;
import com.emusicstore.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 泽宏 on 2016/8/25.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;

    public Cart getCartByID(int cartID) {
        return cartDAO.getCartByID(cartID);
    }

    public void update(Cart cart) {
        cartDAO.update(cart);
    }


}
