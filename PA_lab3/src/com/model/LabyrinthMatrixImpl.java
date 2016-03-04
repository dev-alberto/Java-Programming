package com.model;
import com.Pair;

import java.io.*;
import java.util.Arrays;

public class LabyrinthMatrixImpl implements Labyrinth {

    Pair pair=new Pair();
    private int[][] labyrinthMatrix=new int[5][5];
    public LabyrinthMatrixImpl(String filename) throws IOException
    {
        File file=new File(filename);
     FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        int i=0;
        while ((line=bufferedReader.readLine())!=null)
        {
            String[] strings=line.split(" ");
            for(int j=0;j<strings.length;j++){
                labyrinthMatrix[i][j]=Integer.parseInt(strings[j]);
                pair.column=strings.length;
            }
            i++;
        }
        pair.row=i;
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
       if(labyrinthMatrix[p.row][p.column]==1)
           return true;
        else return false;
    }

    @Override
    public Pair getStartCell() {
        Pair aux=new Pair();
        for(int i=0;i<pair.row;i++) {
            for (int j = 0; j < pair.column; j++) {
                if(labyrinthMatrix[i][j]==-1) {
                    aux.row=i;
                    aux.column = j;
                    return aux;
                }
            }
        }
        return null;
    }

    @Override
    public Pair getFinishCell() {
        Pair aux=new Pair();
        for(int i=0;i<pair.row;i++) {
            for (int j = 0; j < pair.column; j++) {
                if(labyrinthMatrix[i][j]==2) {
                    aux.row=i;
                    aux.column = j;
                    return aux;
                }
            }
        }
        return null;
    }

    @Override
    public boolean outOfBound(Pair p){
       return p.row<0||p.row>=pair.row ||p.column<0 ||p.column>=pair.column;

    }
    public void setValue(Pair p,int value)
    {
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
