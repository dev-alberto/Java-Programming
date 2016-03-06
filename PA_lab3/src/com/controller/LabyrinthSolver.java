package com.controller;


import com.model.Labyrinth;
import com.Pair;
import com.observer.LabyrinthObserver;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;

public interface LabyrinthSolver {
    void setLabyrinth(Labyrinth labyrinth);
    Labyrinth getLabirinth();
    public List<String> getAllMoves();
    boolean nextCellToExplore(Pair p);
    void solve();
    boolean isVisited(Pair p);
    void notifyObservers();
    void registerObserver(LabyrinthObserver labyrinthObserver);
    public String getStringMoves();
}
