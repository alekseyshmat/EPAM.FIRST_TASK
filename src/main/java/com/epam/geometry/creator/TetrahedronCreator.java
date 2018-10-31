package com.epam.geometry.creator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TetrahedronCreator {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int INDEX_A = 0;
    private static final int INDEX_B = 1;
    private static final int INDEX_C = 2;
    private static final int INDEX_D = 3;

    public TetrahedronCreator() {
    }

    public Tetrahedron createTetrahedron(List<Double> resultList) {
        List<Point> tetrahedronCoordinates = new ArrayList<>();
        Iterator<Double> iterator = resultList.iterator();
        while (iterator.hasNext()) {
            Point point = new Point(iterator.next(), iterator.next(), iterator.next());
            tetrahedronCoordinates.add(point);
        }

        Point pointA = tetrahedronCoordinates.get(INDEX_A);
        Point pointB = tetrahedronCoordinates.get(INDEX_B);
        Point pointC = tetrahedronCoordinates.get(INDEX_C);
        Point pointD = tetrahedronCoordinates.get(INDEX_D);

        Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);

        LOGGER.info("Create new tetrahedron");
        return tetrahedron;
    }
}
