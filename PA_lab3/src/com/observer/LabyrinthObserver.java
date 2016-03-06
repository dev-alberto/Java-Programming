package com.observer;

import com.controller.LabyrinthSolver;
import com.model.LabyrinthMatrixImpl;

import java.util.Stack;

public interface LabyrinthObserver {
    public void notify(LabyrinthSolver labyrinthSolver);
    //String processSolution (LabyrinthMatrixImpl matrice);
}
