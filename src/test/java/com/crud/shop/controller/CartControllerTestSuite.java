package com.crud.shop.controller;

import com.crud.shop.domain.Cart;
import com.crud.shop.domain.User;
import com.crud.shop.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
public class CartControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @Test
    public void shouldFetchCart() throws Exception {
        //Given
        Integer buyerId = 3;
        User user = new User(3, "Veronica", "Smith", "Ivry", "ver@test.com", new ArrayList<>(), new ArrayList<>());
        Cart cart = new Cart(15, user, new ArrayList<>());

        when(cartService.createCart(buyerId)).thenReturn(cart);

        //When & Then
        mockMvc.perform(post("/v1/carts/users").contentType(MediaType.APPLICATION_JSON).param("buyerId", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(15)))
                .andExpect(jsonPath("$.products", hasSize(0)))
                .andExpect(jsonPath("$.user.id", is(3)))
                .andExpect(jsonPath("$.user.firstname", is("Veronica")))
                .andExpect(jsonPath("$.user.lastname", is("Smith")))
                .andExpect(jsonPath("$.user.location", is("Ivry")))
                .andExpect(jsonPath("$.user.email", is("ver@test.com")))
//                .andExpect(jsonPath("$.user.carts", hasSize(1)))
                .andExpect(jsonPath("$.user.orders", hasSize(0)));

    }

    @Test
    public void shouldDeleteCart() throws Exception {
        //Given

        //When & Then
        mockMvc.perform(delete("/v1/carts").contentType(MediaType.APPLICATION_JSON).param("cartId", "12"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldPayForCart() throws Exception {
        //Given
        Integer cartId = 12;
        Integer buyerId = 3;

        when(cartService.payForCart(cartId)).thenReturn(true);

        //When & Then
        mockMvc.perform(put("/v1/carts/users").contentType(MediaType.APPLICATION_JSON).param("cartId", "12").param("buyerId", "3"))
                .andExpect(status().isOk());
    }
}