package com.crud.shop.service;

import com.crud.shop.domain.Cart;
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

    public Cart createCart(Cart cart, Integer buyerId) {
        userService.getUser(buyerId).setCart(cart);
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
    }

    public void deleteProductFromCart(Integer productId, Integer cartId) {
        getCart(cartId).getProducts().remove(productId);
    }

    public Boolean payForCart(Integer cartId, Integer paymentId) {
        Boolean isPaid = false;
        if(paymentService.getPayment(paymentId).getCart().getId() == cartId) {
            paymentService.getPayment(paymentId).setPaid(true);
            deleteCart(cartId);
            isPaid = true;
        }
        return isPaid;
    }
}