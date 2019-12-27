package com.casestudy;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Product {
    private String title;
    private Double price;
    private Category category;
}
