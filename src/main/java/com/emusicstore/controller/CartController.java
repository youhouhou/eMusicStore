package com.emusicstore.controller;

import com.emusicstore.Service.CustomerService;
import com.emusicstore.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 泽宏 on 2016/8/25.
 */

@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    CustomerService customerService;


    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
       int cardID = customer.getCart().getCartID();

        return "redirect:/customer/cart/"+cardID;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable("cartId") int cartId, Model model){
        model.addAttribute("cartId",cartId);
        return "cart";
    }

}
