package reader;

import exception.MyIoException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public Reader() {
    }

    public List readingLines(String path) {
        path = "E:\\EPAM\\TASK1\\geometry\\src\\main\\resources\\test.txt";
        List<String> linesWithValues = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(path)));
            String tmp = "";
            while ((tmp = bufferedReader.readLine()) != null) {
                linesWithValues.add(tmp);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return linesWithValues;
    }


    public void write() {
        for (Object str : readingLines("")) {
            String[] s = str.toString().split("\\s");
            for (String st : s) {
                System.out.println(st);
            }
        }
    }
}
