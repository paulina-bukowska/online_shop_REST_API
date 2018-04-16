package com.crud.shop.service;

import com.crud.shop.domain.Order;
import com.crud.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    public Order createOrder(Integer userId) {
        Order order = new Order();
        order.setUser(userService.getUser(userId));
        userService.getUser(userId).setOrders(order);
        return orderRepository.save(order);
    }

    public Order getOrder(Integer orderId) {
        return orderRepository.findOne(orderId);
    }
}