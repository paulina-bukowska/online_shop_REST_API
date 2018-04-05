package com.crud.shop.controller;

import com.crud.shop.domain.Payment;
import com.crud.shop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping(method = RequestMethod.POST, value = "", consumes = APPLICATION_JSON_VALUE)
    public Integer createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }
}