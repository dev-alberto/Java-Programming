package com.view;

import com.model.Labyrinth;
import com.Pair;


public class LabyrinthSecondViewImpl implements LabyrinthView {
    private Labyrinth labyrinth;
    private String labView="";

    public LabyrinthSecondViewImpl(Labyrinth labyrinth){
        this.labyrinth=labyrinth;
    }


    @Override
    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth=labyrinth;
    }

    @Override
    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public void constructLabyrinth()
    {
        for(int i=0;i<labyrinth.getColumnCount();i++){
            labView+="|";
            for(int j=0;j<labyrinth.getRowCount();j++){
                Pair pair=new Pair(i,j);
                if(labyrinth.isFreeAt(pair)) {
                    labView += "♥|";
                }
                else if(labyrinth.isWallAt(pair)){
                    labView+="⚠|";
                }
                else if(labyrinth.getStartCell().row==i && labyrinth.getStartCell().column==j ){
                    labView+="✌|";
                }
                else if(labyrinth.getFinishCell().row==i && labyrinth.getFinishCell().column==j){
                    labView+="♕|";
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
