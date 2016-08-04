package com.gkalogiros.bitcoeener.domain;

import com.gkalogiros.bitcoeener.hashing.AbstractHashing;
import com.gkalogiros.bitcoeener.hashing.RIPEMD160;
import com.gkalogiros.bitcoeener.hashing.SHA256;

import java.math.BigInteger;

public class BitcoinAddress {

    public BitcoinAddress() {}

    public byte[] computeBitcoinAddress(final byte[] publicKey) throws Exception {

        final AbstractHashing sha256 = new SHA256();

        final AbstractHashing ripemd160 = new RIPEMD160();

        byte[] sha256Hash = sha256.get(publicKey);

        return ripemd160.get(sha256Hash);
    }

    public byte[] computeBitcoinAddress(final BigInteger publicKey) throws Exception {
        return this.computeBitcoinAddress(publicKey.toByteArray());
    }
}
