package com.crud.shop.domain;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name = "SHOPPING_CART")
public class Cart {
    private Integer id;
    private List<Product> products = new ArrayList<>();
//    private User user;

    @Id
    @GeneratedValue
    @Column(name = "CART_ID", nullable = false, unique = true)
    public Integer getId() {
        return id;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    public List<Product> getProducts() {
        return products;
    }

//    @Transient
//    public User getUser() {
//        return user;
//    }

    public void setProducts(Product product) {
        products.add(product);
    }
}