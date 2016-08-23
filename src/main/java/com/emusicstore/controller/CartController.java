package com.emusicstore.controller;

import com.emusicstore.DAO.CartDAO;
import com.emusicstore.DAO.ProductDAO;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Product;
import com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 泽宏 on 2016/8/22.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/{cartID}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable("carID") String cartID){ //return a object in a formate of jason
        return cartDAO.read(cartID);
    }

    @RequestMapping(value = "/{cartID}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void  update(@PathVariable(value = "cartID") String cartID, @RequestBody Cart cart){
        cartDAO.update(cartID, cart);
    }

    @RequestMapping(value = "/{cartID}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartID") String cartID){
        cartDAO.delete(cartID);
    }

    @RequestMapping(value = "/add/{productID}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItemn(@PathVariable(value = "productID")String productID, HttpServletRequest request){
        String sessionID = request.getSession(true).getId();
        Cart cart = cartDAO.read(sessionID);

        if(cart == null){
            cart = cartDAO.create(new Cart(sessionID));
        }

        Product product = productDAO.getProductByID(productID);
        if(product == null){
            throw  new IllegalArgumentException(new Exception());
        }
        cart.addCartItem(new CartItem(product));

        cartDAO.update(sessionID,cart);
    }

    @RequestMapping(value = "/remove/{productID}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable String productID, HttpServletRequest request){
        String sessionID = request.getSession(true).getId();
        Cart cart = cartDAO.read(sessionID);

        if(cart == null){
            cart = cartDAO.create(new Cart(sessionID));
        }

        Product product = productDAO.getProductByID(productID);
        if(product == null){
            throw  new IllegalArgumentException(new Exception());
        }
        cart.removeCartItem(new CartItem(product));

        cartDAO.delete(productID);
    }

    @ExceptionHandler(IllegalAnnotationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Illegal request, please verify your payload")
    public void handleClientError(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal ServerError ")
    public void handleServerError(Exception e){}


}
