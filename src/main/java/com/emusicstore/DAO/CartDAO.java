package com.emusicstore.DAO;

import com.emusicstore.model.Cart;

/**
 * Created by 泽宏 on 2016/8/22.
 */
public interface CartDAO {

    Cart getCartByID(int cartID);

    void update(Cart cart);


}
