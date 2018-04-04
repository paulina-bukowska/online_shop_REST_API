package com.crud.shop.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PaymentDto {
    private Integer id;
    private Boolean isPaid;
    private Cart cart;
}
