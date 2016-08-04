Bitcoeener
===================

A utilities collection implementing Bitcoin operations and transformations

ATTENTION
===================

While anyone can use the embedded utils for practicing Bitcoin, it is strongly suggested that you don't use this code for developing commercial applications e.g wallets etc.

There are amazing libraries out there than can do things better and faster e.g [bitcoinj](https://bitcoinj.github.io/).

You can still use the current library for educational purposes.

Private Key
===================

In bitcoin, a private key is a truly random integer generated by a secure cryptographic random generator.

The private key is 256 bits long and should be a number between 1 and 2^256-1.

A common practice is to generate a longer random integer and then pass it through a SHA256 hash function that will produce a 256-bit integer.

Public Key
====================

In bitcoin, a public key is a point on the elliptic curve defined in Secp256k1.

The general formula of an elliptic curve is y^2=x^3+ax^2+b

In Secp256k1, a=0 and b=7, as a result bitcoin uses the following elliptic curve formula: y^2=x^3+7

The Public Key is derived from the following formula: P=kG where k is the private key and G is the generator point.

All the operations is done in modulo p arithmetic where p = FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F = 2256 - 232 - 29 - 28 - 27 - 26 - 24 - 1

The Generator Point is a point on the Secp256k1 elliptic curve which is defined as G(x,y)=G("79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798","483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8")

Bitcoin Address
====================

Bitcoin Address is derived from public key by applying the following transformations:

1) SHA-256(PublicKey)

2) RIPEMD-160 of 1

3) Add Network bytes in front of 2. It should be 0x00 for Main Network and 0x6F for Test Network
This is done so that test net bitcoin addresses cannot be used in the main network.

4) SHA-256 on 3

5) SHA-256 on 4

6) Take the first 4 bytes of 5 and put them at the end of the value created in 3

7) Convert 6 to a Base58 String

The value produced is the 25-byte long Bitcoin address