package com.crud.shop.service;

import com.crud.shop.domain.User;
import com.crud.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Integer integer) {
        return userRepository.findOne(integer);
    }
}
