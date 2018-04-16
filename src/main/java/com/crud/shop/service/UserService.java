package com.crud.shop.service;

import com.crud.shop.domain.User;
import com.crud.shop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderService orderService;

    public User getUser(Integer userId) {
        return userRepository.findOne(userId);
    }

    public Boolean confirmDeliverance(Integer orderId, Integer buyerId, Integer sellerId) {
        String buyerEmail = getUser(buyerId).getEmail();
        String buyerName = getUser(sellerId).toString();
        String sellerEmail = getUser(sellerId).getEmail();
        String sellerName = getUser(sellerId).toString();

        LOGGER.info("Sending confirmation (order no. " + orderId + ") from " + buyerName + " " + buyerEmail + " to " + sellerName + " " + sellerEmail);
        orderService.getOrder(orderId).setConfirmation(true);
        return true;
    }
}