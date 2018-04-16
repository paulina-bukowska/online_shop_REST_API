package com.crud.shop.domain;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name = "PAYMENTS")
public class Payment {
    private Integer id;
    private Boolean isPaid;
    private Boolean confirmation;
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

    @Column(name = "CONFIRMATION")
    public Boolean getConfirmation() {
        return confirmation;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}
