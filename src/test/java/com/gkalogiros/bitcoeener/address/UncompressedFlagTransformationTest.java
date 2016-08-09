package com.gkalogiros.bitcoeener.address;

import com.gkalogiros.bitcoeener.transformations.PayloadPrefixing;
import com.gkalogiros.bitcoeener.transformations.UncompressedFlagTransformation;
import org.fest.assertions.Assertions;
import org.junit.Test;

public class UncompressedFlagTransformationTest
{

    @Test
    public void testApply() throws Exception {

        final PayloadPrefixing payloadPrefixing = new PayloadPrefixing();

        final UncompressedFlagTransformation uncompressedFlagTransformation = new UncompressedFlagTransformation(payloadPrefixing);

        byte[] newData = uncompressedFlagTransformation.apply(new byte[]{0x00});

        Assertions.assertThat(newData).isEqualTo(new byte[]{0x04, 0x00});
    }
}