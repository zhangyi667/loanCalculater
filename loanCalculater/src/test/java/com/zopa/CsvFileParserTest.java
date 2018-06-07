package com.zopa;


import com.zopa.util.fileParser.FileParser;
import com.zopa.util.fileParser.FileParserFactory;
import org.junit.Test;

import java.io.IOException;

public class CsvFileParserTest {

    @Test(expected = NumberFormatException.class)
    public void throwExceptionWhenFileHasInvalidData() {
        FileParser parser = FileParserFactory.dispatchParser("../loanCalculater/src/test/resources/fileWithInvalidData.csv");
        try {
            parser.parseFile();
        } catch (IOException e) {

        }
    }

}
