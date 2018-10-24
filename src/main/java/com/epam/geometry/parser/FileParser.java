package com.epam.geometry.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.geometry.validator.Validation;

import java.util.ArrayList;
import java.util.List;

public class FileParser {

    private static final Logger logger = LogManager.getLogger(FileParser.class);
    private Validation validation;

    public FileParser() {
        validation = new Validation();
    }

    public List<double[]> parsingLines(List<String> inputList) {
        List<double[]> resultList = new ArrayList<>();
        double[] coordinateData = new double[50];
        for (String line : inputList) {
            if (validation.isValid(line)) {
                logger.info("Line: " + line + " is valid line");
                String[] numbers = line.split("\\s");
                for (int i = 0; i < numbers.length; i++) {
                    coordinateData[i] = Double.parseDouble(numbers[i]);
                }
                resultList.add(coordinateData);
            } else {
                logger.info("Line: " + line + " is not valid line");
            }
        }
        return resultList;
    }
}
