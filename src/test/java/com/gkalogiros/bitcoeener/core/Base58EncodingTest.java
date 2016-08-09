package com.gkalogiros.bitcoeener.core;

import com.gkalogiros.bitcoeener.domain.Base58;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class Base58EncodingTest
{
    private static Map<String, String> TESTING_DATASET = ImmutableMap.of(
            "80CD1BCD81B271A1F3560688F219F3E1D52600A025C13AE3DFEB2EDA372DE73121496ED0CC",
            "5KNcog3fvDcgrSyi8Vu2eCuoyAEDCTSVJB4eFUkouksnyu8D3UP",
            "8046F7E29533F31A5DE0F566E6DEC2B348BA1902166ED38E622E03D4FD9E15BF0E5F338C5D",
            "5JMYNW27ph7QqKtkzgmK2ePDgPhxJQwVnqc2KSHsf1xP4BnPhBz",
            "80145E57D4DB3E56B9175F8D562C70912028FCF9CBA69E65494140713CB8234C3D063DF709",
            "5HyFsJvDuoLH3UBN8ZdSzpgu5itEYV5HVq8gTE5eubnTCiwZE32"
    );

    @Test
    public void testEncode() throws Exception
    {
        final Encoding<Base58> encoder = new Base58Encoding();

        TESTING_DATASET.entrySet().stream().forEach(entry -> {
            final BigInteger key = new BigInteger(entry.getKey(), 16);
            final byte[] encodedToken = encoder.encode(key.toByteArray()).get();
            assertThat(entry.getValue().getBytes()).isEqualTo(encodedToken);
        });


    }
}