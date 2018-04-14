package com.crud.shop.repository;

import com.crud.shop.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    @Override
    Payment save(Payment payment);

    @Override
    Payment findOne(Integer paymentId);
}