package com.crud.shop.controller;

import com.crud.shop.domain.Cart;
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
        Cart cart = new Cart(buyerId, new ArrayList<>());

        when(cartService.createCart(buyerId)).thenReturn(cart);

        //When & Then
        mockMvc.perform(post("/v1/carts/users").contentType(MediaType.APPLICATION_JSON).param("buyerId", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.products", hasSize(0)));
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

        when(cartService.payForCart(cartId, buyerId)).thenReturn(true);

        //When & Then
        mockMvc.perform(put("/v1/carts/users").contentType(MediaType.APPLICATION_JSON).param("cartId", "12").param("buyerId", "3"))
                .andExpect(status().isOk());
    }
}