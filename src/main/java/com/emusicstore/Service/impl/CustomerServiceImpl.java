package com.emusicstore.Service.impl;

import com.emusicstore.DAO.CustomerDAO;
import com.emusicstore.Service.CustomerService;
import com.emusicstore.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 泽宏 on 2016/8/25.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    public Customer getCustomerByID(int customerID) {
        return customerDAO.getCustomerByID(customerID);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }
}
