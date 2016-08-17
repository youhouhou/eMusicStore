package com.emusicstore.DAO;

import com.emusicstore.model.Product;

import java.util.List;

/**
 * Created by 泽宏 on 2016/8/16.
 */
public interface ProductDAO {

    void addProduct(Product product);

    Product getProductByID(String id);

    List<Product> getAllProduct();

    void deleteProduct(String id);


}
