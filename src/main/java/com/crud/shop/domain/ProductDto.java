package com.crud.shop.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductDto {
    private Integer id;
    private String name;
    private List<Cart> carts = new ArrayList<>();
}
