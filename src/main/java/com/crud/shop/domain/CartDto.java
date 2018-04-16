package com.crud.shop.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartDto {
    private Integer id;
    private User user;
    List<Product> products = new ArrayList<>();
}
