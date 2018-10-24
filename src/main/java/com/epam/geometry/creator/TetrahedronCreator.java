package com.epam.geometry.creator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class TetrahedronCreator {

    private static final Logger logger = LogManager.getLogger();
    private Point pointA, pointB, pointC, pointD;

    public TetrahedronCreator(List<Double> resultList) {
        pointA = new Point(resultList.get(0), resultList.get(1), resultList.get(2));
        pointB = new Point(resultList.get(3), resultList.get(4), resultList.get(5));
        pointC = new Point(resultList.get(6), resultList.get(7), resultList.get(8));
        pointD = new Point(resultList.get(9), resultList.get(10), resultList.get(11));
    }

    public Tetrahedron createTetrahedron() {

        logger.info("Create new tetrahedron");
        return new Tetrahedron(pointA, pointB, pointC, pointD);
    }
}
