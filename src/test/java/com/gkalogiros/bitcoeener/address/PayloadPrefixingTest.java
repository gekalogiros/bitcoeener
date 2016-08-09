package com.gkalogiros.bitcoeener.address;

import com.gkalogiros.bitcoeener.transformations.PayloadPrefixing;
import org.fest.assertions.Assertions;
import org.junit.Test;

public class PayloadPrefixingTest {

    @Test
    public void testApply() throws Exception {

        final PayloadPrefixing payloadPrefixing = new PayloadPrefixing();

        final byte[] prefix = new byte[]{00, 01};

        final byte[] payload = new byte[]{02, 03};

        final byte[] actual = payloadPrefixing.apply(prefix, payload);

        final byte[] expected = new byte[]{00, 01, 02, 03};

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}