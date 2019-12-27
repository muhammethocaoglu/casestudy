package com.casestudy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coupon {
    private Double minimumCartAmount;
    private Double discountValue;
    private DiscountType discountType;
}
