package com.zopa.exception;

/**
 * Created by zhangyi667 on 18/6/5.
 */
public class FileFormatNotSupportedException extends RuntimeException {

    private String format;

    public FileFormatNotSupportedException(String format) {
        this.format = format;
    }

    public String toString() {
        return String.format("File format '.%s' is currently not supported.", format);
    }
}
