package com.emusicstore.Service;

import com.emusicstore.model.Customer;

import java.util.List;

/**
 * Created by 泽宏 on 2016/8/25.
 */
public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerByID(int customerID);

    List<Customer> getAllCustomers();

}
