package com.retail.discount.handler;

import com.retail.discount.dao.Discount;

import java.util.TreeSet;

/**
 * Discount Chain to calculate discounts
 *
 * @author pavaghade
 * @since 19 Apr 2020
 * */
public class DiscountChain implements IDiscountChain {
    TreeSet<Discount> eligibleDiscounts;

    public DiscountChain(TreeSet<Discount> eligibleDiscounts) {
        this.eligibleDiscounts = eligibleDiscounts;
    }

    @Override
    public double getDiscount(double totalPrice) {
        double discountAmount = 0;

        Discount discount = eligibleDiscounts.first();
        double diffCalulator = totalPrice - discount.getFromAmount();
        discountAmount = (diffCalulator * discount.getDiscountPercent()) / 100;
        eligibleDiscounts.remove(discount);
        discountAmount = discountAmount + calulateFixedDiscountAmount(eligibleDiscounts);

        return discountAmount;
    }

    // This calculated based on the applicable slab this amount remains fixed
    // since the total amount exceeds the slab limit just calculate the discount and return
    private double calulateFixedDiscountAmount(TreeSet<Discount> discounts) {
        double discountAmount = 0;
        for (Discount discount : discounts) {
            double mulitplyFactor = discount.getDiscountPercent() / 100;
            double amountForPercentCalulation = discount.getUptoAmount() - discount.getFromAmount();
            double discountForSlab = mulitplyFactor * amountForPercentCalulation;
            discountAmount = discountAmount + discountForSlab;
        }
        return discountAmount;
    }
}
