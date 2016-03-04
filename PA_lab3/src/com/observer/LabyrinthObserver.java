package com.observer;

import com.model.LabyrinthMatrixImpl;

public interface LabyrinthObserver {
    void processCell(int i,int j);
    //String processSolution (LabyrinthMatrixImpl matrice);
}
