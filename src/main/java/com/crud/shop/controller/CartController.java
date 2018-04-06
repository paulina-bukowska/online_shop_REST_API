package com.crud.shop.controller;

import com.crud.shop.domain.Cart;
import com.crud.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = APPLICATION_JSON_VALUE)
    public Integer createCart(@RequestBody Cart cart, @RequestParam Integer userId) {
        return cartService.createCart(cart, userId);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCart(@RequestParam Integer cartId) {
        cartService.deleteCart(cartId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/payments")
    public Boolean payForCart(@RequestParam Integer cartId, @RequestParam Integer paymentId) {
        return cartService.payForCart(paymentId, cartId);
    }
}