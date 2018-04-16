package com.crud.shop.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name = "ORDERS")
public class Order {
    private Integer id;
    private User user;
    private Boolean confirmation;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @Column(name = "CONFIRMATION")
    public Boolean getConfirmation() {
        return confirmation;
    }
}