package com.emusicstore.DAO;

import com.emusicstore.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 泽宏 on 2016/8/15.
 */
public class ProductDAO {

    private List<Product> productList;

    public List<Product> getProductList(){
        Product product1 = new Product();

        product1.setProductID("1");
        product1.setProductName("Guitar");
        product1.setProductCategory("Instrument");
        product1.setProductDescription("this is guitar");
        product1.setProductPrice(1200);
        product1.setProductCondition("new");
        product1.setProductCondition("active");
        product1.setUnitInStock(11);
        product1.setProductManufacturer("fender");

        Product product2 = new Product();
        product2.setProductID("2");
        product2.setProductName("Recordl");
        product2.setProductCategory("Record");
        product2.setProductDescription("this is a hahahaha");
        product2.setProductPrice(25);
        product2.setProductCondition("new");
        product2.setProductCondition("active");
        product2.setUnitInStock(110);
        product2.setProductManufacturer("EMI");

        Product product3 = new Product();
        product3.setProductID("3");
        product3.setProductName("Drum");
        product3.setProductCategory("Instrument");
        product3.setProductDescription("I like drum!");
        product3.setProductPrice(12000);
        product3.setProductCondition("new");
        product3.setProductCondition("active");
        product3.setUnitInStock(11);
        product3.setProductManufacturer("Perl");

        productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        return productList;
    }

    public Product getProductByID(String productID) throws IOException{
        for(Product product : getProductList()){
            if(product.getProductID().equals(productID)){
                return product;
            }
        }
        throw new IOException("No Such Product");
    }

}
