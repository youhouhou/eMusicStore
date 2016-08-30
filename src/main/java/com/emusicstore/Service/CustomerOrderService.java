package com.emusicstore.Service;

import com.emusicstore.model.CustomerOrder;

/**
 * Created by 泽宏 on 2016/8/27.
 */
public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartID);
}
