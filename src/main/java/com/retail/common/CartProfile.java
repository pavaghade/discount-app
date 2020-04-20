package com.retail.common;

/**
 * Holds the Cart profile with relevant details
 *
 * @author pavaghade
 * @since 19 Apr 2020
 */
public class CartProfile {
    // Customer type, eg. REGULAR, PREMIUM
    CustomerType customerType;

    // Cart details
    CartDetail cartDetail;

    public CartProfile() {
    }

    public CartProfile(CustomerType customerType, CartDetail cartDetail) {
        this.customerType = customerType;
        this.cartDetail = cartDetail;
    }
    // TODO : use lombok instead
    public CustomerType getCustomerType() {
        return customerType;
    }

    // TODO : use lombok instead
    public CartDetail getCartDetail() {
        return cartDetail;
    }
}
