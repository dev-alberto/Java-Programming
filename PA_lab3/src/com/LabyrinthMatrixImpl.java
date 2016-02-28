package com;
import java.io.*;
import java.util.Arrays;

public class LabyrinthMatrixImpl implements Labyrinth {
    private int rowNr;
    private int columnNr;
    private int[][] labyrinthMatrix=new int[50][50];
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
                columnNr=strings.length;
            }
            i++;
        }
        rowNr=i;
        bufferedReader.close();
    }
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
        if(labyrinthMatrix[row][column]==0)
            return true;
        else return false;
    }

    @Override
    public boolean isWallAt(int row, int column) {
       if(labyrinthMatrix[row][column]==1)
           return true;
        else return false;
    }

    @Override
    public int[] getStartCell() {
        int[] aux=new int[2];
        for(int i=0;i<rowNr;i++) {
            for (int j = 0; j < columnNr; j++) {
                if(labyrinthMatrix[i][j]==-1) {
                    aux[0] = i;
                    aux[1] = j;
                    return aux;
                }
            }
        }
        return null;
    }

    @Override
    public int[] getFinishCell() {
        int[] aux=new int[2];
        for(int i=0;i<rowNr;i++) {
            for (int j = 0; j < columnNr; j++) {
                if(labyrinthMatrix[i][j]==2) {
                    aux[0] = i;
                    aux[1] = j;
                    return aux;
                }
            }
        }
        return null;
    }

    @Override
    public boolean outOfBound(int row, int column){
        if(row<0||row>=rowNr ||column<0 ||column>=columnNr)
        return true;
        return false;
    }
    public String toString(){
        return "Start cell" + Arrays.toString(getStartCell()) + "Finish cell" + Arrays.toString(getFinishCell());
    }
}
