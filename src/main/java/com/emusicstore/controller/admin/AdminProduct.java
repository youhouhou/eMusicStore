package com.emusicstore.controller.admin;

import com.emusicstore.Service.ProductService;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by 泽宏 on 2016/8/24.
 */

@Controller
@RequestMapping("/admin")
public class AdminProduct {
    private Path path;

    @Autowired
    ProductService productService;

    @RequestMapping("/product/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");

        model.addAttribute("product",product);

        return "addProduct";
    }

    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request){
        if(result.hasErrors()){
            return "addProduct";
        }
        productService.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory+"\\resources\\images\\"+product.getProductID()+".png");

        if(productImage != null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed",e);
            }
        }
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable(value = "id")int id,Model model){
        Product product = productService.getProductByID(id);
        model.addAttribute(product);
        return "editProduct";
    }

    @RequestMapping(value = "/product/editProduct",method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product")Product product,BindingResult result,
                                  HttpServletRequest request){
        if(result.hasErrors()){
            return "editProduct";
        }


        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory+"\\resources\\images\\"+product.getProductID()+".png");
        if(productImage != null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Fail to save the image", e);
            }
        }
        productService.editProduct(product);
        return  "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id,HttpServletRequest request){
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory+"\\resources\\images\\"+id+".png");

        if(Files.exists(path)){
            try{
                Files.delete(path);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        Product product = productService.getProductByID(id);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }

}
