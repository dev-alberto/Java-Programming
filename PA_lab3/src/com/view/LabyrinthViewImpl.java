package com.view;


import com.Labyrinth;


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
        for(int i=0;i<labyrinth.getColumnCount();i++){
            labView+="|";
            for(int j=0;j<labyrinth.getRowCount();j++){
                if(labyrinth.isFreeAt(i,j)) {
                    labView += " |";
                }
                else if(labyrinth.isWallAt(i,j)){
                    labView+="*|";
                }
                else if(labyrinth.getStartCell()[0]==i && labyrinth.getStartCell()[1]==j ){
                    labView+="S|";
                }
                else if(labyrinth.getFinishCell()[0]==i && labyrinth.getFinishCell()[1]==j){
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

