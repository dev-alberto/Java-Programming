package com.controller;


import com.model.Labyrinth;
import com.Pair;
import com.observer.LabyrinthObserver;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;

public interface LabyrinthSolver {
    /**
     * Sets the labyrinth to be solved.
     * @param labyrinth to be solved
     */
    void setLabyrinth(Labyrinth labyrinth);

    /**
     *
     * @return The current labyrinth that is to be solved
     */
    Labyrinth getLabirinth();

    /**
     * Method that return a List of the moves required to reach the goal of the labyrinth
     * @return list of moves
     */
    public List<String> getAllMoves();

    /**
     *  Method that checks whether the pair is free to be explored
     * @param p Pair to be explored
     * @return boelean true if cell is free, false otherwise
     */
    boolean nextCellToExplore(Pair p);

    /**
     * Method that solved the labyrinth
     */
    void solve();

    /**
     *
     * @param p Pair to be c
     * @return boolean, whether the pair has been visited or not
     */
    boolean isVisited(Pair p);

    /**
     * Method that helps print useful data about our progress in the mase. Part of the Observer Design Pattern
     */
    void notifyObservers();

    /**
     * Adds labyrinth observers in a list.
     * @param labyrinthObserver object
     */
    void registerObserver(LabyrinthObserver labyrinthObserver);

    /**
     * Method used for returning the list of moves as a String. Used by the sorted Observed to add said moves in a sorted set
      * @return List of moves as string
     */

    String getStringMoves();
}
