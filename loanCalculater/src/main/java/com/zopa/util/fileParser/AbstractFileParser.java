package com.zopa.util.fileParser;


abstract class AbstractFileParser {
    private String fileName;

    public AbstractFileParser(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
