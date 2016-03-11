package com.view;

import com.controller.LabyrinthSolver;
import com.model.Labyrinth;
import com.Pair;


public class LabyrinthSecondViewImpl implements LabyrinthView {
    private LabyrinthSolver labyrinthSolver;
    private String labView="";

    public LabyrinthSecondViewImpl(LabyrinthSolver labyrinthSolver){
        this.labyrinthSolver=labyrinthSolver;
    }

    @Override
    public void setLabyrinth(LabyrinthSolver labyrinthSolver) {
        this.labyrinthSolver = labyrinthSolver;
    }

    @Override
    public LabyrinthSolver getLabyrinth() {
        return labyrinthSolver;
    }

    public void constructLabyrinth()
    {
        for(int i=0;i<labyrinthSolver.getLabirinth().getColumnCount();i++){
            labView+="|";
            for(int j=0;j<labyrinthSolver.getLabirinth().getRowCount();j++){
                Pair pair=new Pair(i,j);
                if(labyrinthSolver.getLabirinth().getStartCell().equals(pair)){
                    labView+="✌|";
                }
                else if(labyrinthSolver.getLabirinth().getFinishCell().equals(pair)){
                    labView+="♕|";
                }
                else if(labyrinthSolver.getLabirinth().isFreeAt(pair) && !labyrinthSolver.isVisited(pair)) {
                    labView += "♥|";
                }
                else if (labyrinthSolver.isVisited(pair)){
                    labView += "X|";
                }
                else if(labyrinthSolver.getLabirinth().isWallAt(pair)) {
                    labView += "⚠|";
                }
            }
            labView+="\n";
        }
    }

    @Override
    public String toString(){
        return labView;
    }
}
