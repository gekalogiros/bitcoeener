package com.gkalogiros.bitcoeener.core;

import com.gkalogiros.bitcoeener.domain.Base58;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigInteger;

public class Base58Encoding implements Encoding<Base58>
{
    private static final char[] ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();

    private static final BigInteger BASE = new BigInteger("58");

    @Override
    public Base58 encode(byte[] input)
    {
        final StringBuilder sb = new StringBuilder("");

        BigInteger bi = new BigInteger(1, input);

        int zeros = countLeadingZeros(bi.toByteArray());

        while (bi.compareTo(BigInteger.ZERO) > 0)
        {
            BigInteger[] divideAndRemainder = bi.divideAndRemainder(BASE);

            bi = divideAndRemainder[0];

            BigInteger remainder = divideAndRemainder[1];

            sb.append(ALPHABET[remainder.intValue()]);
        }

        while (zeros > 0)
        {
            sb.append(ALPHABET[0]);
            zeros--;
        }

        // Remove signum from Big Integer
        return new Base58(sb.reverse().toString().substring(1).getBytes());
    }

    @Override
    public byte[] decode(Base58 base)
    {
        throw new NotImplementedException();
    }

    private int countLeadingZeros(byte[] number)
    {
        int zeros = 0;
        while (zeros < number.length && number[zeros] == 0)
        {
            ++zeros;
        }
        return zeros;
    }

}