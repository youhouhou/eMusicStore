package com.emusicstore.DAO;

import com.emusicstore.model.Cart;

/**
 * Created by 泽宏 on 2016/8/22.
 */
public interface CartDAO {

    Cart create(Cart cart);

    Cart read(String cartID);

    void update(String cartID,Cart cart);

    void delete (String cartID);

}
