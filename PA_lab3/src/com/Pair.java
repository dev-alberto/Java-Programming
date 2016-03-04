
package com;

public class Pair {
   public int row;
   public int column;
    public Pair(){
        this.row=0;
        this.column=0;
    }
    public Pair(int row,int column){
        this.row=row;
        this.column=column;
    }
    public boolean equals(Pair pair)
    {
        return this.row==pair.row && this.column==pair.column;

    }
    public String toString(){
        return (row + " " + column);
    }
}
