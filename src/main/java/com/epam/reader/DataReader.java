package com.epam.reader;

import com.epam.exception.ReadingFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private String path = "src/test/resources/test.txt";
    private static final Logger logger = LogManager.getLogger(DataReader.class);

    public DataReader() {
    }

    public List readingLines(String path) throws ReadingFileException {

        List<String> linesWithValues = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(path)));
            String tmp = "";
            while ((tmp = bufferedReader.readLine()) != null) {
                linesWithValues.add(tmp);
            }
            logger.info("File was read");
        } catch (Exception ex) {
            throw new ReadingFileException("File is not found", ex);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw new ReadingFileException("File is close", ex);
                }
            }
        }
        return linesWithValues;
    }
}
