package com.casestudy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    private Double minimumCartAmount;
    private Double discountValue;
    private DiscountType discountType;
}
