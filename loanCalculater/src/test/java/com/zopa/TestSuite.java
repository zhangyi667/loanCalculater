package com.zopa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UtilTests.class,
        CsvFileParserTest.class,
        CalculatorTest.class,
        LoanRequestTest.class
})
public class TestSuite {
}
