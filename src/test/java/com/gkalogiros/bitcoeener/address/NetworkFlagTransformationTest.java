package com.gkalogiros.bitcoeener.address;

import com.gkalogiros.bitcoeener.domain.Network;
import com.gkalogiros.bitcoeener.transformations.NetworkFlagTransformation;
import com.gkalogiros.bitcoeener.transformations.PayloadPrefixing;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

public class NetworkFlagTransformationTest
{

    private PayloadPrefixing payloadPrefixing;

    @Before
    public void setUp() throws Exception {
        this.payloadPrefixing = new PayloadPrefixing();
    }

    @Test
    public void testTransformationWhenUsingMainNetwork() throws Exception {

        final NetworkFlagTransformation networkFlagTransformation = new NetworkFlagTransformation(Network.MAIN, payloadPrefixing);

        final byte[] payload = networkFlagTransformation.apply(new byte[]{0x04});

        Assertions.assertThat(payload).isEqualTo(new byte[]{0x00, 0x04});
    }

    @Test
    public void testTransformationWhenUsingTestNetwork() throws Exception {

        final NetworkFlagTransformation networkFlagTransformation = new NetworkFlagTransformation(Network.TEST, payloadPrefixing);

        final byte[] payload = networkFlagTransformation.apply(new byte[]{0x04});

        Assertions.assertThat(payload).isEqualTo(new byte[]{0x6F, 0x04});
    }
}