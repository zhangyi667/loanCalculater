package com.zopa;


import com.zopa.cal.LoanRequest;
import org.junit.Test;

public class LoanRequestTest {
    @Test
    public void test() {
        int requestAmount = 3600;
        double interest = 400.5d;
        LoanRequest req = new LoanRequest(requestAmount, interest);
        assert req.getRequestedAmount() == requestAmount;
        assert req.getMonthlyAmount() == (requestAmount + interest) / LoanRequest.DEFAULT_MONTH_TO_PAY;
    }
}
