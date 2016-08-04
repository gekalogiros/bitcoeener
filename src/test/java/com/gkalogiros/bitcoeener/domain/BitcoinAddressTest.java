package com.gkalogiros.bitcoeener.domain;

import org.junit.Test;

import java.math.BigInteger;

import static org.fest.assertions.Assertions.*;

public class BitcoinAddressTest {

    @Test
    public void testComputeBitcoinAddress() throws Exception {

        final BigInteger publicKey = new BigInteger("0450863AD64A87AE8A2FE83C1AF1A8403CB53F53E486D8511DAD8A04887E5B23522CD470243453A299FA9E77237716103ABC11A1DF38855ED6F2EE187E9C582BA6",16);

        final BitcoinAddress bitcoinAddress = new BitcoinAddress();

        final byte[] publicKeyHash = bitcoinAddress.computeBitcoinAddress(publicKey);

        final BigInteger expectedAddress = new BigInteger("010966776006953D5567439E5E39F86A0D273BEE", 16);

        assertThat(publicKeyHash).isEqualTo(expectedAddress.toByteArray());
    }
}