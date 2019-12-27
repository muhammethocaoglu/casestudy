package com.casestudy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CampaignTest {

    @Test
    public void should_create_campaign() {
        //given
        Category anyCategory = new Category("anyCategory", null);
        Double discountValue = 20.0;
        Integer minimumItemCountInCategory = 3;
        DiscountType discountType = DiscountType.Rate;

        //when
        Campaign createdCampaign = new Campaign(anyCategory, discountValue, minimumItemCountInCategory, discountType);

        //then
        assertEquals(anyCategory, createdCampaign.getCategory());
        assertEquals(discountValue, createdCampaign.getDiscountValue());
        assertEquals(minimumItemCountInCategory, createdCampaign.getThresholdItemCountInCategory());
        assertEquals(discountType, createdCampaign.getDiscountType());
    }
}
