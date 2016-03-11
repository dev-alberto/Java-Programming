package com.observer;

import com.controller.LabyrinthSolver;
import com.model.LabyrinthMatrixImpl;

import java.util.Stack;

public interface LabyrinthObserver {
    /**
     * Method that takes an instance of the constroller and has different roles depending of the implementatio
     */
    void notifyChange();
    //String processSolution (LabyrinthMatrixImpl matrice);
}
