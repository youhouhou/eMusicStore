package com.emusicstore.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 泽宏 on 2016/8/22.
 */
@Controller
@RequestMapping("/cart") //class level mapping
public class CartItemController {

    @RequestMapping
    public String get(HttpServletRequest request){
        return "redirect:/cart/" + request.getSession(true).getId();
    }

    @RequestMapping(value = "/{cartID}" , method = RequestMethod.GET)
    public String getCart(@PathVariable (value = "cartID") String cartID, Model model){
        model.addAttribute("cartID",cartID);
        return "cart";
    }

}
