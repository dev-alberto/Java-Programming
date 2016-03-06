package com.observer;

import com.controller.LabyrinthSolver;


import java.util.*;


/**
 * Created by alber_000 on 3/6/2016.
 */

public class LabyrinthObserverSortedSolutions implements LabyrinthObserver {
    SortedSet<String> solutions=new TreeSet<>(new MyComp());
    @Override
    public void notify(LabyrinthSolver labyrinthSolver) {
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





