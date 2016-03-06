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

public class Main {
    public static void main(String [] args)  throws IOException
    {
        Labyrinth labyrinth= LabyrinthFactory.buildLabyrinth(LabyrinthType.MATRIX);
       // Labyrinth labyrinth=new LabyrinthMatrixImpl("input.txt");
        LabyrinthSolver labyrinthSolver=new LabyrinthSolverAutomated(labyrinth);
        labyrinthSolver.registerObserver(new LabirynthObserverImpl());
        labyrinthSolver.registerObserver(new LabirynthObserverSecondImpl());
        labyrinthSolver.registerObserver(new LabirynthObserverThirdImpl());
        labyrinthSolver.registerObserver(new LabyrinthObserverSortedSolutions());
        labyrinthSolver.solve();

        /*
        Labyrinth labyrinthMatrix = new LabyrinthMatrixImpl("input.txt");
        LabyrinthSolver labyrinthSolveInteractive = new LabyrinthSolveInteractive(labyrinthMatrix);
        labyrinthSolveInteractive.registerObserver(new LabirynthObserverImpl());
        labyrinthSolveInteractive.registerObserver(new LabirynthObserverSecondImpl());
        labyrinthSolveInteractive.registerObserver(new LabirynthObserverThirdImpl());
        labyrinthSolveInteractive.solve();
        */

        //Labyrinth labyrinth=new LabyrinthListImpl("input.txt");
        //System.out.print(labyrinth+ " " + labyrinth.getFinishCell() + " " + labyrinth.getStartCell());
        //Labyrinth labyrinth1=new LabyrinthMatrixImpl("input.txt");
        //System.out.print("\n"+ labyrinth1.getFinishCell() + " " + labyrinth1.getStartCell());
    }
}
