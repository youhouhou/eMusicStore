package com.emusicstore.Service;

import com.emusicstore.model.Cart;

/**
 * Created by 泽宏 on 2016/8/25.
 */
public interface CartService {

    Cart getCartByID(int cartID);

    void update(Cart cart);

}
