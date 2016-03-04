package com.view;


import com.model.Labyrinth;
import com.Pair;


public class LabyrinthViewImpl implements LabyrinthView {
    private Labyrinth labyrinth;
    private String labView="";

    public LabyrinthViewImpl(Labyrinth labyrinth){
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
       // System.out.print("\n" + labyrinth.getFinishCell().row);
        for(int i=0;i<labyrinth.getRowCount();i++){
            labView+="|";
            for(int j=0;j<labyrinth.getColumnCount();j++){
                Pair p=new Pair(i,j);
                if(labyrinth.isFreeAt(p)) {
                    labView += " |";
                }
                else if(labyrinth.getValue(p)==7){
                    labView+="X|";
                }
                else if(labyrinth.isWallAt(p)){
                    labView+="*|";
                }
                else if(labyrinth.getStartCell().equals(p) ){
                    labView+="S|";
                }
                else if(labyrinth.getFinishCell().equals(p)){
                    labView+="F|";
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

