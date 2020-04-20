package com.retail.discount;

import com.retail.common.CartProfile;
import com.retail.discount.dao.Discount;
import com.retail.discount.handler.DiscountChain;
import com.retail.discount.handler.IDiscountChain;
import com.retail.discount.service.DiscountService;
import com.retail.discount.service.IDiscountService;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Provides mechanism to define strategy for discounts
 *
 * @author pavaghade
 * @since 19 Apr 2020
 */
public class DiscountStrategy implements IDiscountStrategy {

    IDiscountService<Discount> discountService = new DiscountService();
    TreeSet<Discount> eligibleDiscountSlabs;
    IDiscountChain chainOfDiscounts;

    /**
     * Prepares the discount strategy so that specific strategy can be utilised
     *
     * @param profile
     * @return IDiscountChain - chain of handlers to perform discount actions
     */
    @Override
    public IDiscountChain prepareDiscountStrategy(CartProfile profile) throws IllegalArgumentException{
        double totalPrice = profile.getCartDetail().getTotalValue();
        if(totalPrice < 0) {
            throw new IllegalArgumentException("Total Price in cart is negative!");
        }
        Set<Discount> discounts = discountService.getDiscounts(profile.getCustomerType());
        // Sort the Discount based on the descending order of prices
        // e.g
        // The range 10000 onwards remains top
        // The range 5000 to 10000 remains 2nd
        // The range 0 to 5000 remains last
        eligibleDiscountSlabs = discounts.stream().filter(discount ->
                {
                    if (discount.getUptoAmount() == -1) {
                        if (totalPrice > discount.getFromAmount())
                            return true;
                        else
                            return false;
                    }

                    if (totalPrice >= discount.getFromAmount() && totalPrice <= discount.getUptoAmount()) {
                        return true;
                    }

                    return totalPrice >= discount.getUptoAmount();
                }
        ).collect(Collectors.toCollection(() ->
                new TreeSet<>((o1, o2) -> {
                    if (o1.getFromAmount() == o2.getFromAmount()
                            && o1.getUptoAmount() == o2.getUptoAmount() &&
                            o1.getDiscountPercent() == o2.getDiscountPercent()) {
                        return 0;
                    } else if (o1.getUptoAmount() == -1 && o2.getUptoAmount() != -1) {
                        return -1;
                    } else if (o2.getUptoAmount() == -1 && o1.getUptoAmount() != -1) {
                        return 1;
                    } else if (o1.getUptoAmount() <= o2.getFromAmount()) {
                        return 1;
                    } else {
                        return -1;
                    }
                })));

        return new DiscountChain(eligibleDiscountSlabs);
    }
}
