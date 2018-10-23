import com.epam.action.Calculator;
import com.epam.action.TetrahedronActions;
import com.epam.creator.TetrahedronCreator;
import com.epam.entity.Tetrahedron;
import com.epam.exception.ReadingFileException;
import com.epam.parser.ParserFile;
import com.epam.reader.Reader;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        String PATH = "src/test/resources/test2.txt";
        Reader reader = new Reader();
        ParserFile parserFile = new ParserFile();
        List listDouble = null;
        try {
            List list = reader.readingLines(PATH);
            listDouble = parserFile.parsingLines(list);
        } catch (ReadingFileException e) {
            e.printStackTrace();
        }

        TetrahedronCreator tetrahedronCreator = new TetrahedronCreator(listDouble);
        Tetrahedron tetrahedron = tetrahedronCreator.createTetrahedron();
        TetrahedronActions tetrahedronActions = new TetrahedronActions();
        System.out.println(tetrahedronActions.isTetrahedron(tetrahedron));
    }
}
