package com.casestudy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeliveryCostCalculatorTest {

    private static final String PRODUCT_TITLE_APPLE = "Apple";
    private static final String PRODUCT_TITLE_ALMONDS = "Almonds";

    @Test
    public void should_calculateDeliveryCost() {
        //given
        Double costPerDelivery = 4.99;
        Double costPerProduct = 3.99;
        Double fixedCost = 2.99;
        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator(costPerDelivery, costPerProduct,
                fixedCost);
        ShoppingCart shoppingCart = new ShoppingCart();

        Category food = Category.builder().title("food").build();
        Product apple = new Product(PRODUCT_TITLE_APPLE, 100.0, food);
        Product almond = new Product(PRODUCT_TITLE_ALMONDS, 150.0, food);

        Category electronics = Category.builder().title("electronics").build();
        Product tv = new Product("tv", 3000.0, electronics);

        shoppingCart.addItem(apple, 3);
        shoppingCart.addItem(almond, 4);
        shoppingCart.addItem(tv, 1);

        //when
        Double deliveryCost = deliveryCostCalculator.calculateFor(shoppingCart);

        //then
        assertEquals(24.94, deliveryCost, 0.001);
    }
}
