package com.observer;

import com.controller.LabyrinthSolver;


import java.util.*;



public class LabyrinthObserverSortedSolutions implements LabyrinthObserver {
    LabyrinthSolver labyrinthSolver;

    public LabyrinthObserverSortedSolutions(LabyrinthSolver labyrinthSolver) {
        this.labyrinthSolver = labyrinthSolver;
    }

    /**
     * Uses a TreeSet to store and display all solutions sorted by length
     */
    SortedSet<String> solutions=new TreeSet<>(new MyComp());
    @Override
    public void notifyChange() {
      solutions.add(labyrinthSolver.getStringMoves());
        System.out.println("\n " + "Solutions in sorted order are: ");
        System.out.print(solutions + "\n");
    }
}

class MyComp implements Comparator<String>{

    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }

}





