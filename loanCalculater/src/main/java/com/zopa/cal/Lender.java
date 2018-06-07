package com.zopa.cal;

/**
 * Created by zhangyi667 on 18/6/5.
 */
public class Lender {
    private double interest;
    private int moneyInTotal;

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

    public int getMoneyInTotal() {
        return moneyInTotal;
    }

    public void setMoneyInTotal(int moneyInTotal) {
        this.moneyInTotal = moneyInTotal;
    }
}
