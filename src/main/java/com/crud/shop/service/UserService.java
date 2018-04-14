package com.crud.shop.service;

import com.crud.shop.domain.User;
import com.crud.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Integer userId) {
        return userRepository.findOne(userId);
    }

    public Boolean confirmDeliverance(Integer buyerId, Integer sellerId) {
        String buyerEmail = getUser(buyerId).getEmail();
        String buyerName = getUser(sellerId).toString();
        String sellerEmail = getUser(sellerId).getEmail();
        String sellerName = getUser(sellerId).toString();

        System.out.println("Sending confirmation from " + buyerName + " " + buyerEmail + " to " + sellerName + " " + sellerEmail);
        return true;
    }
}
