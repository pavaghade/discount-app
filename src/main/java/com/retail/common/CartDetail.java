package com.retail.common;

/**
 * Holds the card details eg. total value, can be extended to hold specific items
 *
 * @author pavaghade
 * @since 19 Apr 2020
 */
public class CartDetail {

    double totalValue;

    public CartDetail() {
    }

    public CartDetail(double totalValue) {
        this.totalValue = totalValue;
    }
    // TODO : use lombok instead
    public double getTotalValue() {
        return totalValue;
    }
}
