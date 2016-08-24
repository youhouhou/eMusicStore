package com.emusicstore.controller;

import com.emusicstore.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by YANG on 8/23/2016.
 */
@Controller
@RequestMapping("/cart")
public class CartItemController {

    @RequestMapping
    public String get (HttpServletRequest req) {

        // Use the session ID as the cart ID. Want to bind each session to a specific cart. The relationship is one to one.
        return "redirect:/cart/" + req.getSession(true).getId();
    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.GET)
    public String getCart (@PathVariable (value = "cartId") String cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }
}
