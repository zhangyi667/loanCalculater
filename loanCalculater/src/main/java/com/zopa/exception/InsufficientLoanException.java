package com.zopa.exception;

/**
 * Created by zhangyi667 on 18/6/5.
 */
public class InsufficientLoanException extends RuntimeException {

    public String toString() {
        return "It is not possible to provide a quote at the time.";
    }
}
