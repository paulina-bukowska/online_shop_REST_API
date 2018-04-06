package com.crud.shop.domain;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {
    private Integer id;
    private String firstname;
    private String lastname;
    private String location;
    private Cart cart;

    @Id
    @GeneratedValue
    @Column(name = "USER_ID", nullable = false, unique = true)
    public Integer getId() {
        return id;
    }

    @Column(name = "FIRSTNAME")
    public String getFirstname() {
        return firstname;
    }

    @Column(name = "LASTNAME")
    public String getLastname() {
        return lastname;
    }

    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
