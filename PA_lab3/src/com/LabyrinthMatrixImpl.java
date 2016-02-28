package com;


public class LabyrinthMatrixImpl implements Labyrinth {
    private int rowNr;
    private int columnNr;
    private int[][] labyrinthMatrix=new int[50][50];
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
}
