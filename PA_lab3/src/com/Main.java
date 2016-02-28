package com;


import com.view.LabyrinthSecondViewImpl;
import com.view.LabyrinthViewImpl;

import java.io.IOException;

public class Main {
    public static void main(String [] args)  throws IOException
    {
        LabyrinthMatrixImpl labyrinthMatrix = new LabyrinthMatrixImpl("input.txt");
       // System.out.println(labyrinthMatrix);
        //System.out.println(labyrinthMatrix.isWallAt(0,3));
        LabyrinthViewImpl labyrinthView=new LabyrinthViewImpl(labyrinthMatrix);
        labyrinthView.constructLabyrinth();
        LabyrinthSecondViewImpl labyrinthSecondView=new LabyrinthSecondViewImpl(labyrinthMatrix);
        labyrinthSecondView.constructLabyrinth();
        //System.out.println(labyrinthView);
        System.out.println(labyrinthSecondView);
    }
}
