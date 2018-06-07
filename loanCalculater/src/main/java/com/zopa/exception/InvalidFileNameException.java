package com.zopa.exception;

/**
 * Created by zhangyi667 on 18/6/5.
 */
public class InvalidFileNameException extends RuntimeException {

    private String fileName;

    public InvalidFileNameException(String fileName) {
        this.fileName = fileName;
    }

    public String toString() {
        return String.format("'%s' is not a valid file.", fileName);
    }
}
