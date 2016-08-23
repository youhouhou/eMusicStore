package com.emusicstore.DAO.impl;

import com.emusicstore.DAO.CartDAO;
import com.emusicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 泽宏 on 2016/8/22.
 */
@Repository
public class CartDAOImpl implements CartDAO {
    private Map<String, Cart> listCarts;

    public CartDAOImpl(){
        listCarts = new HashMap<String, Cart>();

    }

    public Cart create(Cart cart){
        if(listCarts.keySet().contains(cart.getCartID())){
            throw new IllegalArgumentException(String.format(
                    "Cannot create a cart with the given id(%) already exist" ,cart.getCartID()));
        }
        listCarts.put(cart.getCartID(),cart);

        return cart;
    }

    public Cart read(String cartID) {
        return listCarts.get(cartID);
    }

    public void update(String cartID, Cart cart){
        if(!listCarts.keySet().contains(cartID)){
            throw new IllegalArgumentException(String.format(
                    "Cannot update a cart with the given id(%) not exist" ,cart.getCartID()));
        }

        listCarts.put(cartID,cart);

    }

    public void delete(String cartID){
        if(!listCarts.keySet().contains(cartID)){
            throw new IllegalArgumentException(String.format(
                    "Cannot delete a cart with the given id(%) not exist" ,cartID));
        }
        listCarts.remove(cartID);
    }

}
