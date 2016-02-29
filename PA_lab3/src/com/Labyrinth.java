package com;


public interface Labyrinth {
    int getRowCount();
    int getColumnCount();
    boolean isFreeAt(int row,int column);
    boolean isWallAt(int row,int column);
    int[] getStartCell();
    int[] getFinishCell();
    public void setValue(int row,int column,int value);
    public int getValue(int row,int column);
    boolean outOfBound(int row,int column);
}
