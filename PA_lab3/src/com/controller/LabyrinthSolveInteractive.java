package com.controller;


import com.model.Labyrinth;
import com.Pair;
import com.view.LabyrinthView;
import com.view.LabyrinthViewImpl;

import java.util.Scanner;

public class LabyrinthSolveInteractive implements LabyrinthSolver {
    Labyrinth labyrinth;
    LabyrinthView labyrinthView;
    private Pair start=new Pair();
    private Pair finish=new Pair();
    private Pair currentPosition=new Pair();

    public LabyrinthSolveInteractive(Labyrinth labyrinth,LabyrinthView labyrinthView)
    {
        this.labyrinth=labyrinth;
        this.labyrinthView=labyrinthView;
        this.start=labyrinth.getStartCell();
        this.finish=labyrinth.getFinishCell();
        this.currentPosition=labyrinth.getStartCell();
    }
    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth=labyrinth;
    }

    @Override
    public Labyrinth getLabirinth() {
        return labyrinth;
    }

    @Override
    public void nextCellToExplore(Pair pair) {
        LabyrinthView labyrinthView1=new LabyrinthViewImpl(labyrinth);
        if(labyrinth.isFreeAt(pair)) {
            currentPosition.row=pair.row;
            currentPosition.column=pair.column;
            labyrinth.setValue(pair,7);
            labyrinthView1.constructLabyrinth();
            System.out.println(labyrinthView1);
        }
        else if(labyrinth.getValue(pair)==2){
            currentPosition.row=pair.row;
            currentPosition.column=pair.column;
            System.out.print("You have escaped the bloody maze ");
        }

        else if(labyrinth.isWallAt(pair)){
            System.out.print("Wall at " +pair.row + " " + pair.column);
        }
        else if(labyrinth.outOfBound(pair))
        {
            System.out.print("Wrong input, out of bounds");
        }
    }
    @Override
    public void solve(){
        Scanner scanner=new Scanner(System.in);
        String move;
        System.out.println("You are at " + start + " and the finish is at " + finish);
        while(true) {
            move = scanner.nextLine();
            if (move.equals("d")) {
                Pair aux=new Pair(currentPosition.row+1,currentPosition.column);
              nextCellToExplore(aux);
                if (winner(currentPosition)) break;
                System.out.print(currentPosition);
            } else if (move.equals("u")) {
                Pair aux=new Pair(currentPosition.row-1,currentPosition.column);
                nextCellToExplore(aux);
                if (winner(currentPosition)) break;
                System.out.print(currentPosition);
            } else if (move.equals("r")) {
                Pair aux=new Pair(currentPosition.row,currentPosition.column +1);
                nextCellToExplore(aux);
                if (winner(currentPosition)) break;
                System.out.print(currentPosition);
            } else if (move.equals("l")) {
                Pair aux=new Pair(currentPosition.row,currentPosition.column -1);
                nextCellToExplore(aux);
                if (winner(currentPosition)) break;
                System.out.print(currentPosition);
            }
            else if(move.equals("exit")){
                break;
            }
            else System.out.println("Wrong move pal ");
        }

    }

    public boolean winner(Pair p){
        return labyrinth.getValue(p)==2;
    }

}
