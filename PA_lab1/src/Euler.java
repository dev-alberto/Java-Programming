/**
 * Created by Marta&Alberto on 2/19/2016.
 */


import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by Marta&Alberto on 2/19/2016.
 */


import java.lang.reflect.Array;
import java.util.*;
public class Euler {
    private static int size;
    /*
        grecoLatinSquare[i][j][0] is a latin letter
        grecoLatinSquare[i][j][1] is a greek letter or number
    */
    private static final int  SIZE = 5;
    private static char [][][] grecoLatinSquare = new char[SIZE][SIZE][2];
    private static char [] latin = new char[SIZE];
    private static char [] greco = new char[SIZE];
    private static long numerOfGrecoLatinSquare = 0;
    private static Boolean [][] latinLettersUsedForEachRow = new Boolean[SIZE][SIZE];
    private static Boolean [][] latinLettersUsedForEachColum = new Boolean[SIZE][SIZE];
    private static Boolean [][] grecoLettersUsedForEachRow = new Boolean[SIZE][SIZE];
    private static Boolean [][] grecoLettersUsedForEachColum = new Boolean[SIZE][SIZE];
    private static Boolean [][] latinGrecoPair = new Boolean[SIZE][SIZE];

    public static void read(String [] args) {
        size = Integer.parseInt(args[0]);
        if (size == 2)
        {
            System.err.print("Nu exista patrate greco-romane de dimensiunea dorita");
        }
        for (int i = 0; i <size; ++i) {
            latin[i] = args[i + 1].charAt(0);
            greco[i] = args[i + size + 1].charAt(0);
        }
    }

    private static void circularPermutationToLeft(char [][][] gLSquare, int line, int character,int newSize) {
        char auxiliary = gLSquare[line - 1][0][character];
        for (int j = 0; j < newSize -1 ; ++j) {
            gLSquare[line][j][character] = gLSquare[line-1][j + 1][character];
        }
        gLSquare[line][newSize - 1][character] = auxiliary;
    }


    private static void circularPermutationToRight(char [][][] gLSquare,int line, int character,int newSize) {
        char auxiliary = gLSquare[line - 1][newSize - 1][character];
        for (int j = 1; j < newSize; ++j) {
            gLSquare[line][j][character] = gLSquare[line - 1][j - 1][character];
        }
        gLSquare[line][0][character] = auxiliary;
    }

    private static int get_colum(int h) {
        return h % size;
    }

    private static int get_row(int h) {
        return h / size;
    }

    private static void initializeMatrixes() {
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
    private static void numberGrecoLatinSquares(int h) {
        if (h == size * size) {
            ++numerOfGrecoLatinSquare;
        }
        else {
            int row = get_row(h);
            int colum = get_colum(h);
            for (int latin = 0; latin < size; ++latin) {
                if (!latinLettersUsedForEachRow[row][latin] && !latinLettersUsedForEachColum[colum][latin]) {

                    markLatinLetters(row, colum, latin, true);

                    for (int greco = 0; greco < size; ++greco) {
                        if (!grecoLettersUsedForEachRow[row][greco] &&
                                !grecoLettersUsedForEachColum[colum][greco] &&
                                !latinGrecoPair[latin][greco]) {
                            markGrecoLetters(row, colum, greco, true);
                            latinGrecoPair[latin][greco] = true;

                            if (numerOfGrecoLatinSquare == 0) {
                                grecoLatinSquare[row][colum][0] = (char) latin;
                                grecoLatinSquare[row][colum][1] = (char) greco;
                                if (h == size*size - 1) {
                                    printMatrix();
                                }
                            }
                            numberGrecoLatinSquares(h + 1);

                            latinGrecoPair[latin][greco] = false;
                            markGrecoLetters(row, colum, greco, false);
                        }
                    }

                    markLatinLetters(row, colum, latin, false);
                }
            }
        }
    }

    private static void markGrecoLetters(int row, int colum, int greco, boolean value) {
        grecoLettersUsedForEachRow[row][greco] = value;
        grecoLettersUsedForEachColum[colum][greco] = value;
    }

    private static void markLatinLetters(int row, int colum, int greco, boolean value) {
        latinLettersUsedForEachRow[row][greco] = value;
        latinLettersUsedForEachColum[colum][greco] = value;
    }

    public static void printExample() {
        System.out.println("Greco-latin square from given example: \n" );
        char[][][] example = new char[3][3][2];
        for (int j = 0; j < 3; j++) {
            example[0][j][0] = (char) ('A' + j);
        }
        example[0][0][1]='\u03B1';
        example[0][1][1]=  (char) ('\u03B1' +2);
        example[0][2][1]=(char)  ('\u03B1' +1);

        for (int i = 1; i < 3; ++i) {
            circularPermutationToRight(example, i, 1, 3);
            circularPermutationToLeft(example, i, 0, 3);
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.print(example[i][j][k] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                grecoLatinSquare[i][j][0] = latin[grecoLatinSquare[i][j][0]];
                 grecoLatinSquare[i][j][1] = greco[grecoLatinSquare[i][j][1]];
                System.out.print("(" + grecoLatinSquare[i][j][0] + ", " + grecoLatinSquare[i][j][1] + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String [] args) {
        int start=(int) System.currentTimeMillis();
        read(args);
        printExample();
        initializeMatrixes();
        numberGrecoLatinSquares(0);
        System.out.println("Trying to compute the response...\n");
        System.out.println("Final count: " + numerOfGrecoLatinSquare);
        System.out.println("Running time= " + ((int) System.currentTimeMillis() - start) + "\n");
        //for (int i = 0; i < size; ++i) System.out.println(args[i+1+size]);
    }
}