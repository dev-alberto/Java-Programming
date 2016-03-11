package com.company;

public class Main {

    public static void main(String[] args) {
	    Problem problem = new Problem();
        problem.readInstance();
        problem.writeInstance();
        System.out.print("\n");
        problem.computeStableMatching();
        problem.writeSolution();
    }
}
