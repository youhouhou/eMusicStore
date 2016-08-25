package com.emusicstore.controller;

import com.emusicstore.Service.ProductService;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by 泽宏 on 2016/8/24.
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String getProductList(Model model){
        List<Product> productList = productService.getProductList();
        model.addAttribute("products",productList);

        return "productList";
    }

    @RequestMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable("id") int id,Model model) throws IOException {
        Product product = productService.getProductByID(id);
        model.addAttribute(product);
        return "viewProduct";
    }
}
