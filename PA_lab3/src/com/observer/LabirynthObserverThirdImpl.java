package com.observer;

import com.controller.LabyrinthSolver;
import com.sun.glass.ui.SystemClipboard;
import com.sun.javafx.binding.BidirectionalBinding;

/**
 * Created by Diana on 06.03.2016.
 */
public class LabirynthObserverThirdImpl implements LabyrinthObserver {
    LabyrinthSolver labyrinthSolver;

    public LabirynthObserverThirdImpl(LabyrinthSolver labyrinthSolver) {
        this.labyrinthSolver = labyrinthSolver;
    }
    /**
     * Processes moves and prints out solution
     */
    @Override
    public void notifyChange() {
        System.out.println("All the moves needed to reach current cell are: ");
        for (String move : labyrinthSolver.getAllMoves()) {
            System.out.print(move + " ");
        }
        System.out.println();
    }
}
