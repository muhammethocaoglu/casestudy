package com.casestudy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CouponTest {

    @Test
    public void shouldCreateCoupon() {
        //given
        Double minimumCartAmount = 100.0;
        Double discountValue = 10.0;
        DiscountType discountType = DiscountType.Rate;

        //when
        Coupon coupon = new Coupon(minimumCartAmount, discountValue, discountType);

        //then
        assertEquals(minimumCartAmount, coupon.getMinimumCartAmount());
        assertEquals(discountValue, coupon.getDiscountValue());
        assertEquals(discountType, coupon.getDiscountType());
    }
}
