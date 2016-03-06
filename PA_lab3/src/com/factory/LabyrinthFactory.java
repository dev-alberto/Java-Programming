package com.factory;


import com.model.Labyrinth;
import com.model.LabyrinthListImpl;
import com.model.LabyrinthMatrixImpl;

import java.io.IOException;

public class LabyrinthFactory {

    public static Labyrinth buildLabyrinth(LabyrinthType labyrinthType) throws IOException{
        switch (labyrinthType){
            case MATRIX: return new LabyrinthMatrixImpl("input.txt");
            case LIST: return new LabyrinthListImpl("input.txt");
            default: System.out.print("Nu such Labyrinth type exists ");
                      return null;
        }
    }
}
