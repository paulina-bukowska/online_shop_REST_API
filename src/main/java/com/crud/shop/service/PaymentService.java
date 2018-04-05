package com.crud.shop.service;

import com.crud.shop.domain.Payment;
import com.crud.shop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public Integer savePayment(Payment payment) {
        payment.setPaid(true);
        return paymentRepository.save(payment);
    }
}
