package com.company;


import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static int size = 0;
    /*
        grecoLatinSquare[i][j][0] is a latin letter
        grecoLatinSquare[i][j][0] is a greek letter or number
    */
    private static final int  SIZE = 5;
    private static char [][][] grecoLatinSquare = new char[SIZE][SIZE][2];
    private static long numerOfGrecoLatinSquare = 0;
    private static Boolean [][] latinLettersUsedForEachRow = new Boolean[SIZE][SIZE];
    private static Boolean [][] latinLettersUsedForEachColum = new Boolean[SIZE][SIZE];
    private static Boolean [][] grecoLettersUsedForEachRow = new Boolean[SIZE][SIZE];
    private static Boolean [][] grecoLettersUsedForEachColum = new Boolean[SIZE][SIZE];
    private static Boolean [][] latinGrecoPair = new Boolean[SIZE][SIZE];

    private static void circularPermutationToLeft(int line, int character) {
        char auxiliary = grecoLatinSquare[line - 1][0][character];
        for (int j = 0; j < size -1 ; ++j) {
            grecoLatinSquare[line][j][character] = grecoLatinSquare[line-1][j + 1][character];
        }
        grecoLatinSquare[line][size - 1][character] = auxiliary;
    }

    private static void circularPermutationToRight(int line, int character) {
        char auxiliary = grecoLatinSquare[line - 1][size - 1][character];
        for (int j = 1; j < size; ++j) {
            grecoLatinSquare[line][j][character] = grecoLatinSquare[line - 1][j - 1][character];
        }
        grecoLatinSquare[line][0][character] = auxiliary;
    }

    public static void create() {
        for (int i = 1; i < size; ++i) {
            circularPermutationToRight(i, 1);
            circularPermutationToLeft(i, 0);
        }

    }

    public static void ConstructFirstLine(String [] args) {
        size = Integer.parseInt(args[0]);
        for (int j = 0; j <size; ++j) {
            grecoLatinSquare[0][j][0] = args[j + 1].charAt(0);
            grecoLatinSquare[0][j][1] = args[size + 1 + j].charAt(0);
        }
    }

    private static int get_colum(int h) {
        return h % size;
    }

    private static int get_row(int h) {
        return h / size;
    }

    private static void InitializeMatrixes() {
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                latinLettersUsedForEachRow[i][j] = false;
                latinLettersUsedForEachColum[i][j] = false;
                grecoLettersUsedForEachRow[i][j] = false;
                grecoLettersUsedForEachColum[i][j] = false;
                latinGrecoPair[i][j] = false;
            }
        }
    }

    private static void NumberGrecoLatinSquares(int h) {
        if (h == size * size) {
            ++numerOfGrecoLatinSquare;
        }
        else {
            int row = get_row(h);
            int colum = get_colum(h);
            for (int latin = 0; latin < size; ++latin) {
                if (!latinLettersUsedForEachRow[row][latin] && !latinLettersUsedForEachColum[colum][latin]) {

                    latinLettersUsedForEachRow[row][latin] = true;
                    latinLettersUsedForEachColum[colum][latin] = true;

                    for (int greco = 0; greco < size; ++greco) {
                        if (!grecoLettersUsedForEachRow[row][greco] && !grecoLettersUsedForEachColum[colum][greco]) {
                            grecoLettersUsedForEachRow[row][greco] = true;
                            grecoLettersUsedForEachColum[colum][greco] =true;

                            if (!latinGrecoPair[latin][greco]) {
                                latinGrecoPair[latin][greco] = true;
                                NumberGrecoLatinSquares(h + 1);
                                latinGrecoPair[latin][greco] = false;
                            }

                            grecoLettersUsedForEachRow[row][greco] = false;
                            grecoLettersUsedForEachColum[colum][greco] = false;
                        }
                    }

                    latinLettersUsedForEachRow[row][latin] = false;
                    latinLettersUsedForEachColum[colum][latin] = false;
                }
            }
        }

    }

    public static void main(String [] args) {
        ConstructFirstLine(args);
        create();
        System.out.println(Arrays.deepToString(grecoLatinSquare));
        InitializeMatrixes();
        NumberGrecoLatinSquares(0);
        System.out.println(numerOfGrecoLatinSquare);
    }
}
