package com.gkalogiros.bitcoeener.address;

import com.gkalogiros.bitcoeener.hashing.AbstractHashing;

import java.util.function.Function;

public class HashingTransformation implements Function<byte[], byte[]>
{
    private final AbstractHashing hash;

    public HashingTransformation(final AbstractHashing hash)
    {
        this.hash = hash;
    }

    @Override
    public byte[] apply(byte[] bytes)
    {
        return hash.get(bytes);
    }
}
