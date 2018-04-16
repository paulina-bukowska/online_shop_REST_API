package com.crud.shop.controller;

import com.crud.shop.domain.Cart;
import com.crud.shop.domain.Payment;
import com.crud.shop.service.CartService;
import com.crud.shop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = APPLICATION_JSON_VALUE)
    public Cart createCart(@RequestParam Integer buyerId) {
        return cartService.createCart(buyerId);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCart(@RequestParam Integer cartId) {
        cartService.deleteCart(cartId);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE)
    public Boolean payForCart(@RequestParam Integer cartId) {
        return cartService.payForCart(cartId);
    }
}