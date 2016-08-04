package com.gkalogiros.bitcoeener.domain;

import java.math.BigInteger;

public class Order
{
    private final BigInteger order;

    public Order(final BigInteger order)
    {
        this.order = order;
    }

    public BigInteger getOrder()
    {
        return order;
    }
}
