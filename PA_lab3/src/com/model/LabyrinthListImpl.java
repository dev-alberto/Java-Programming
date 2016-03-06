package com.model;


import com.Pair;

import java.io.*;
import java.util.*;
import java.util.List;

public class LabyrinthListImpl implements Labyrinth {
    List<Pair> occupiedCells;
    Pair pair;
    Pair start;
    Pair finish;
    public LabyrinthListImpl(String filename) throws IOException {
        pair=new Pair(0, 0);
        start=new Pair(-1, -1);
        finish=new Pair(-1, -1);
        occupiedCells = new ArrayList<>();

        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(filename)));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] strings=line.split(" ");
            for(int j = 0; j < strings.length; j++){
                int number=Integer.parseInt(strings[j]);
                switch (number) {
                    case 1: occupiedCells.add(new Pair(pair.row, j)); break;
                    case 2: finish = new Pair(pair.row, j); break;
                    case -1: start = new Pair(pair.row, j); break;
                }
            }
            ++pair.row;
            pair.column = strings.length;
        }
    }

    public String toString(){
        return Arrays.toString(occupiedCells.toArray());
    }

    @Override
    public int getRowCount() {
        return pair.row;
    }

    @Override
    public int getColumnCount() {
        return pair.column;
    }

    @Override
    public boolean isFreeAt(Pair p) {
        return !occupiedCells.contains(p);
    }

    @Override
    public boolean isWallAt(Pair p) {
        return occupiedCells.contains(p);
    }

    @Override
    public Pair getStartCell() {
        return start;
    }

    @Override
    public Pair getFinishCell() {
        return finish;
    }

    @Override
    public void setValue(Pair p, int value) {
        if (occupiedCells.contains(p)) {
            occupiedCells.remove(p);
        }

        switch (value) {
            case 1: occupiedCells.add(new Pair(pair.row, p.column));
            case 2: finish = new Pair(pair.row, p.column);
            case -1: start = new Pair(pair.row, p.column);
        }
    }

    @Override
    public int getValue(Pair p) {
        if (start.equals(p)) {
            return -1;
        }
        if (finish.equals(p)) {
            return 2;
        }
        if (occupiedCells.contains(p)) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean outOfBound(Pair p) {
        return p.row<0 || p.row >= getRowCount() || p.column < 0 || p.column >= getColumnCount();
    }
}
