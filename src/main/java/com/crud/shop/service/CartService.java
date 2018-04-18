package com.crud.shop.service;

import com.crud.shop.domain.Cart;
import com.crud.shop.domain.CartDto;
import com.crud.shop.domain.Payment;
import com.crud.shop.domain.Product;
import com.crud.shop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderService orderService;

    public Cart createCart(Integer buyerId) {
        Cart cart = new Cart();
        userService.getUser(buyerId).setCarts(cart);
        cart.setUser(userService.getUser(buyerId));
        return cartRepository.save(cart);
    }

    public void deleteCart(Integer cartId) {
        cartRepository.delete(cartId);
    }

    public Cart getCart(Integer cartId) {
        return cartRepository.findOne(cartId);
    }

    public List<Product> getProductsByCartId(Integer cartId) {
        return cartRepository.findOne(cartId).getProducts();
    }

    public void addProductToCart(Integer productId, Integer cartId) {
        getCart(cartId).setProducts(productService.getProduct(productId));
        productService.getProduct(productId).setCarts(getCart(cartId));
    }

    public void deleteProductFromCart(Integer productId, Integer cartId) {
        getCart(cartId).getProducts().remove(productId);
    }

    public Boolean payForCart(Integer cartId) {
        Payment payment = paymentService.createPayment(cartId);
        payment.setPaid(true);
        orderService.createOrder(getCart(cartId).getUser().getId());
        deleteCart(cartId);
        return true;
    }
}