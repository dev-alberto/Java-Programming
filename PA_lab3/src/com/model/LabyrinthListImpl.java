package com.model;


import com.Pair;

import java.io.*;
import java.util.*;
import java.util.List;

public class LabyrinthListImpl implements Labyrinth {
    List<Pair>occupiedCells=new ArrayList<>();
    Pair pair=new Pair();
    Pair start=new Pair();
    Pair finish=new Pair();
    public LabyrinthListImpl(String filename) throws IOException
    {
        File file=new File(filename);
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        int i=0;
        int index=0;
        while ((line=bufferedReader.readLine())!=null)
        {
            String[] strings=line.split(" ");
            for(int j=0;j<strings.length;j++){
                int number=Integer.parseInt(strings[j]);
                pair.column=strings.length;
                if(number==1) {
                    Pair p = new Pair(i, j);
                    //System.out.println("\n" + k + " " + i + " " + j + " " + p);
                    occupiedCells.add(index,p);
                    index++;
                }
                else if(number==-1){
                    this.start.row=i;
                    this.start.column=j;
                }
                else if(number==2){
                    this.finish.row=i;
                    this.finish.column=j;
                }
            }
            i++;
        }
        pair.row=i;
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
        for(Pair aux:occupiedCells){
            if(aux.equals(p)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isWallAt(Pair p) {
        for(Pair aux:occupiedCells){
            if(aux.equals(p)){
                return true;
            }
        }
        return false;
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
    }

    @Override
    public int getValue(Pair p) {
        return 0;
    }

    @Override
    public boolean outOfBound(Pair p) {
        return p.row<0||p.row>=getRowCount() ||p.column<0 ||p.column>=getColumnCount();
    }
}
