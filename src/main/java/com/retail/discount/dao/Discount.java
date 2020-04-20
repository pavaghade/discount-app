package com.retail.discount.dao;

import com.retail.common.CustomerType;
import lombok.EqualsAndHashCode;

/**
 * Discount Entity to hold the range of discounts on customer type
 *
 * @author pavaghade
 * @since 19 Apr 2020
 */
@EqualsAndHashCode
public class Discount {
    // Low value of Discount range
    double fromAmount;
    // High value of Discount range
    double uptoAmount;
    // Percentage discount on the specified range
    double discountPercent;
    // Customer type for the specified discount range
    CustomerType customerType;

    public Discount() {
    }

    public Discount(double fromAmount, double uptoAmount, double discountPercent, CustomerType customerType) {
        this.fromAmount = fromAmount;
        this.uptoAmount = uptoAmount;
        this.discountPercent = discountPercent;
        this.customerType = customerType;
    }

    public double getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(double fromAmount) {
        this.fromAmount = fromAmount;
    }

    public double getUptoAmount() {
        return uptoAmount;
    }

    public void setUptoAmount(double uptoAmount) {
        this.uptoAmount = uptoAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
