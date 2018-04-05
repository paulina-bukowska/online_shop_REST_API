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

    public Integer saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(Integer cartId) {
        cartRepository.deleteById(cartId);
    }

    public Cart getCart(Integer cartId) {
        return cartRepository.findOne(cartId);
    }

    public List<Product> getProductsByCartId(Integer cartId) {
        return cartRepository.findOne(cartId).getProducts();
    }
}
