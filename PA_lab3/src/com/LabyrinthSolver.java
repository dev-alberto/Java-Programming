package com;


public interface LabyrinthSolver {
    void setLabyrinth(Labyrinth labyrinth);
    Labyrinth getLabirinth();
    void nextCellToExplore(int row,int column); //nu stiu sigur
}
