package com.emusicstore.DAO.impl;

import com.emusicstore.DAO.CartDAO;
import com.emusicstore.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 泽宏 on 2016/8/25.
 */
@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

    @Autowired
    SessionFactory sessionFactory;


    public Cart getCartByID(int cartID) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart)session.get(Cart.class,cartID);
    }

    public void update(Cart cart) {
        int CartID = cart.getCartID();
        //
    }
}
