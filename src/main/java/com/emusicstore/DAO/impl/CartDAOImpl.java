package com.emusicstore.DAO.impl;

import com.emusicstore.DAO.CartDAO;
import com.emusicstore.Service.CustomerOrderService;
import com.emusicstore.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by 泽宏 on 2016/8/25.
 */
@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;


    public Cart getCartByID(int cartID) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart)session.get(Cart.class,cartID);
    }

    public void update(Cart cart) {
        int cartID = cart.getCartID();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartID);
        cart.setGrandTotal(grandTotal);
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }

    public Cart validate(int cartID) throws IOException {
        Cart cart = getCartByID(cartID);
        if(cart == null || cart.getCartItems().size()==0){
            throw new IOException(cartID+"");
        }
        update(cart);
        return cart;
    }
}
