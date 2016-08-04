package com.gkalogiros.bitcoeener.core;

import org.junit.Test;

import static com.gkalogiros.bitcoeener.domain.Network.*;
import static org.fest.assertions.Assertions.assertThat;

public class NetworkByteFactoryTest {

    private final NetworkByteFactory networkByteFactory = new NetworkByteFactory();

    @Test
    public void testThatCreatesTestNetByte() throws Exception {
        assertThat(networkByteFactory.create(TEST)).isEqualTo((byte) 0x6F);
    }

    @Test
    public void testThatCreatesMainNetByte() throws Exception {
        assertThat(networkByteFactory.create(MAIN)).isEqualTo((byte) 0x00);
    }
}