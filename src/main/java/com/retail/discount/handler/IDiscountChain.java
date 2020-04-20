package com.retail.discount.handler;

/**
 * Discount chain to calculate discounts based on strategy
 *
 * @author pavaghade
 * @since 19 Apr 2020
 */
public interface IDiscountChain {

    /**
     * Get the Discount amount on the totalPrice
     *
     * @param totalPrice
     * @return double - discount amount
     */
    double getDiscount(double totalPrice);
}
