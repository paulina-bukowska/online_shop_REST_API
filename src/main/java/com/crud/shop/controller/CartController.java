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

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = APPLICATION_JSON_VALUE)
    public Cart createCart(@RequestBody Cart cart, @RequestParam Integer buyerId) {
        return cartService.createCart(cart, buyerId);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCart(@RequestParam Integer cartId) {
        cartService.deleteCart(cartId);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE)
    public Boolean payForCart(@RequestParam Integer cartId, @RequestBody Payment payment) {
        return cartService.payForCart(cartId, paymentService.createPayment(payment, cartId).getId());
    }
}