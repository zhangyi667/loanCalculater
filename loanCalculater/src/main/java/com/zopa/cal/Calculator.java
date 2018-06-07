package com.zopa.cal;

import com.zopa.exception.InsufficientLoanException;
import com.zopa.util.Util;
import com.zopa.util.fileParser.FileParser;
import com.zopa.util.fileParser.FileParserFactory;

import java.io.IOException;
import java.util.List;

public class Calculator {

    private static final int MIN_LOAN_NUM = 1000;

    private static final int MAX_LOAN_NUM = 15000;

    private static int VALID_LOAN_GAP = 100;

    private static Integer requestedAmount;

    private static double totalMoneyInPool = 0;

    private static double moneyToPay = 0; // money to pay in 3 years

    public static void main(String[] args) throws IOException {
        calculateLoan(args);
    }

    public static void calculateLoan(String[] args) throws IOException {
        parseInput(args);
        String fileName = args[0];
        parseInputFile(fileName);
        double interestToPay = moneyToPay - totalMoneyInPool;
        LoanRequest request = new LoanRequest(requestedAmount, interestToPay);
        System.out.println(request.toString());
    }

    private static void parseInputFile(String fileName) throws IOException {
        FileParser parser = FileParserFactory.dispatchParser(fileName);
        List<Lender> lenders = parser.parseFile();
        for (Lender lender : lenders) {
            totalMoneyInPool += lender.getMoneyInTotal();
            moneyToPay += Math.pow((1 + lender.getInterest()), Util.DEFAULT_YEAR) * lender.getMoneyInTotal();
        }
        if (totalMoneyInPool < requestedAmount) {
            throw new InsufficientLoanException();
        }
    }

    private static void parseInput(String[] args) {
        if (null == args || args.length == 0) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        if (args.length != 2) {
            throw new IllegalArgumentException("Valid number of input params is 2.");
        }
        try {
            requestedAmount = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Argument" + args[1] + " must be an integer.");
        }
        if (loanNumberInvalid()) {
            throw new IllegalArgumentException(String.format("The loan should be any £%d increment between £%d and £%d inclusive.", VALID_LOAN_GAP, MIN_LOAN_NUM, MAX_LOAN_NUM));
        }
    }

    private static boolean loanNumberInvalid() {
        return (requestedAmount < MIN_LOAN_NUM || requestedAmount > MAX_LOAN_NUM) ||
                requestedAmount % VALID_LOAN_GAP != 0;
    }
}
