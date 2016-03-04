package com;


import com.controller.LabyrinthSolveInteractive;
import com.model.Labyrinth;
import com.model.LabyrinthMatrixImpl;
import com.view.LabyrinthView;
import com.view.LabyrinthViewImpl;

import java.io.IOException;

public class Main {
    public static void main(String [] args)  throws IOException
    {
       Labyrinth labyrinthMatrix = new LabyrinthMatrixImpl("input.txt");
       LabyrinthView labyrinthView=new LabyrinthViewImpl(labyrinthMatrix);
        LabyrinthSolveInteractive labyrinthSolveInteractive=new LabyrinthSolveInteractive(labyrinthMatrix,labyrinthView);
        labyrinthSolveInteractive.solve();

        //Labyrinth labyrinth=new LabyrinthListImpl("input.txt");
        //System.out.print(labyrinth+ " " + labyrinth.getFinishCell() + " " + labyrinth.getStartCell());
        //Labyrinth labyrinth1=new LabyrinthMatrixImpl("input.txt");
        //System.out.print("\n"+ labyrinth1.getFinishCell() + " " + labyrinth1.getStartCell());
    }
}
