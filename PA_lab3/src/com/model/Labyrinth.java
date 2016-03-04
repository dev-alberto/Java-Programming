package com.model;


import com.Pair;

public interface Labyrinth {
    int getRowCount();
    int getColumnCount();
    boolean isFreeAt(Pair p);
    boolean isWallAt(Pair p);
     Pair getStartCell();
     Pair getFinishCell();
    public void setValue(Pair p,int value);
    public int getValue(Pair p);
    boolean outOfBound(Pair p);
}
