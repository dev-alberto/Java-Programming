package com.observer;

import com.controller.LabyrinthSolver;
import com.view.LabyrinthView;
import com.view.LabyrinthViewImpl;

import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

public class LabirynthObserverImpl implements LabyrinthObserver {
    LabyrinthSolver labyrinthSolver;

    public LabirynthObserverImpl(LabyrinthSolver labyrinthSolver) {
        this.labyrinthSolver = labyrinthSolver;
    }

    /**
     * Uses the view to print out labyrinth matrix
     */
    @Override
    public void notifyChange() {
        LabyrinthView labyrinthView = new LabyrinthViewImpl(labyrinthSolver);
        labyrinthView.constructLabyrinth();
        System.out.println(labyrinthView.toString());
    }
}
