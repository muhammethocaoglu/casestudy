package com.casestudy;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    private HashMap<Category, List<Product>> categoryProductListMap = new HashMap<>();
    private HashMap<Product, Integer> productQuantityMap = new HashMap<>();
    private HashMap<Category, Integer> categoryItemCountMap = new HashMap<>();
    private HashMap<Category, Double> categoryAmountMap = new HashMap<>();
    private double campaignDiscount;
    private double couponDiscount;
    private double totalAmount;
    private double totalAmountAfterDiscounts;
    private double deliveryCost;

    public void addItem(Product product, int quantity) {
        productQuantityMap.put(product, quantity);
        Category category = product.getCategory();
        if (!categoryProductListMap.containsKey(category)) {
            categoryProductListMap.put(category, new ArrayList<>());
        }
        categoryProductListMap.get(category).add(product);

        Integer numberOfItemsInCategory;
        if (!categoryItemCountMap.containsKey(category)) {
            categoryItemCountMap.put(category, quantity);
        } else {
            numberOfItemsInCategory = categoryItemCountMap.get(category);
            categoryItemCountMap.put(category, numberOfItemsInCategory + quantity);
        }

        Double productAmount;
        Double addedAmount = quantity * product.getPrice();
        totalAmount = totalAmount + addedAmount;
        if (!categoryAmountMap.containsKey(category)) {
            categoryAmountMap.put(category, addedAmount);
        } else {
            productAmount = categoryAmountMap.get(category);
            categoryAmountMap.put(category, productAmount + addedAmount);
        }

    }

    public void applyDiscounts(Campaign... campaigns) {
        HashMap<Category, Double> categoryDiscountMap = new HashMap<>();
        Category category;
        Double discount;
        for (Campaign campaign : campaigns) {
            category = campaign.getCategory();
            if (categoryItemCountMap.get(category) > campaign.getThresholdItemCountInCategory()) {
                if (campaign.getDiscountType().equals(DiscountType.Amount)) {
                    discount = campaign.getDiscountValue();
                } else {
                    discount = categoryAmountMap.get(category) * campaign.getDiscountValue() / 100;
                }
                if (categoryDiscountMap.containsKey(category) && categoryDiscountMap.get(category) < discount) {
                    categoryDiscountMap.put(category, discount);
                } else if (!categoryDiscountMap.containsKey(category)) {
                    categoryDiscountMap.put(category, discount);
                }
            }
        }
        campaignDiscount = categoryDiscountMap.values().stream().reduce(Double::sum).orElse(0.0);
        Double calculatedTotalAmountAfterDiscounts = totalAmount - campaignDiscount;
        totalAmountAfterDiscounts = calculatedTotalAmountAfterDiscounts < 0.0 ? 0.0 : calculatedTotalAmountAfterDiscounts;
    }

    public void applyCoupon(Coupon coupon) {
        if (totalAmount > coupon.getMinimumCartAmount()) {
            couponDiscount = coupon.getDiscountType().equals(DiscountType.Rate) ?
                    totalAmount * coupon.getDiscountValue() / 100 : coupon.getDiscountValue();
        }
        Double calculatedTotalAmountAfterDiscounts = totalAmountAfterDiscounts - couponDiscount;
        totalAmountAfterDiscounts = calculatedTotalAmountAfterDiscounts < 0.0 ? 0.0 : calculatedTotalAmountAfterDiscounts;
    }

    public void print() {
        categoryProductListMap.keySet().forEach(category -> {
            categoryProductListMap.get(category).forEach(product -> {
                System.out.printf("Category name: %s, Product name: %s, Quantity: %d, Unit Price: %f %n",
                        category.getTitle(), product.getTitle(), productQuantityMap.get(product), product.getPrice());
            });
        });
        System.out.printf("Total price: %f %n", totalAmount);
        System.out.printf("Total discount: %f %n", campaignDiscount + couponDiscount);
    }
}
