package com.retail.discount.service;

import com.retail.common.CustomerType;

import java.util.Set;

/**
 * Discount Service for Discount operations
 *
 * @author pavaghade
 * @since 19 Apr 2020
 */
public interface IDiscountService<T> {

    /**
     * set of discounts ranges based on customer type
     *
     * @param customerType
     * @return <code>Set<Discount></code> - returns discounts for specific customer type
     */
    Set<T> getDiscounts(CustomerType customerType);
}
