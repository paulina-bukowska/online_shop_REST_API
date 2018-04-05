package com.crud.shop.repository;

import com.crud.shop.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findById(Integer productId);

    @Override
    List<Product> findAll();
}
