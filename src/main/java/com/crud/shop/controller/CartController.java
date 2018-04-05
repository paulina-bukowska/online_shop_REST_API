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

    @RequestMapping(method = RequestMethod.POST, value = "", consumes = APPLICATION_JSON_VALUE)
    public Integer createCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "")
    public void deleteCart(@RequestParam Integer cartId) {
        cartService.deleteCart(cartId);
    }
}