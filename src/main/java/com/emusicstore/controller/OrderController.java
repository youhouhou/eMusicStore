package com.emusicstore.controller;

import com.emusicstore.Service.CartService;
import com.emusicstore.Service.CustomerOrderService;
import com.emusicstore.model.Cart;
import com.emusicstore.model.Customer;
import com.emusicstore.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 泽宏 on 2016/8/27.
 */
@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartID}")
    public String createOrder(@PathVariable(value = "cartID")int cartID){
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartByID(cartID);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerOrder);
        return "redirect:/checkout?cartID="+cartID;
    }
}
