package com.zopa;

import com.zopa.util.Util;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UtilTests {

    @Test
    public void testCalculateRate() {
        assertTrue(Util.calculateRate(1000, 30.88d, 36) - 0.07d < 0.0001d);
        assertTrue(Util.calculateRate(10000, 179.68d, 60) - 0.03d < 0.0001d);
        assertTrue(Util.calculateRate(10000, 221.34d, 48) - 0.03d < 0.0001d);
        assertTrue(Util.calculateRate(4400, 132.29d, 36) - 0.052d < 0.0001d);
    }

    @Test
    public void testFormatDouble() {
        assertTrue(Double.compare(Util.getTwoDecimal(0.123d), 0.12d) == 0);
        assertTrue(Double.compare(Util.getTwoDecimal(0.12345d), 0.12d) == 0);
        assertTrue(Double.compare(Util.getTwoDecimal(0.12d), 0.12d) == 0);
        assertTrue(Double.compare(Util.getTwoDecimal(0.1d), 0.1d) == 0);

        assertTrue(Double.compare(Util.getOneDecimal(0.1d), 0.1d) == 0);
        assertTrue(Double.compare(Util.getOneDecimal(0.12d), 0.1d) == 0);
        assertTrue(Double.compare(Util.getOneDecimal(0.123d), 0.1d) == 0);
        assertTrue(Double.compare(Util.getOneDecimal(0.1234d), 0.1d) == 0);
        assertTrue(Double.compare(Util.getOneDecimal(0.12345d), 0.1d) == 0);

    }
}
