package com.emusicstore.controller;


import com.emusicstore.DAO.ProductDAO;
import com.emusicstore.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by 泽宏 on 2016/8/15.
 */

@Controller
public class HomeController {


    private ProductDAO productDAO = new ProductDAO();

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productDAO.getProductList();
        model.addAttribute("products",products);
        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productID}")
    public String viewProduct(@PathVariable String productID, Model model) throws IOException{

        Product product = productDAO.getProductByID(productID);
        model.addAttribute(product);

        return "viewProduct";
    }
}
