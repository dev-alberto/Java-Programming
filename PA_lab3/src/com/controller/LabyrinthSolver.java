package com.controller;


import com.model.Labyrinth;
import com.Pair;

public interface LabyrinthSolver {
    void setLabyrinth(Labyrinth labyrinth);
    Labyrinth getLabirinth();
    void nextCellToExplore(Pair p); //nu stiu sigur
    void solve();
}
