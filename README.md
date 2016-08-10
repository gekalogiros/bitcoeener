Bitcoeener
===================
[logo]: https://travis-ci.org/gekalogiros/bitcoeener.svg?branch=master "Travis CI Status"

What is this?
===================

A utilities collection implementing Bitcoin operations and transformations

ATTENTION
===================

This project has been created for educational purposes.

If you want to create commercial applications, please consider using [bitcoinj](https://bitcoinj.github.io/).

Private Key
===================

In bitcoin, a private key is a truly random integer generated by a secure cryptographic random generator.

The private key is 256 bits long and should be a number between 1 and 2^256-1.

A common practice is to generate a longer random integer and then pass it through a SHA256 hash function that will produce a 256-bit integer.

Public Key
====================

In Bitcoin, a public key is a point on the elliptic curve defined in Secp256k1.

The general formula of an elliptic curve is `y^2=x^3+ax^2+b`

In Secp256k1, `a=0` and `b=7`, as a result Bitcoin uses the following elliptic curve formula: `y^2=x^3+7`

The Public Key is derived from the following formula: P=kG where k is the private key and G is the generator point.

All the operations is done in modulo p arithmetic where
```
p = FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F = 2^256 - 2^32 - 2^9 - 2^8 - 2^7 - 2^6 - 2^4 - 1
```

The Generator Point is a point on the Secp256k1 elliptic curve which is defined as
```
G(x,y)=G("79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798","483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8")
```

Bitcoin Address
====================

Bitcoin Address is derived from public key by applying the following transformations:
```
1) SHA-256(PublicKey)

2) RIPEMD-160 of 1

3) Add Network bytes in front of 2. It should be 0x00 for Main Network and 0x6F for Test Network
This is done so that test net bitcoin addresses cannot be used in the main network.

4) SHA-256 on 3

5) SHA-256 on 4

6) Take the first 4 bytes of 5 and put them at the end of the value created in 3

7) Convert 6 to a Base58 String
```

The value produced is the 25-byte long Bitcoin address

Wallets
====================

The Bitcoin community strongly suggests using a new address for every distinct transaction.

This sounds silly but there is a very good reason behind this. It has to do with privacy.

Assuming your name is Bob and you love sausage rolls. Every morning you buy your sausage roll from the Amazing-Sausage-Rolls shop and you pay in bitcoins.

In the bitcoin network this transaction looks like a bitcoin address pays another bitcoin address. This transaction gets repeated every single day.

Let's assume that there's a third party member which is interested in monitoring the Bitcoin network. The third party can identify a recurring payment from Bob's bitcoin address to the shop's Bitcoin address in the public blockchain.

The shop's Bitcoin address is known to the shop customers, so the third party can come up with the conclusion that there is a guy buying sausage rolls from that shop every day. It's really easy for someone to guess that this person is Bob.

Using a different Bitcoin address for every transaction increases privacy levels as well as security in case someone compromises your private key.

Having said that, there is a vital need to somehow store and manage all your private keys. This is done by a special software called wallet.

There are various types of wallet:

* Non-Deterministic wallet

You can think about this as a software that maintains collection of random private keys that they aren't related.

e.g this type of wallet can store hundreds or thousands of unrelated private keys. However, if you generate private keys often, then backing them all can be a pain. For this particular reason people started using Deterministic wallets.

* [Deterministic wallet](https://en.bitcoin.it/wiki/Deterministic_wallet)

A deterministic wallet can generate multiple private keys which seem unrelated but they all have been generated from the same seed. So, if the seed is known, all the keys can be derived easily from the seed by simply feeding them to a hash function.

Transactions
====================

The following table describes the structure of a Bitcoin transaction:

| Type                | Size (in bytes) |
| --------------------| ---------------:|
| Transaction Version | 4               |
| Number of Inputs    | 1-9             |
| Inputs              | it varies       |
| Number of Outputs   | 1-9             |
| Outputs             | it varies       |
| nLockTime           | 4               |
