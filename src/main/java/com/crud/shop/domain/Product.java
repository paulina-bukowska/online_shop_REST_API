package com.crud.shop.domain;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name = "PRODUCTS")
public class Product {
    private Integer id;
    private String name;
    private List<Cart> carts = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID", nullable = false, unique = true)
    public Integer getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_PRODUCT_CART",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")}
    )
    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Cart cart) {
        carts.add(cart);
    }
}