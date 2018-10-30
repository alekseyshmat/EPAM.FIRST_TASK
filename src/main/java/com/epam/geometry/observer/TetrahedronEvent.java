package com.epam.geometry.observer;

import com.epam.geometry.entity.Tetrahedron;
import java.util.EventObject;

public class TetrahedronEvent extends EventObject {

    public TetrahedronEvent(Object source) {
        super(source);
    }

    public Tetrahedron getTetrahedron(){
        return (Tetrahedron)getSource();
    }
}
