package com.gkalogiros.bitcoeener.hashing;

import org.junit.Test;

import java.math.BigInteger;

import static org.fest.assertions.Assertions.assertThat;

public class RIPEMD160Test {

    @Test
    public void testThatCanCreateInstance() throws Exception {
        new RIPEMD160();
    }

    @Test
    public void testThatLengthIs160() throws Exception {
        final AbstractHashing hasFunction = new RIPEMD160();
        final byte[] hash = hasFunction.get(new byte[]{0x11, 0x1F, 0x79});
        assertThat(hash.length).isEqualTo(160 / 8);
    }

    @Test
    public void testThatHashIsGeneratedCorrectly() throws Exception {
        final AbstractHashing hashFunction = new RIPEMD160();

        final BigInteger token = new BigInteger("600FFE422B4E00731A59557A5CCA46CC183944191006324A447BDB2D98D4B408", 16);

        byte[] hash = hashFunction.get(token.toByteArray());

        assertThat(hash.length).isEqualTo(160 / 8);

        final BigInteger expectedHash = new BigInteger("010966776006953D5567439E5E39F86A0D273BEE", 16);

        assertThat(expectedHash.toByteArray().length).isEqualTo(160/8);

        assertThat(hash).isEqualTo(expectedHash.toByteArray());

    }
}