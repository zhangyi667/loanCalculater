package com.zopa.util.fileParser;

import com.zopa.exception.FileFormatNotSupportedException;
import com.zopa.exception.InvalidFileNameException;


public class FileParserFactory {
    public static FileParser dispatchParser(String fileName) {
        if (
                null == fileName ||
                fileName.length() == 0 ||
                !fileName.contains(".")
                ) {
            throw new InvalidFileNameException(fileName);
        }
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (suffix.equals("csv")) {
            return new CsvFileParser(fileName);
        }
        throw new FileFormatNotSupportedException(suffix);
    }

}
