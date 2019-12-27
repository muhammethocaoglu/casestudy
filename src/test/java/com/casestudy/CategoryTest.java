package com.casestudy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CategoryTest {

    @Test
    public void should_create_category_without_parent_category() {
        //given
        String categoryTitle = "anyTitle";

        //when
        Category category = new Category(categoryTitle, null);

        //then
        assertEquals(categoryTitle, category.getTitle());
        assertNull(category.getParentCategory());
    }
}
