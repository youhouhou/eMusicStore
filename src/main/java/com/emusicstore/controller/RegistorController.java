package com.emusicstore.controller;

import com.emusicstore.Service.CustomerService;
import com.emusicstore.model.Customer;
import com.emusicstore.model.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by 泽宏 on 2016/8/25.
 */

@Controller
public class RegistorController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String registerController(Model model){
        Customer customer = new Customer();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setShippingAddress(shippingAddress);
        model.addAttribute(customer);
        return "registerCustomer";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerPost(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,
                               Model model){

        customer.setEnabled(true);
        customerService.addCustomer(customer);
        return "registerCustomerSuccess";

    }
}
