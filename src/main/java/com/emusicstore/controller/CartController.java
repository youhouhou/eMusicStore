package com.emusicstore.controller;

import com.emusicstore.DAO.CartDAO;
import com.emusicstore.DAO.ProductDAO;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by YANG on 8/23/2016.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDAO cartDao;

    @Autowired
    private ProductDAO productDao;

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    // Gonna parse the Cart object in the http response body, in the JSON format
    public @ResponseBody
    Cart read (@PathVariable(value="cartId") String cartId) {
        return cartDao.read(cartId);
    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    // Not replying any content here
    // Take the body of the request, parse it and transfer into the Cart object
    public void update (@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
        cartDao.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete (@PathVariable(value="cartId") String cartId) {
        cartDao.delete(cartId);
    }

    @RequestMapping(value="/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable (value = "productId") String productId, HttpServletRequest req) {
        String sessionId = req.getSession(true).getId();
        Cart cart = cartDao.read(sessionId);

        if (null == cart) {
            // Means the cart does not exist
            cart = cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductByID(productId);

        if (null == product) {
            // Means the product does not exist in the product list
            throw new IllegalArgumentException(new Exception());
        }

        cart.addCartItem(new CartItem(product));

        cartDao.update(sessionId, cart);
    }

    @RequestMapping(value="/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value="productId") String productId, HttpServletRequest req) {
        String sessionId = req.getSession(true).getId();
        Cart cart = cartDao.read(sessionId);

        if (null == cart) {
            // Means the cart does not exist
            cart = cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductByID(productId);

        if (null == product) {
            // Means the product does not exist in the product list
            throw new IllegalArgumentException(new Exception());
        }
        cart.removeCartItem(new CartItem(product));
        cartDao.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception e) {}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception e) {}
}