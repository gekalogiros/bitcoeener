package com.gkalogiros.bitcoeener.core;

public interface Encoding<T>
{
    public T encode(byte[] input);

    public byte[] decode(T base);
}
