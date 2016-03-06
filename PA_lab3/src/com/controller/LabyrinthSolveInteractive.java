package com.controller;


import com.model.Labyrinth;
import com.Pair;
import com.observer.LabyrinthObserver;
import com.view.LabyrinthView;
import com.view.LabyrinthViewImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabyrinthSolveInteractive implements LabyrinthSolver {
    Labyrinth labyrinth;
    private Pair start=new Pair();
    private Pair finish=new Pair();
    private Pair currentPosition=new Pair();
    private boolean [][] visitedCells;
    private List<String> moves;
    private List<LabyrinthObserver> observersList;

    public LabyrinthSolveInteractive(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
        this.start = labyrinth.getStartCell();
        this.finish = labyrinth.getFinishCell();
        this.currentPosition = labyrinth.getStartCell();
        visitedCells = new boolean[labyrinth.getRowCount()][labyrinth.getColumnCount()];
        for (int i = 0; i < labyrinth.getRowCount(); ++i) {
            for (int j = 0; j < labyrinth.getColumnCount(); ++j) {
                visitedCells[i][j] = false;
            }
        }
        moves = new ArrayList<>();
        observersList = new ArrayList<>();
    }
    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth=labyrinth;
    }

    @Override
    public Labyrinth getLabirinth() {
        return labyrinth;
    }

    @Override
    public List<String> getAllMoves() {
        return moves;
    }

    @Override
    public boolean nextCellToExplore(Pair position) {
        if(labyrinth.outOfBound(position)) {
            System.out.println("Wrong input, out of bounds");
            return false;
        }

        if(labyrinth.isFreeAt(position) && !visitedCells[position.row][position.column]) {
            currentPosition = position.clone();
            visitedCells[position.row][position.column] = true;
            notifyObservers();
            return true;
        }

        if(labyrinth.getValue(position)==2) {
            notifyObservers();
            System.out.println("You have escaped the bloody maze ");
            return true;
        }

        if(labyrinth.isWallAt(position)) {
            System.out.println("Wall at " +position.row + " " + position.column);
            return false;
        }

        return true;
    }

    @Override
    public void solve(){
        Scanner scanner=new Scanner(System.in);
        String move;
        System.out.println("You are at " + start + " and the finish is at " + finish);

        while(!winner(currentPosition)) {
            move = scanner.nextLine();
            if (move.equals("exit")) {
                break;
            }
            else if (move.length() == 1) {
                Pair aux = null;
                switch (move.charAt(0)) {
                    case 'D': aux = new Pair(currentPosition.row + 1, currentPosition.column); break;
                    case 'U': aux = new Pair(currentPosition.row - 1, currentPosition.column); break;
                    case 'R': aux = new Pair(currentPosition.row, currentPosition.column + 1); break;
                    case 'L': aux = new Pair(currentPosition.row, currentPosition.column - 1); break;
                    default: System.out.println("Wrong move pal"); break;
                }
                if (aux != null){
                    if (nextCellToExplore(aux)) {
                        moves.add(move);
                    }
                    System.out.println("Current position is " + currentPosition);
                }
            }
            else {
                System.out.println("Wrong move pal");
            }
        }
    }

    @Override
    public boolean isVisited(Pair p) {
        return visitedCells[p.row][p.column];
    }

    public boolean winner(Pair p){
        return labyrinth.getValue(p)==2;
    }

    @Override
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
