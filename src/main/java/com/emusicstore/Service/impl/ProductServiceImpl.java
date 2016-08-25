package com.emusicstore.Service.impl;

import com.emusicstore.DAO.ProductDAO;
import com.emusicstore.Service.ProductService;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 泽宏 on 2016/8/24.
 */
@Component
public class ProductServiceImpl  implements ProductService{

    @Autowired
    private ProductDAO productDAO;

    public Product getProductByID(int productID){
        return productDAO.getProductByID(productID);
    }


    public List<Product> getProductList() {
        return productDAO.getProductList();
    }



    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    public void editProduct(Product product) {
        productDAO.editProduct(product);
    }

    public void deleteProduct(Product product) {
        productDAO.deleteProduct(product);
    }
}
