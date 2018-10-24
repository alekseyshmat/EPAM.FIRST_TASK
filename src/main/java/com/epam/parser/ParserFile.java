package com.epam.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.reader.DataReader;
import com.epam.validator.Validation;

import java.util.ArrayList;
import java.util.List;

public class ParserFile {

    private static final Logger logger = LogManager.getLogger(ParserFile.class);
    private Validation validation;

    public ParserFile() {
        validation = new Validation();
    }

    public List<Double> parsingLines(List<String> inputList) {
        List<Double> resultList = new ArrayList<>();
        for (String line : inputList) {
            if (validation.isValid(line)) {
                logger.info("Line: " + line + " is valid line");
                String[] numbers = line.split("\\s");
                for (String coordinates : numbers) {
                    resultList.add(Double.parseDouble(coordinates));
                }
            } else {
                logger.info("Line: " + line + " is not valid line");
            }
        }
        return resultList;
    }
}
