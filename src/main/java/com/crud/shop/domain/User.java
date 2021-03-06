package com.crud.shop.domain;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@EqualsAndHashCode
@Table(name = "USERS")
public class User {
    private Integer id;
    private String firstname;
    private String lastname;
    private String location;
    private String email;
    private List<Cart> carts = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

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

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<Order> getOrders() {
        return orders;
    }

    @OneToMany(
            targetEntity = Cart.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<Cart> getCarts() {
        return carts;
    }

    public void setOrders(Order order) {
        orders.add(order);
    }

    public void setCarts(Cart cart) {
        carts.add(cart);
    }
}
