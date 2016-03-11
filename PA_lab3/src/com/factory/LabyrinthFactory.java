package com.factory;


import com.model.Labyrinth;
import com.model.LabyrinthListImpl;
import com.model.LabyrinthMatrixImpl;

import java.io.IOException;

public class LabyrinthFactory {
    /**
     * Method that constructs the type of labyrinth you desire
     * @param labyrinthType type of labyrinth you want created
     * @return
     * @throws IOException
     */
    public static Labyrinth buildLabyrinth(LabyrinthType labyrinthType) throws IOException{
        switch (labyrinthType){
            case MATRIX: return new LabyrinthMatrixImpl("input.txt");
            case LIST: return new LabyrinthListImpl("input.txt");
            default: System.out.print("Nu such Labyrinth type exists ");
                      return null;
        }
    }
}
