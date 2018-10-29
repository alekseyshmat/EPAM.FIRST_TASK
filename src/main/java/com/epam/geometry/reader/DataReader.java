package com.epam.geometry.reader;

import com.epam.geometry.exception.ReadingFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static final String MESSAGE_FOR_EXCEPTION = "File is not found";
    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public DataReader() {
    }

    public List readingLines(String path) throws ReadingFileException, IOException {

        List<String> linesWithValues = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(path)));
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
                linesWithValues.add(tmp);
            }
            LOGGER.info("File was read");
        } catch (Exception ex) {
            LOGGER.info("File is not found");
            throw new ReadingFileException(MESSAGE_FOR_EXCEPTION, ex);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return linesWithValues;
    }
}
