package com.casestudy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Category {
    private String title;
    private Category parentCategory;
}
