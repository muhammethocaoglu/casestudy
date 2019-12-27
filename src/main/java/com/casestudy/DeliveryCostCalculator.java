package com.casestudy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeliveryCostCalculator {
    private Double costPerDelivery;
    private Double costPerProduct;
    private Double fixedCost;

    public Double calculateFor(ShoppingCart shoppingCart) {
        Double deliveryCost = costPerDelivery * shoppingCart.getCategoryAmountMap().keySet().size()
                + costPerProduct * shoppingCart.getProductQuantityMap().keySet().size() + fixedCost;
        shoppingCart.setDeliveryCost(deliveryCost);
        return deliveryCost;
    }
}
