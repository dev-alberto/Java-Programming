package com.view;


import com.controller.LabyrinthSolver;
import com.model.Labyrinth;

public interface LabyrinthView {
    void setLabyrinth(LabyrinthSolver labyrinthSolver);
    LabyrinthSolver getLabyrinth();
    void constructLabyrinth();
    String toString();
}
