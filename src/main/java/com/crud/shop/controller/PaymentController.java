package com.crud.shop.controller;

import com.crud.shop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping(method = RequestMethod.PUT, value = "/users", consumes = APPLICATION_JSON_VALUE)
    public Boolean confirmPayment(@RequestParam Integer paymentId, @RequestParam Integer buyerId, @RequestParam Integer sellerId) {
        return paymentService.confirmPayment(paymentId, buyerId, sellerId);
    }
}