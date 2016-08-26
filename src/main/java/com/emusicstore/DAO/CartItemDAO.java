package com.emusicstore.DAO;

import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;

/**
 * Created by 泽宏 on 2016/8/26.
 */
public interface CartItemDAO {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductID(int productID);

}
