package com.retail.discount;

import com.retail.common.CartProfile;
import com.retail.discount.handler.IDiscountChain;

/**
 * Provides mechanism to define strategy for discounts
 *
 * @author pavaghade
 * @since 19 Apr 2020
 */
public interface IDiscountStrategy {

    /**
     * Prepares the discount strategy so that specific strategy can be utilised
     *
     * @param profile
     * @return IDiscountChain - chain of handlers to perform discount actions
     */
    IDiscountChain prepareDiscountStrategy(CartProfile profile);
}
