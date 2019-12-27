package com.casestudy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    @Test
    public void should_create_product() {
        //given
        String categoryTitle = "food";
        Category productCategory = new Category(categoryTitle, null);
        String productTitle = "Apple";
        Double productPrice = 100.0;

        //when
        Product product = new Product(productTitle, productPrice, productCategory);

        //then
        assertEquals(productTitle, product.getTitle());
        assertEquals(productPrice, product.getPrice());
        assertEquals(productCategory, product.getCategory());
    }
}
