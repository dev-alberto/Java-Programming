package com;


import java.io.IOException;

public class Main {
    public static void main(String [] args)  throws IOException
    {
        LabyrinthMatrixImpl labyrinthMatrix = new LabyrinthMatrixImpl("input.txt");
        System.out.print(labyrinthMatrix);
        System.out.print(labyrinthMatrix.isWallAt(0,3));
    }
}
