package com.controller;


import com.model.Labyrinth;
import com.Pair;
import com.observer.LabyrinthObserver;
import com.view.LabyrinthView;
import javafx.collections.transformation.SortedList;

import java.util.*;

public class LabyrinthSolverAutomated implements LabyrinthSolver {
    Labyrinth labyrinth;
    private Pair start;
    private Pair finish;
    private Pair currentPosition;
    private boolean [][] visitedCells;
    private List<String> moves;
    List<LabyrinthObserver> observersList;

    public LabyrinthSolverAutomated(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
        start = labyrinth.getStartCell();
        finish = labyrinth.getFinishCell();
        currentPosition = new Pair(start.row, start.column);
        visitedCells = new boolean[labyrinth.getRowCount()][labyrinth.getColumnCount()];
        fillVisitedCells(false);
        observersList = new ArrayList<>();
        moves = new ArrayList<>();
    }

    private void fillVisitedCells(boolean value) {
        for (int i = 0; i < labyrinth.getRowCount(); ++i) {
            for (int j = 0; j < labyrinth.getColumnCount(); ++j) {
                visitedCells[i][j] = value;
            }
        }
    }

    @Override
    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }


    @Override
    public Labyrinth getLabirinth() {
        return labyrinth;
    }

    @Override
    public boolean nextCellToExplore(Pair p) {
        return false;
    }


    @Override
    public void solve() {
        moves.clear();
        DFS(start.row, start.column);
    }

    @Override
    public List<String> getAllMoves() {
        return moves;
    }

    @Override
    public boolean isVisited(Pair p) {
        return visitedCells[p.row][p.column];
    }

    private void callDFS(Pair position, String move) {
        if (position.row > -1 && position.row < labyrinth.getRowCount() &&
                position.column > -1 && position.column < labyrinth.getColumnCount()) {
            if (!isVisited(position) && (labyrinth.isFreeAt(position) || finish.equals(position))) {
                moves.add(move);
                DFS(position.row, position.column);
                moves.remove(moves.size() - 1);
            }
        }
    }

    private void DFS(int row, int column) {
        if (row == finish.row && column == finish.column) {
            notifyObservers();
        } else {
            visitedCells[row][column] = true;
            //notifyObservers();

            Pair position = new Pair();
            // up
            position.setValues(row - 1, column);
            callDFS(position, "U");

            //down
            position.setValues(row + 1, column);
            callDFS(position, "D");

            //right
            position.setValues(row, column + 1);
            callDFS(position, "R");

            //left
            position.setValues(row, column - 1);
            callDFS(position, "L");

            visitedCells[row][column] = false;
        }
    }

    public void notifyObservers() {
        for (LabyrinthObserver labyrinthObsever : observersList) {
            labyrinthObsever.notify(this);
        }
    }

    @Override
    public void registerObserver(LabyrinthObserver labyrinthObserver) {
        observersList.add(labyrinthObserver);
    }

    public String getStringMoves(){return moves.toString();}

}
