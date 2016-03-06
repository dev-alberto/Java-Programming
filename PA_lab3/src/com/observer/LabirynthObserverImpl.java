package com.observer;

import com.controller.LabyrinthSolver;
import com.view.LabyrinthView;
import com.view.LabyrinthViewImpl;

import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

public class LabirynthObserverImpl implements LabyrinthObserver {
    @Override
    public void notify(LabyrinthSolver labyrinthSolver) {
        LabyrinthView labyrinthView = new LabyrinthViewImpl(labyrinthSolver);
        labyrinthView.constructLabyrinth();
        System.out.println(labyrinthView.toString());
    }
}
