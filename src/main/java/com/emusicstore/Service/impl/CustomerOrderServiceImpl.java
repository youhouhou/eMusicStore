package com.emusicstore.Service.impl;

import com.emusicstore.DAO.CustomerOrderDAO;
import com.emusicstore.Service.CartService;
import com.emusicstore.Service.CustomerOrderService;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.CustomerOrder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 泽宏 on 2016/8/27.
 */

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDAO customerOrderDAO;


    @Autowired
    private CartService cartService;



    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDAO.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartID) {
        double grandTotal = 0;
        Cart cart = cartService.getCartByID(cartID);
        List<CartItem> cartItemList = cart.getCartItems();

        for(CartItem item : cartItemList){
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }
}
