package com.emusicstore.DAO.impl;

import com.emusicstore.DAO.CustomerOrderDAO;
import com.emusicstore.model.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 泽宏 on 2016/8/27.
 */

@Repository
@Transactional
public class CustomerOrderDAOImpl implements CustomerOrderDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }


}
