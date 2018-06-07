package com.zopa.util;

import com.zopa.exception.InsufficientLoanException;

import java.text.DecimalFormat;


public class Util {

    public static final int DEFAULT_YEAR = 3;

    private static final int MAX_TRY_TIMES = 100;

    private static final double MAX_RATE_ACCEPTED = 1d; // assume the max monthly rate that we accept is 100%

    public static double calculateRate(int total, Double actualMonthlyAmount, int n) {
        double max = MAX_RATE_ACCEPTED;
        double min = 0;
        double estimateRate = (max + min) / 2;
        double estimateMonthlyAmount = calculateMonthlyPay(total, estimateRate, n);
        int count = 0;

        while (count++ < MAX_TRY_TIMES && Math.abs(estimateMonthlyAmount - actualMonthlyAmount) > 0.01d ) {
            if (estimateMonthlyAmount > actualMonthlyAmount) {
                max = estimateRate;
            } else {
                min = estimateRate;
            }
            estimateRate = (max + min) / 2;
            estimateMonthlyAmount = calculateMonthlyPay(total, estimateRate, n);
        }
        if (count == MAX_TRY_TIMES) {
            throw new InsufficientLoanException();
        }
        return estimateRate;
    }

    private static double calculateMonthlyPay(int total, double estimateRate, int n) {
        return total * estimateRate * Math.pow((1 + estimateRate), n) / (Math.pow((1 + estimateRate), n) - 1);
    }

    public static double getTwoDecimal(double num) {
        return formatDouble(num, "#.00");
    }

    public static double getOneDecimal(double num) {
        return formatDouble(num, "#.0");
    }

    private static double formatDouble(double num, String pattern) {
        DecimalFormat dFormat = new DecimalFormat(pattern);
        String yearString = dFormat.format(num);
        return Double.valueOf(yearString);
    }

}
