package com.model;


import com.Pair;

public interface Labyrinth {
    /**
     *
     * @return number of rows in the labyrinth
     */
    int getRowCount();

    /**
     *
     * @return Number of columns in a labyrinth represented as a matrix
     */
    int getColumnCount();

    /**
     *
     * @param p Pair we want to check
     * @return boolean, wheather the given cell is free
     */
    boolean isFreeAt(Pair p);

    /**
     * Returns whether there is a wall at a given cell
     * @param p Pair we want to check
     * @return boolean
     */
    boolean isWallAt(Pair p);
    /**
     * @return the start cell in a labyrinth
     */
     Pair getStartCell();

    /**
     *
     * @return The finish cell in a labyrinth
     */
     Pair getFinishCell();

    /**
     *
     * @param p Pair we want wo set the value;
     * @param value actual value we want to set for the some pair
     */
    public void setValue(Pair p,int value);

    /**
     * Returns the value of the given cell
     * @param p pair we want to know the value of
     * @return int value of pair p
     */
    public int getValue(Pair p);

    /**
     * Checks if a pair is in the labyrinth or not
     * @param p we want to see if it's out of bound
     * @return boolean
     */
    boolean outOfBound(Pair p);
}
