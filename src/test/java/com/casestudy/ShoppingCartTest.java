package com.casestudy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    private static final String PRODUCT_TITLE_APPLE = "Apple";
    private static final String PRODUCT_TITLE_ALMONDS = "Almonds";

    @Test
    public void shouldAddItemsToShoppingCart() {
        //given
        ShoppingCart shoppingCart = new ShoppingCart();
        Category food = Category.builder().title("food").build();
        Product apple = new Product(PRODUCT_TITLE_APPLE, 100.0, food);
        Product almond = new Product(PRODUCT_TITLE_ALMONDS, 150.0, food);

        //when
        shoppingCart.addItem(apple, 3);
        shoppingCart.addItem(almond, 1);

        //then
        assertEquals(shoppingCart.getProductQuantityMap().keySet().size(), 2);
        assertEquals(shoppingCart.getProductQuantityMap().get(apple).intValue(), 3);
        assertEquals(shoppingCart.getProductQuantityMap().get(almond).intValue(), 1);
    }

    @Test
    public void shouldApplyDiscountsToShoppingCart() {
        //given
        ShoppingCart shoppingCart = new ShoppingCart();
        Category food = Category.builder().title("food").build();
        Product apple = new Product(PRODUCT_TITLE_APPLE, 100.0, food);
        Product almond = new Product(PRODUCT_TITLE_ALMONDS, 150.0, food);
        shoppingCart.addItem(apple, 3);
        shoppingCart.addItem(almond, 4);

        Campaign discount1 = new Campaign(food, 20.0, 3, DiscountType.Rate);
        Campaign discount2 = new Campaign(food, 50.0, 5, DiscountType.Rate);
        Campaign discount3 = new Campaign(food, 5.0, 5, DiscountType.Amount);

        //when
        shoppingCart.applyDiscounts(discount1, discount2, discount3);

        //then
        assertEquals(450.0, shoppingCart.getCampaignDiscount(), 0.001);
    }

    @Test
    public void shouldApplyCouponToShoppingCart() {
        //given
        ShoppingCart shoppingCart = new ShoppingCart();
        Category food = Category.builder().title("food").build();
        Product apple = new Product(PRODUCT_TITLE_APPLE, 100.0, food);
        Product almond = new Product(PRODUCT_TITLE_ALMONDS, 150.0, food);
        shoppingCart.addItem(apple, 3);
        shoppingCart.addItem(almond, 4);
        Coupon coupon = new Coupon(100.0, 10.0, DiscountType.Rate);

        //when
        shoppingCart.applyCoupon(coupon);

        //then
        assertEquals(90.0, shoppingCart.getCouponDiscount(), 0.001);
    }

    @Test
    public void shouldPrintCart() {
        //given
        ShoppingCart shoppingCart = new ShoppingCart();

        Category food = Category.builder().title("food").build();
        Product apple = new Product(PRODUCT_TITLE_APPLE, 100.0, food);
        Product almond = new Product(PRODUCT_TITLE_ALMONDS, 150.0, food);

        Category electronics = Category.builder().title("electronics").build();
        Product tv = new Product("tv", 3000.0, electronics);

        shoppingCart.addItem(apple, 3);
        shoppingCart.addItem(almond, 4);
        shoppingCart.addItem(tv, 3);

        Campaign discount1 = new Campaign(food, 20.0, 3, DiscountType.Rate);
        Campaign discount2 = new Campaign(food, 50.0, 5, DiscountType.Rate);
        Campaign discount3 = new Campaign(electronics, 1000.0, 2, DiscountType.Amount);

        shoppingCart.applyDiscounts(discount1, discount2, discount3);

        Coupon coupon = new Coupon(100.0, 10.0, DiscountType.Rate);
        shoppingCart.applyCoupon(coupon);

        //when
        //then
        shoppingCart.print();

    }
}
