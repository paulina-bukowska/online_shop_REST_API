package com.crud.shop.controller;

import com.crud.shop.domain.Product;
import com.crud.shop.service.CartService;
import com.crud.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Product> getAvailableProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/carts")
    public List<Product> getProductsFromCart(@RequestParam Integer cartId) {
        return cartService.getProductsByCartId(cartId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/carts")
    public void addProductToCart(@RequestParam Integer productId, @RequestParam Integer cartId) {
        cartService.getCart(cartId).setProducts(productService.getProduct(productId));
    }
}