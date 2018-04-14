package com.crud.shop.service;

import com.crud.shop.domain.Payment;
import com.crud.shop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    public Payment createPayment(Payment payment, Integer cartId) {
        payment.setCart(cartService.getCart(cartId));
        return paymentRepository.save(payment);
    }

    public Payment getPayment(Integer paymentId) {
        return paymentRepository.findOne(paymentId);
    }

    public Boolean confirmPayment(Integer paymentId, Integer buyerId, Integer sellerId) {
        Boolean confirmation = false;
        if (cartService.payForCart(getPayment(paymentId).getCart().getId(), paymentId)) {
            String buyerEmail = userService.getUser(buyerId).getEmail();
            String buyerName = userService.getUser(sellerId).toString();
            String sellerEmail = userService.getUser(sellerId).getEmail();
            String sellerName = userService.getUser(sellerId).toString();

            System.out.println("Sending confirmation from " + sellerName + " " + sellerEmail + " to " + buyerName + " " + buyerEmail);
            confirmation = true;
        }
        return confirmation;
    }
}