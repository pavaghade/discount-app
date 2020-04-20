package com.retail.discount.handler;

import com.retail.common.CustomerType;
import com.retail.discount.dao.Discount;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.TreeSet;

/**
 * Unit test coverage for Discount chain
 *
 * @author pavaghade
 * @since 19 Apr 2020
 */
@RunWith(JUnit4.class)
public class DiscountChainTest extends TestCase {

    IDiscountChain discountChain;

    @Before
    @Override
    public void setUp() {
        TreeSet<Discount> discounts = new TreeSet<>((o1, o2) -> {
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
        });
        discounts.add(new Discount(0, 5000, 0, CustomerType.REGULAR));
        discounts.add(new Discount(5000, 10000, 10, CustomerType.REGULAR));
        discountChain = new DiscountChain(discounts);
    }

    @After
    public void cleanUp() {
        discountChain = null;
    }

    @Test
    public void testGetDiscount() {
        double discount = discountChain.getDiscount(10000);
        Assert.assertTrue(discount == 500);
    }
}