package com.casestudy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Campaign {
    private Category category;
    private Double discountValue;
    private Integer thresholdItemCountInCategory;
    private DiscountType discountType;
}
