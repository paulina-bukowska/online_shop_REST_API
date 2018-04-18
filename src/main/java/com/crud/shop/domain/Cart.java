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
    private User user;
    private List<Product> products = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "CART_ID", nullable = false, unique = true)
    public Integer getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        products.add(product);
    }
}