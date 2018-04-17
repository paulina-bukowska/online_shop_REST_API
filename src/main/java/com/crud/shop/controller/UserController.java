package com.crud.shop.controller;

import com.crud.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE)
    public Boolean confirmDeliverance(@RequestParam Integer orderId, @RequestParam Integer buyerId, @RequestParam Integer sellerId) {
        return userService.confirmDeliverance(orderId, buyerId, sellerId);
    }
}