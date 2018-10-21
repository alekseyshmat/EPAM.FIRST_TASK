package com.epam.action;

import com.epam.entity.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TetrahedronActionsTest {
    private static final double DELTA = 0.01;
    private TetrahedronActions tetrahedronActions;

    @BeforeClass
    public void setUp() {
        tetrahedronActions = new TetrahedronActions();
    }



}
