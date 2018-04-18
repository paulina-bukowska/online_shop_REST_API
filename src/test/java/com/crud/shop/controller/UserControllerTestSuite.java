package com.crud.shop.controller;

import com.crud.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void shouldConfirmDeliverance() throws Exception {
        //Given
        Integer orderId = 9;
        Integer buyerId = 3;
        Integer sellerId = 28;

        when(userService.confirmDeliverance(orderId, buyerId, sellerId)).thenReturn(true);

        //When & Then
        mockMvc.perform(put("/v1/users").contentType(MediaType.APPLICATION_JSON).param("orderId", "9").param("buyerId", "3").param("sellerId", "28"))
                .andExpect(status().isOk());
    }
}