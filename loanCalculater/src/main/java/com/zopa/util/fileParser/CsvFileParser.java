package com.zopa.util.fileParser;

import com.zopa.cal.Lender;

import java.io.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CsvFileParser extends AbstractFileParser implements FileParser {

    private static String COMMA = ",";


    CsvFileParser(String fileName) {
        super(fileName);
    }

    @Override
    public  List<Lender> parseFile() throws IOException {
        List<Lender> inputList;
        File inputF = new File(this.getFileName());
        InputStream inputFS = new FileInputStream(inputF);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
        // skip the header of the csv
        inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
        br.close();
        return inputList;
    }

    private static Function<String, Lender> mapToItem = (line) -> {
        String[] p = line.split(COMMA);
        Lender item = new Lender();
        item.setInterest(Double.parseDouble(p[1]));
        item.setMoneyInTotal(Integer.parseInt(p[2]));
        return item;
    };

}
