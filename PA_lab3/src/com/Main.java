package com;


import com.controller.LabyrinthSolveInteractive;
import com.controller.LabyrinthSolver;
import com.controller.LabyrinthSolverAutomated;
import com.factory.LabyrinthFactory;
import com.factory.LabyrinthType;
import com.model.Labyrinth;
import com.model.LabyrinthListImpl;
import com.model.LabyrinthMatrixImpl;
import com.observer.LabirynthObserverImpl;
import com.observer.LabirynthObserverSecondImpl;
import com.observer.LabirynthObserverThirdImpl;
import com.observer.LabyrinthObserverSortedSolutions;
import com.view.LabyrinthView;
import com.view.LabyrinthViewImpl;

import java.io.IOException;
import java.io.SyncFailedException;

public class Main {
    public static void main(String [] args)  throws IOException
    {

        Labyrinth labyrinth= LabyrinthFactory.buildLabyrinth(LabyrinthType.LIST);
        Labyrinth labyrinth1=LabyrinthFactory.buildLabyrinth(LabyrinthType.MATRIX);
        /*
       // Labyrinth labyrinth=new LabyrinthMatrixImpl("input.txt");
        LabyrinthSolver labyrinthSolver=new LabyrinthSolverAutomated(labyrinth);
        labyrinthSolver.registerObserver(new LabirynthObserverImpl(labyrinthSolver));
        labyrinthSolver.registerObserver(new LabirynthObserverSecondImpl(labyrinthSolver));
        labyrinthSolver.registerObserver(new LabirynthObserverThirdImpl(labyrinthSolver));
        labyrinthSolver.registerObserver(new LabyrinthObserverSortedSolutions(labyrinthSolver));
        labyrinthSolver.solve();
        */

        LabyrinthSolver labyrinthSolver1=new LabyrinthSolveInteractive(labyrinth1);
        labyrinthSolver1.registerObserver(new LabirynthObserverImpl(labyrinthSolver1));
        labyrinthSolver1.registerObserver(new LabirynthObserverImpl(labyrinthSolver1));
        labyrinthSolver1.registerObserver(new LabirynthObserverSecondImpl(labyrinthSolver1));
        labyrinthSolver1.registerObserver(new LabirynthObserverThirdImpl(labyrinthSolver1));
        labyrinthSolver1.solve();

    }
}
