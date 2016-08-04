package com.gkalogiros.bitcoeener.core;

import org.junit.Test;

import java.math.BigInteger;

import static org.fest.assertions.Assertions.assertThat;

public class AddressCompositionTest
{

    @Test
    public void testApply() throws Exception
    {
        final BigInteger publicKey = new BigInteger
                ("50863AD64A87AE8A2FE83C1AF1A8403CB53F53E486D8511DAD8A04887E5B23522CD470243453A299FA9E77237716103ABC11A1DF38855ED6F2EE187E9C582BA6", 16);

        final BigInteger expectedTransformedKey = new BigInteger("00010966776006953D5567439E5E39F86A0D273BEE", 16);

        final AddressComposition addressComposition = new AddressComposition();

        final byte[] transformedKey = addressComposition.apply(publicKey.toByteArray());

        final BigInteger actualTransformedKey = new BigInteger(transformedKey);

        assertThat(actualTransformedKey).isEqualTo(expectedTransformedKey);
    }
}