package com.casestudy;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Product {
    private String title;
    private Double price;
    private Category category;
}
