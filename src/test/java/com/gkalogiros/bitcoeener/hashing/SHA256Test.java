package com.gkalogiros.bitcoeener.hashing;

import org.junit.Test;

import java.math.BigInteger;

import static org.fest.assertions.Assertions.assertThat;

public class SHA256Test {

    @Test
    public void testThatCanCreateInstance() throws Exception {
        new SHA256();
    }

    @Test
    public void testThatGeneratesHash() throws Exception {

        final BigInteger number = new BigInteger("04CF96FF755E392593DA801B0A154300FB7415DD983B6B1A46DD05993D22C7B8A0C7BA981A95E281244D87A14F8C6D86E2C4F27D5888A52119D94264F27691EFF7", 16);

        AbstractHashing hashing = new SHA256();

        byte[] hash = hashing.get(number.toByteArray());

        assertThat(hash.length).isEqualTo(256 / 8);

        final BigInteger expectedHash = new BigInteger("20B86DD47F7D4B62C7FAC0E080E2189B33F71CBED101B450DB3BE3A2432B0BA7", 16);

        assertThat(hash).isEqualTo(expectedHash.toByteArray());
    }
}