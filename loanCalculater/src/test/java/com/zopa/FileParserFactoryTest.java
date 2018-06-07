package com.zopa;


import com.zopa.exception.FileFormatNotSupportedException;
import com.zopa.exception.InvalidFileNameException;
import com.zopa.util.fileParser.CsvFileParser;
import com.zopa.util.fileParser.FileParser;
import com.zopa.util.fileParser.FileParserFactory;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FileParserFactoryTest {

    @Test(expected = InvalidFileNameException.class)
    public void throwExceptionWhenFileNameIsEmpty() {
        FileParserFactory.dispatchParser("");
    }

    @Test(expected = InvalidFileNameException.class)
    public void throwExceptionWhenFileNameIsInvalid() {
        FileParserFactory.dispatchParser("someNameWithoutSuffix");
    }

    @Test(expected = FileFormatNotSupportedException.class)
    public void throwExceptionWhenFileFormatIsWrong() {
        FileParserFactory.dispatchParser("test.txt");
    }

    @Test(expected = FileFormatNotSupportedException.class)
    public void throwExceptionWhenFileFormatIsNotCsv() {
        FileParserFactory.dispatchParser("test.ahajf");
    }

    @Test()
    public void testDispatchCsvFile() {
        FileParser parser = FileParserFactory.dispatchParser("test.csv");
        assertTrue(parser instanceof CsvFileParser);
    }

}
