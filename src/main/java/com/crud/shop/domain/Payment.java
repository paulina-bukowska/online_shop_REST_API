package com.crud.shop.domain;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENTS")
public class Payment {
    private Integer id;
    private Boolean isPaid;
    private Cart cart;

    @Id
    @GeneratedValue
    @Column(name = "PAYMENT_ID", nullable = false, unique = true)
    public Integer getId() {
        return id;
    }

    @Column(name = "IS_PAID")
    public Boolean getPaid() {
        return isPaid;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
