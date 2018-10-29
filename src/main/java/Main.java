import com.epam.geometry.action.Calculator;
import com.epam.geometry.creator.TetrahedronCreator;
import com.epam.geometry.entity.Tetrahedron;
import com.epam.geometry.exception.ReadingFileException;
import com.epam.geometry.parser.FileParser;
import com.epam.geometry.reader.DataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ReadingFileException {
        String path = "src/test/resources/test2.txt";
        DataReader dataReader = new DataReader();
        FileParser fileParser = new FileParser();
        List<List<Double>> coor = fileParser.parsingLines(dataReader.readingLines(path));
        List<Tetrahedron> tetrahedronList = new ArrayList<>();
        TetrahedronCreator tetrahedronCreator = new TetrahedronCreator();

        for (List<Double> d : coor){
            Tetrahedron tetrahedron= tetrahedronCreator.createTetrahedron(d);
            tetrahedronList.add(tetrahedron);
        }

        for (Tetrahedron t : tetrahedronList){
            Calculator calculator = new Calculator();
            calculator.calculateArea(t);
        }

    }
}
