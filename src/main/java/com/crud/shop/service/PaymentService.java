package com.crud.shop.service;

import com.crud.shop.domain.Payment;
import com.crud.shop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    public Integer createPayment(Payment payment, Integer cartId) {
        payment.setCart(cartService.getCart(cartId));
        return paymentRepository.save(payment);
    }

    public Payment getPayment(Integer paymentId) {
        return paymentRepository.findOne(paymentId);
    }
}