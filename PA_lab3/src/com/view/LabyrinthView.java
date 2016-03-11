package com.view;


import com.controller.LabyrinthSolver;
import com.model.Labyrinth;

public interface LabyrinthView {
    /**
     * Sets the labyrinth to be viewed
     * @param labyrinthSolver takes instance from controller as a parameter
     */
    void setLabyrinth(LabyrinthSolver labyrinthSolver);

    /**
     *
     * @return an instance of Labyrinth solver
     */
    LabyrinthSolver getLabyrinth();

    /**
     * Constructs the String that represents a labyrinth
     */
    void constructLabyrinth();

    /**
     *
     * @return the String contructed by constructLabyrinth()
     */
    String toString();
}
