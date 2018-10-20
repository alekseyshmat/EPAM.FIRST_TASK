package com.epam.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.reader.Reader;
import com.epam.validator.Validation;

import java.util.ArrayList;
import java.util.List;

public class ParserFile {

    private static final Logger logger = LogManager.getLogger(ParserFile.class);
    private Validation validation;
    private Reader reader;
    private List linesList;

    public ParserFile() {
        validation = new Validation();
        reader = new Reader();
    }

    public List<Double> parsingLines(List<String> inputList) {
        List<Double> resultList = new ArrayList<>();
        for (String line : inputList) {
            if (validation.isValid(line)) {
                logger.info("Line: " + line + " is valid");
                String[] numbers = line.split("\\s");
                for (String coordinates : numbers) {
                    resultList.add(Double.parseDouble(coordinates));
                }
            } else {
                logger.info("Line: " + line + " is not valid");
            }
        }
        return resultList;
    }
}
