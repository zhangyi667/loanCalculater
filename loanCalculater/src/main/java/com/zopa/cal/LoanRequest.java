package com.zopa.cal;

import com.zopa.util.Util;

public class LoanRequest {
    private int requestedAmount;
    private double rate;
    private double totalRepayment;

    public static final int DEFAULT_MONTH_TO_PAY = Util.DEFAULT_YEAR * 12;

    public LoanRequest(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public LoanRequest(int requestedAmount, double interest) {
        this.requestedAmount = requestedAmount;
        completeRequest(interest);
    }
    public int getRequestedAmount() {
        return requestedAmount;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public double getMonthlyAmount() {
        return totalRepayment / DEFAULT_MONTH_TO_PAY;
    }

    public void setTotalRepayment(double totalRepayment) {
        this.totalRepayment = totalRepayment;
    }

    public double displayTotalRepayment() {
        return Util.getTwoDecimal(this.totalRepayment);
    }

    public double displayMonthlyRepayment() {
        return Util.getTwoDecimal(getMonthlyAmount());
    }

    public String displayRate() {
        return Util.getOneDecimal(rate * 12 * 100) + "%";
    }

    public String toString() {
        return String.format("Requested amount: £%d\n" +
                "Rate: %s\n" +
                "Total repayment: £%.2f\n" +
                "Monthly repayment: £%.2f",
                this.getRequestedAmount(),
                this.displayRate(),
                this.displayTotalRepayment(),
                this.displayMonthlyRepayment()
                );
    }

    void completeRequest( double interestToPay) {
        totalRepayment = requestedAmount + interestToPay;
        rate = Util.calculateRate(requestedAmount, this.getMonthlyAmount(), DEFAULT_MONTH_TO_PAY);
    }
}
