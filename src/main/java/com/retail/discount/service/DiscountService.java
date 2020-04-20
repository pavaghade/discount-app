package com.retail.discount.service;

import com.retail.common.CustomerType;
import com.retail.discount.dao.Discount;

import java.util.HashSet;
import java.util.Set;

/**
 * Discount Service for Discount operations
 *
 * @author pavaghade
 * @since 19 Apr 2020
 */
public class DiscountService implements IDiscountService<Discount> {

    Set<Discount> discounts = new HashSet<>();

    /**
     * Sorted set of discounts ranges based on customer type
     *
     * @param customerType
     * @return <code>Set<Discount></code> - retuns the discount slabs based on customer type
     */
    @Override
    public Set<Discount> getDiscounts(CustomerType customerType) {
        return customerType == CustomerType.PREMIUM ? getPremiumDiscount() :
                customerType == CustomerType.REGULAR ? getRegularDiscount() : null;
    }

    // Prepare Regular discounts
    private Set<Discount> getRegularDiscount() {
        Discount discountRangeReg1 = new Discount(0, 5000, 0, CustomerType.REGULAR);
        Discount discountRangeReg2 = new Discount(5000, 10000, 10, CustomerType.REGULAR);
        Discount discountRangeReg3 = new Discount(10000, -1, 20, CustomerType.REGULAR);
        discounts.add(discountRangeReg1);
        discounts.add(discountRangeReg2);
        discounts.add(discountRangeReg3);
        return discounts;
    }

    // Prepare Premium discounts
    private Set<Discount> getPremiumDiscount() {
        Discount discountRangePrem1 = new Discount(0, 4000, 10, CustomerType.PREMIUM);
        Discount discountRangePrem2 = new Discount(4000, 8000, 15, CustomerType.PREMIUM);
        Discount discountRangePrem3 = new Discount(8000, 12000, 20, CustomerType.PREMIUM);
        Discount discountRangePrem4 = new Discount(12000, -1, 30, CustomerType.PREMIUM);
        discounts.add(discountRangePrem1);
        discounts.add(discountRangePrem2);
        discounts.add(discountRangePrem3);
        discounts.add(discountRangePrem4);
        return discounts;
    }
}
