package com.view;


import com.controller.LabyrinthSolveInteractive;
import com.controller.LabyrinthSolver;
import com.model.Labyrinth;
import com.Pair;
import com.sun.javafx.scene.control.skin.LabeledImpl;


public class LabyrinthViewImpl implements LabyrinthView {
    private LabyrinthSolver labyrinthSolver;
    private String labView="";

    public LabyrinthViewImpl(LabyrinthSolver labyrinthSolver){
        this.labyrinthSolver=labyrinthSolver;
    }
    public LabyrinthViewImpl() {}


    @Override
    public void setLabyrinth(LabyrinthSolver labyrinthSolver) {
        this.labyrinthSolver=labyrinthSolver;
    }

    @Override
    public LabyrinthSolver getLabyrinth() {
        return labyrinthSolver;
    }

    public void constructLabyrinth() {
       // System.out.print("\n" + labyrinth.getFinishCell().row);
        for(int i=0;i < labyrinthSolver.getLabirinth().getRowCount();i++){
            labView+="|";
            for(int j=0;j < labyrinthSolver.getLabirinth().getColumnCount();j++){
                Pair p=new Pair(i,j);
                if(labyrinthSolver.getLabirinth().getStartCell().equals(p) ) {
                    labView+="S|";
                }
                else if(labyrinthSolver.getLabirinth().getFinishCell().equals(p)) {
                    labView+="F|";
                }
                else if(labyrinthSolver.isVisited(p)) {
                    labView+="X|";
                }
                else if(labyrinthSolver.getLabirinth().isFreeAt(p)) {
                    labView += " |";
                }
                else if(labyrinthSolver.getLabirinth().isWallAt(p)) {
                    labView += "*|";
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

