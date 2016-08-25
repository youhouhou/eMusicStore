package com.emusicstore.Service;

import com.emusicstore.model.Product;

import java.util.List;

/**
 * Created by 泽宏 on 2016/8/24.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProductByID(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product); 

}
