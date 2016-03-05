package com.company;

public class Main {

    public static void main(String[] args) {
	    Problem P = new Problem();
        P.readInstance();
        P.computeStableMatching();
        P.writeSolution();
    }
}
