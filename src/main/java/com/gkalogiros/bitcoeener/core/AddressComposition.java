package com.gkalogiros.bitcoeener.core;

import com.gkalogiros.bitcoeener.address.UncompressedFlagTransformation;
import com.gkalogiros.bitcoeener.domain.Network;
import com.gkalogiros.bitcoeener.hashing.AbstractHashing;
import com.gkalogiros.bitcoeener.hashing.RIPEMD160;
import com.gkalogiros.bitcoeener.hashing.SHA256;
import com.gkalogiros.bitcoeener.address.NetworkFlagTransformation;
import com.gkalogiros.bitcoeener.address.HashingTransformation;
import com.gkalogiros.bitcoeener.address.PayloadPrefixing;

import java.util.function.Function;

public class AddressComposition implements Function<byte[], byte[]>
{

    private final AbstractHashing sha256;

    private final AbstractHashing ripemd160;

    private final PayloadPrefixing payloadPrefixing;

    private final Function<byte[], byte[]> flagPublicKeyAsUncompressed, toSHA256, toRIPEMD160, addNetworkBytes;

    public AddressComposition()
    {
        this.sha256 = new SHA256();
        this.ripemd160 = new RIPEMD160();
        this.payloadPrefixing = new PayloadPrefixing();
        this.flagPublicKeyAsUncompressed = new UncompressedFlagTransformation(payloadPrefixing);
        this.toSHA256 = new HashingTransformation(sha256);
        this.toRIPEMD160 = new HashingTransformation(ripemd160);
        this.addNetworkBytes = new NetworkFlagTransformation(Network.MAIN, payloadPrefixing);
    }

    @Override
    public byte[] apply(byte[] publicKey)
    {
        return flagPublicKeyAsUncompressed
                .andThen(toSHA256)
                .andThen(toRIPEMD160)
                .andThen(addNetworkBytes)
                .apply(publicKey);
    }
}
