package com.crud.shop.service;

import com.crud.shop.domain.Product;
import com.crud.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(String name) {
        return productRepository.findByName(name);
    }
}
