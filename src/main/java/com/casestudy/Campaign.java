package com.casestudy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {
    private Category category;
    private Double discountValue;
    private Integer thresholdItemCountInCategory;
    private DiscountType discountType;
}
