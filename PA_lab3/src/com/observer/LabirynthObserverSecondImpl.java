package com.observer;

import com.controller.LabyrinthSolver;
import com.view.LabyrinthSecondViewImpl;
import com.view.LabyrinthView;
import com.view.LabyrinthViewImpl;

import java.util.Stack;

/**
 * Created by Diana on 06.03.2016.
 */
public class LabirynthObserverSecondImpl implements LabyrinthObserver {
    LabyrinthSolver labyrinthSolver;

    public LabirynthObserverSecondImpl(LabyrinthSolver labyrinthSolver) {
        this.labyrinthSolver = labyrinthSolver;
    }

    /**
     * Uses view to print out second type of view
     */
    @Override
    public void notifyChange() {
        LabyrinthView labyrinthView = new LabyrinthSecondViewImpl(labyrinthSolver);
        labyrinthView.constructLabyrinth();
        System.out.println(labyrinthView.toString());
    }
}
