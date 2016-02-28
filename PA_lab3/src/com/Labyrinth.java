package com;


public interface Labyrinth {
    int getRowCount();
    int getColumnCount();
    boolean isFreeAt(int row,int column);
    boolean isWallAt(int row,int column);
    int[] getStartCell();
    int[] getFinishCell();
}
