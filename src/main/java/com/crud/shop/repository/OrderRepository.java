package com.crud.shop.repository;

import com.crud.shop.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Override
    Order save(Order order);

    @Override
    Order findOne(Integer orderId);
}
