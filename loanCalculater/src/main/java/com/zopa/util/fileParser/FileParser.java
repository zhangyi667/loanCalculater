package com.zopa.util.fileParser;

import com.zopa.cal.Lender;

import java.io.IOException;
import java.util.List;

public interface FileParser {
    List<Lender> parseFile() throws IOException;
}
