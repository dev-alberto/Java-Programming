package com.model;
import com.Pair;

import java.io.*;
import java.util.Arrays;

public class LabyrinthMatrixImpl implements Labyrinth {

    Pair pair = new Pair();
    private int[][] labyrinthMatrix = new int[50][50];

    /**
     * Constructor that instantiates a labyrinth represented in matrix form
     * @param filename string or path for the file containing labyrinth matrix
     * @throws IOException
     */

    public LabyrinthMatrixImpl(String filename) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(filename)));
        String line;
        int i = 0;
        while ((line = bufferedReader.readLine()) != null)
        {
            String[] strings = line.split(" ");
            pair.column = strings.length;
            for(int j = 0; j < strings.length; j++){
                labyrinthMatrix[i][j] = Integer.parseInt(strings[j]);
            }
            i++;
        }
        pair.row = i;
        bufferedReader.close();
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
       return  labyrinthMatrix[p.row][p.column]==0;
    }

    @Override
    public boolean isWallAt(Pair p) {
        return labyrinthMatrix[p.row][p.column] == 1;
    }

    /**
     * Returns the Pair that has the value given as a parameter
     * @param value int we want to check
     * @return Pair with specified value
     */
    private Pair getCellWithValue(int value) {
        for(int i = 0; i < pair.row; i++) {
            for (int j = 0; j < pair.column; j++) {
                if(labyrinthMatrix[i][j] == value) {
                    return new Pair(i, j);
                }
            }
        }
        return null;
    }


    @Override
    public Pair getStartCell() {
        return getCellWithValue(-1);
    }


    @Override
    public Pair getFinishCell() {
        return getCellWithValue(2);
    }

    @Override
    public boolean outOfBound(Pair p){
       return p.row < 0 || p.row >= pair.row || p.column < 0 || p.column >= pair.column;

    }


    public void setValue(Pair p,int value) {
        labyrinthMatrix[p.row][p.column]=value;
    }

    public int getValue(Pair p)
    {
        return labyrinthMatrix[p.row][p.column];
    }
    public String toString(){
        return "\n"+ Arrays.deepToString(labyrinthMatrix);
    }
}
