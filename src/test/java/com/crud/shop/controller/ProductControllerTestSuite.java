package com.crud.shop.controller;

import com.crud.shop.domain.Product;
import com.crud.shop.service.CartService;
import com.crud.shop.service.ProductService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private CartService cartService;

    @Test
    public void shouldFetchAllProducts() throws Exception {
        //Given
        List<Product> products = new ArrayList<>();
        products.add(new Product(19, "armchair", new ArrayList<>()));
        products.add(new Product(23, "kitchen table", new ArrayList<>()));

        when(productService.getAvailableProducts()).thenReturn(products);

        //When & Then
        mockMvc.perform(get("/v1/products").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(19)))
                .andExpect(jsonPath("$[0].name", is("armchair")))
                .andExpect(jsonPath("$[0].carts", hasSize(0)))
                .andExpect(jsonPath("$[1].id", is(23)))
                .andExpect(jsonPath("$[1].name", is("kitchen table")))
                .andExpect(jsonPath("$[1].carts", hasSize(0)));
    }

    @Test
    public void shouldFetchProductsList() throws Exception {
        //Given
        Integer cartId = 12;
        List<Product> products = new ArrayList<>();
        products.add(new Product(19, "armchair", new ArrayList<>()));
        products.add(new Product(23, "kitchen table", new ArrayList<>()));

        when(cartService.getProductsByCartId(cartId)).thenReturn(products);

        //When & Then
        mockMvc.perform(get("/v1/products/carts").contentType(MediaType.APPLICATION_JSON).param("cartId", "12"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(19)))
                .andExpect(jsonPath("$[0].name", is("armchair")))
                .andExpect(jsonPath("$[0].carts", hasSize(0)))
                .andExpect(jsonPath("$[1].id", is(23)))
                .andExpect(jsonPath("$[1].name", is("kitchen table")))
                .andExpect(jsonPath("$[1].carts", hasSize(0)));
    }

    @Test
    public void shouldAddProductToCart() throws Exception {
        //Given

        //When & Then
        mockMvc.perform(put("/v1/products/carts").contentType(MediaType.APPLICATION_JSON).param("productId", "12").param("cartId", "3"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteCart() throws Exception {
        //Given

        //When & Then
        mockMvc.perform(delete("/v1/products/carts").contentType(MediaType.APPLICATION_JSON).param("productId", "12").param("cartId", "3"))
                .andExpect(status().isOk());
    }
}