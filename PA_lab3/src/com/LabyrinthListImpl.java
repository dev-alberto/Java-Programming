package com;


import java.util.ArrayList;

public class LabyrinthListImpl implements Labyrinth {
    private int rowNr;
    private int columnNr;
    ArrayList<Integer> labyrinthList=new ArrayList<>(); // ??? asta vrea?
    @Override
    public int getRowCount() {
        return rowNr;
    }

    @Override
    public int getColumnCount() {
        return columnNr;
    }

    @Override
    public boolean isFreeAt(int row, int column) {
        return false;
    }

    @Override
    public boolean isWallAt(int row, int column) {
        return false;
    }

    @Override
    public int[] getStartCell() {
        return new int[0];
    }

    @Override
    public int[] getFinishCell() {
        return new int[0];
    }
    @Override
    public boolean outOfBound(int row, int column) {
        return false;
    }
}
