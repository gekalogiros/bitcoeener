package com.gkalogiros.bitcoeener.transformations;

import com.gkalogiros.bitcoeener.hashing.AbstractHashing;
import com.gkalogiros.bitcoeener.hashing.Hashing;

import java.util.function.Function;

public class HashingTransformation implements Function<byte[], byte[]>
{
    private final Hashing hash;

    public HashingTransformation(final Hashing hash)
    {
        this.hash = hash;
    }

    @Override
    public byte[] apply(byte[] bytes)
    {
        return hash.get(bytes);
    }
}
