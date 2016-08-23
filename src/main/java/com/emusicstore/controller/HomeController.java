package com.emusicstore.controller;


import com.emusicstore.DAO.ProductDAO;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by 泽宏 on 2016/8/15.
 */

@Controller
public class HomeController {

    @Autowired
    private ProductDAO productDAO;


    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProductsSession(HttpServletRequest request){
        return "redirect:/productList/"+request.getSession(true).getId();
    }

    @RequestMapping("/productList/{cartID}")
    public String getProducts(@PathVariable(value = "cartID") String cartID, Model model){
        model.addAttribute("cartID",cartID);
        List<Product> products = productDAO.getAllProduct();
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
