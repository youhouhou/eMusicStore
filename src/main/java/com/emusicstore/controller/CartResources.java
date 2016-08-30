package com.emusicstore.controller;

import com.emusicstore.Service.CartItemService;
import com.emusicstore.Service.CartService;
import com.emusicstore.Service.CustomerService;
import com.emusicstore.Service.ProductService;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 泽宏 on 2016/8/25.
 */

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/{cartID}")
    public @ResponseBody //convert the Cart object in Json format(need Jackson dependency)
    Cart getCartByID(@PathVariable(value = "cartID") int cartID){
        return cartService.getCartByID(cartID);
    }

    @RequestMapping(value = "/add/{productID}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productID")int productID, @AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductByID(productID);
        List<CartItem> cartItemList = cart.getCartItems();

        for(int i=0;i<cartItemList.size();i++){
            if(product.getProductID() == cartItemList.get(i).getProduct().getProductID()){
                CartItem cartItem = cartItemList.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
                return;
            }
        }

            CartItem cartItem = new CartItem(product);
            cartItemList.add(cartItem);
            cartItem.setCart(cart);
            cartItemService.addCartItem(cartItem);


    }

    @RequestMapping(value = "/remove/{productId}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productId") int productId){
        CartItem cartItem = cartItemService.getCartItemByProductID(productId);
        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/{cartID}",method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable int cartID){
        Cart cart = cartService.getCartByID(cartID);
        cartItemService.removeAllCartItems(cart);
    }

    //exception handeller

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify you method")
    public void handeleClientError(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Internal server error")
    public void handeleServerError(Exception e){}



}
