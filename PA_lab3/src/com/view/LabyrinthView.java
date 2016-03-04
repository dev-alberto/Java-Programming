package com.view;


import com.model.Labyrinth;

public interface LabyrinthView {
    void setLabyrinth(Labyrinth labyrinth);
    Labyrinth getLabyrinth();
    void constructLabyrinth();
    String toString();
}
