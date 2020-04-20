package com.retail.discount;

import com.retail.common.CartDetail;
import com.retail.common.CartProfile;
import com.retail.common.CustomerType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
/**
 * Unit test class end to end discount testing
 *
 * @author pavaghade
 * @since 19 Apr 2020
 */
@RunWith(JUnit4.class)
public class DiscountStrategyTest {

    IDiscountStrategy discountStrategy;

    @Before
    public void setUp() {
        discountStrategy = new DiscountStrategy();
    }

    @After
    public void cleanUp() {
        discountStrategy = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void prepareDiscountStrategy_IllegalArument() {
        CartProfile cartProfile = new CartProfile(CustomerType.REGULAR, new CartDetail(-10));
        discountStrategy.prepareDiscountStrategy(cartProfile);
    }

    @Test
    public void prepareDisStrat_input_5000_REG_cust_dis_0() {
        double totalPrice = 5000;
        CartProfile cartProfile = new CartProfile(CustomerType.REGULAR, new CartDetail(totalPrice));
        double discountAmount = discountStrategy.prepareDiscountStrategy(cartProfile).getDiscount(totalPrice);
        double finalPrice = totalPrice - discountAmount;
        Assert.assertTrue(finalPrice == 5000);
    }

    @Test
    public void prepareDisStrat_input_10000_REG_cust_dis_500() {
        double totalPrice = 10000;
        CartProfile cartProfile = new CartProfile(CustomerType.REGULAR, new CartDetail(totalPrice));
        double discountAmout = discountStrategy.prepareDiscountStrategy(cartProfile).getDiscount(totalPrice);
        double finalPrice = totalPrice - discountAmout;
        Assert.assertTrue(finalPrice == 9500);
    }

    @Test
    public void prepareDisStrat_input_15000_REG_cust_dis_1500() {
        double totalPrice = 15000;
        CartProfile cartProfile = new CartProfile(CustomerType.REGULAR, new CartDetail(totalPrice));
        double discountAmout = discountStrategy.prepareDiscountStrategy(cartProfile).getDiscount(totalPrice);
        double finalPrice = totalPrice - discountAmout;
        Assert.assertTrue(finalPrice == 13500);
    }

    @Test
    public void prepareDisStrat_input_4000_REG_cust_dis_400() {
        double totalPrice = 4000;
        CartProfile cartProfile = new CartProfile(CustomerType.PREMIUM, new CartDetail(totalPrice));
        double discountAmout = discountStrategy.prepareDiscountStrategy(cartProfile).getDiscount(totalPrice);
        double finalPrice = totalPrice - discountAmout;
        Assert.assertTrue(finalPrice == 3600);
    }

    @Test
    public void prepareDisStrat_input_8000_REG_cust_dis_1000() {
        double totalPrice = 8000;
        CartProfile cartProfile = new CartProfile(CustomerType.PREMIUM, new CartDetail(totalPrice));
        double discountAmout = discountStrategy.prepareDiscountStrategy(cartProfile).getDiscount(totalPrice);
        double finalPrice = totalPrice - discountAmout;
        Assert.assertTrue(finalPrice == 7000);
    }

    @Test
    public void prepareDisStrat_input_12000_REG_cust_dis_1800() {
        double totalPrice = 12000;
        CartProfile cartProfile = new CartProfile(CustomerType.PREMIUM, new CartDetail(totalPrice));
        double discountAmout = discountStrategy.prepareDiscountStrategy(cartProfile).getDiscount(totalPrice);
        double finalPrice = totalPrice - discountAmout;
        Assert.assertTrue(finalPrice == 10200);
    }

    @Test
    public void prepareDisStrat_input_20000_REG_cust_dis_4200() {
        double totalPrice = 20000;
        CartProfile cartProfile = new CartProfile(CustomerType.PREMIUM, new CartDetail(totalPrice));
        double discountAmout = discountStrategy.prepareDiscountStrategy(cartProfile).getDiscount(totalPrice);
        double finalPrice = totalPrice - discountAmout;
        Assert.assertTrue(finalPrice == 15800);
    }

}