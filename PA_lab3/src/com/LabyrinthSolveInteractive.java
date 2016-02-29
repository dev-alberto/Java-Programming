package com;


import java.util.Arrays;
import java.util.Scanner;

public class LabyrinthSolveInteractive implements LabyrinthSolver {
    Labyrinth labyrinth;
    //create view instance, and make this shit truly interactive
    private int[] start=new int[2];
    private int[] finish=new int[2];
    private int[] currentPosition=new int[2];
    @Override
    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth=labyrinth;
        System.arraycopy(labyrinth.getStartCell(),0,start,0,2);
        System.arraycopy(labyrinth.getStartCell(),0,currentPosition,0,2);
        System.arraycopy(labyrinth.getFinishCell(),0,finish,0,2);
    }

    @Override
    public Labyrinth getLabirinth() {
        return labyrinth;
    }

    @Override
    public void nextCellToExplore(int row, int column) {
        if(labyrinth.isFreeAt(row,column)) {
            currentPosition[0] = row;
            currentPosition[1] = column;
            labyrinth.setValue(row, column,0);
        }
        else if(labyrinth.getValue(row,column)==2){
            currentPosition[0] = row;
            currentPosition[1] = column;
            System.out.print("You have escaped the bloody maze ");
        }

        else if(labyrinth.isWallAt(row,column)){
            System.out.print("Wall at " +row + column);
        }
        else if(labyrinth.outOfBound(row,column))
        {
            System.out.print("Wrong input, out of bounds");
        }
    }
    @Override
    public void solve(){
        Scanner scanner=new Scanner(System.in);
        String move;
        System.out.println("You are at " + Arrays.toString(currentPosition) + " and the finish is at " + Arrays.toString(finish));
        while(true) { //make switch statement, for fuck sake...
            move = scanner.nextLine();
            if (move.equals("d")) {
                nextCellToExplore(currentPosition[0] + 1, currentPosition[1]);
                if (winner(currentPosition)) break;
                System.out.print(Arrays.toString(currentPosition));
            } else if (move.equals("u")) {
                nextCellToExplore(currentPosition[0] - 1, currentPosition[1]);
                if (winner(currentPosition)) break;
                System.out.print(Arrays.toString(currentPosition));
            } else if (move.equals("r")) {
                nextCellToExplore(currentPosition[0], currentPosition[1] + 1);
                if (winner(currentPosition)) break;
                System.out.print(Arrays.toString(currentPosition));
            } else if (move.equals("l")) {
                nextCellToExplore(currentPosition[0], currentPosition[1] - 1);
                if (winner(currentPosition)) break;
                System.out.print(Arrays.toString(currentPosition));
            } else System.out.println("Wrong move pal ");
        }
    }

    public boolean winner(int[]aux){
        return labyrinth.getValue(aux[0],aux[1])==2;
    }

}
