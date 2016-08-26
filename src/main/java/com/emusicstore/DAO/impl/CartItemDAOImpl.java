package com.emusicstore.DAO.impl;

import com.emusicstore.DAO.CartItemDAO;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 泽宏 on 2016/8/26.
 */
@Repository
@Transactional
public class CartItemDAOImpl implements CartItemDAO{

    @Autowired
    private SessionFactory sessionFactory;


    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItemList = cart.getCartItems();
        for(CartItem cartItem : cartItemList){
            removeCartItem(cartItem);
        }
    }

    public CartItem getCartItemByProductID(int productID) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Customer where productID = ?");
        query.setInteger(0,productID);
        session.flush();

        return (CartItem)query.uniqueResult();
    }
}
