package com.epam.geometry.creator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TetrahedronCreator {

    private static final Logger logger = LogManager.getLogger();
    private Point pointA, pointB, pointC, pointD;
    public TetrahedronCreator() {
    }

    public Tetrahedron createTetrahedron(List<Double> resultList) {
        List<Point> tetrahedronCoordinates = new ArrayList<>();
        Iterator<Double> iterator = resultList.iterator();
        while (iterator.hasNext()) {
            Point point = new Point(iterator.next(), iterator.next(), iterator.next());
            tetrahedronCoordinates.add(point);
        }
        pointA = tetrahedronCoordinates.get(0);
        pointB = tetrahedronCoordinates.get(1);
        pointC = tetrahedronCoordinates.get(2);
        pointD = tetrahedronCoordinates.get(3);
        logger.info("Create new tetrahedron");
        return new Tetrahedron(pointA, pointB, pointC, pointD);
    }
}
