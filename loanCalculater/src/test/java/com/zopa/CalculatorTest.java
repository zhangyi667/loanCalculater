package com.zopa;


import com.zopa.cal.Calculator;
import com.zopa.exception.InsufficientLoanException;
import org.junit.Test;

import java.io.IOException;

public class CalculatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenINputIsNull() {
        try {
            Calculator.calculateLoan(null);
        } catch (IOException e) {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenInputIsEmpty() {
        try {
            Calculator.calculateLoan(new String[]{});
        } catch (IOException e) {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenInputSizeIsNotRight() {
        try {
            Calculator.calculateLoan(new String[]{"", "", ""});
        } catch (IOException e) {

        }
    }

    @Test(expected = NumberFormatException.class)
    public void throwExceptionWhenSecondInputIsNotInteger() {
        try {
            Calculator.calculateLoan(new String[]{"", "abc"});
        } catch (IOException e) {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenRequestAmountIsTooSmall() {
        try {
            Calculator.calculateLoan(new String[]{"", "1"});
        } catch (IOException e) {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenRequestAmountIsTooLarge() {
        try {
            Calculator.calculateLoan(new String[]{"", "20000"});
        } catch (IOException e) {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenRequestAmountIsNotAnIncrementOf100() {
        try {
            Calculator.calculateLoan(new String[]{"", "1111"});
        } catch (IOException e) {

        }
    }

    @Test(expected = InsufficientLoanException.class)
    public void throwExceptionWhenInsufficientMoneyInPool() {
        try {
            Calculator.calculateLoan(new String[]{"../loanCalculater/src/test/resources/test.csv", "5000"});
        } catch (IOException e) {
        }
    }


}
