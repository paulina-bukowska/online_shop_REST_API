package com.crud.shop.service;

import com.crud.shop.domain.Payment;
import com.crud.shop.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    public Payment createPayment(Integer cartId) {
        Payment payment = new Payment();
        payment.setCart(cartService.getCart(cartId));
        return paymentRepository.save(payment);
    }

    public Payment getPayment(Integer paymentId) {
        return paymentRepository.findOne(paymentId);
    }

    public Boolean confirmPayment(Integer paymentId, Integer buyerId, Integer sellerId) {
        Boolean confirmation = false;
        if (cartService.payForCart(getPayment(paymentId).getCart().getId(), buyerId)) {
            String buyerEmail = userService.getUser(buyerId).getEmail();
            String buyerName = userService.getUser(sellerId).toString();
            String sellerEmail = userService.getUser(sellerId).getEmail();
            String sellerName = userService.getUser(sellerId).toString();

            LOGGER.info("Sending confirmation (payment no. " + paymentId + ") from " + sellerName + " " + sellerEmail + " to " + buyerName + " " + buyerEmail);
            getPayment(paymentId).setConfirmation(true);
            confirmation = true;
        }
        return confirmation;
    }
}