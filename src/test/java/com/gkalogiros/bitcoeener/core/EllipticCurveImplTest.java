package com.gkalogiros.bitcoeener.core;

import com.gkalogiros.bitcoeener.domain.Point;
import org.junit.Test;

import java.math.BigInteger;

import static com.gkalogiros.bitcoeener.core.Constants.*;

import static org.fest.assertions.Assertions.assertThat;

public class EllipticCurveImplTest {

    final EllipticCurve ec = new EllipticCurveImpl(ORDER);

    @Test
    public void testMultiplication() throws Exception {
        final Point point = ec.multiply(GENERATOR_POINT, new BigInteger("2"));
        assertThat(point.getX().toString(16)).isEqualToIgnoringCase("c6047f9441ed7d6d3045406e95c07cd85c778e4b8cef3ca7abac09b95c709ee5");
        assertThat(point.getY().toString(16)).isEqualToIgnoringCase("1ae168fea63dc339a3c58419466ceaeef7f632653266d0e1236431a950cfe52a");
    }

    @Test
    public void testInverse() throws Exception {
        assertThat(ec.inverse(BigInteger.ONE)).isEqualTo(new BigInteger("1"));
    }

    @Test
    public void testAddition() throws Exception {

        final Point sum = ec.add(GENERATOR_POINT, GENERATOR_POINT);

        final Point expectedSum = ec.multiply(GENERATOR_POINT, new BigInteger("2"));

        assertThat(sum).isEqualTo(expectedSum);
    }

    @Test
    public void testThatPointIsOnCurve() throws Exception {
        assertThat(ec.isOnEllipticCurve(GENERATOR_POINT)).isTrue();
    }
}