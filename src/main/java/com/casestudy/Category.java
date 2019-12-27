package com.casestudy;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    private String title;
    private Category parentCategory;
}
