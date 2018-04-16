package com.crud.shop.repository;

import com.crud.shop.domain.Cart;
import com.crud.shop.domain.CartDto;
import com.crud.shop.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
    @Override
    Cart save(Cart cart);

    @Override
    void delete(Integer cartId);

    @Override
    Cart findOne(Integer cartId);
}
