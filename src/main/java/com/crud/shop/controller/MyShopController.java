package com.crud.shop.controller;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import com.crud.shop.domain.Cart;
import com.crud.shop.domain.Product;
import com.crud.shop.service.CartService;
import com.crud.shop.service.PaymentService;
import com.crud.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/myShop")
public class MyShopController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(method = RequestMethod.GET, value = "/getProducts")
    public List<Product> getAvailableProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getProductsFromCart")
    public List<Product> getProductsFromCart(@RequestParam Integer cartId) {
        return cartService.getproductsFromCart(cartId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/addProduct")
    public void addProductToCart(@RequestParam String name, @RequestParam Integer cartId) {
        Product chosenProduct = productService.getProduct(name);
        cartService.getCart(cartId).setProducts(chosenProduct);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody Cart cart) {
        cartService.saveCart(cart);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteCart")
    public void deleteCart(@RequestParam Integer cartId) {
        cartService.deleteCart(cartId);
    }
}