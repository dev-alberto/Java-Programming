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
    @Override
    public void notify(LabyrinthSolver labyrinthSolver) {
        LabyrinthView labyrinthView = new LabyrinthSecondViewImpl(labyrinthSolver);
        labyrinthView.constructLabyrinth();
        System.out.println(labyrinthView.toString());
    }
}
