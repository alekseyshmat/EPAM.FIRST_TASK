package com.epam.creator;

import com.epam.entity.Point;
import com.epam.parser.ParserFile;

import java.util.ArrayList;
import java.util.List;

public class PointCreator {

    private Point pointA, pointB, pointC, pointD;
    private ParserFile parserFile = new ParserFile();
    List<Double> inputList;

    public PointCreator(List<Double> inputList) {
        this.inputList = inputList;
    }

    public List<Point> createPoint(List<Double> inputList) {
        List<Point> pointList = new ArrayList<>();
        for (double element : inputList) {
            pointA.setX(element);
            pointA.setY(element);
            pointA.setZ(element);
            pointB.setX(element);
            pointB.setY(element);
            pointB.setZ(element);
            pointC.setX(element);
            pointC.setY(element);
            pointC.setZ(element);
            pointD.setX(element);
            pointD.setY(element);
            pointD.setZ(element);
        }

        pointList.add(pointA);
        pointList.add(pointB);
        pointList.add(pointC);
        pointList.add(pointD);

        for (Point point : pointList) {
            System.out.println(point);
        }
        return pointList;
    }
}
