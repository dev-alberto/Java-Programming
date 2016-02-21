/**
 * Created by Marta&Alberto on 2/19/2016.
 */


import java.lang.reflect.Array;
import java.util.*;
public class Euler {
    private static int size = 0;
    /*
        grecoLatinSquare[i][j][0] is a latin letter
        grecoLatinSquare[i][j][0] is a greek letter or number
    */
    private static final int  SIZE = 4;
    private static char [][][] grecoLatinSquare = new char[SIZE][SIZE][2];
    private static long numerOfGrecoLatinSquare = 0;
    private static Boolean [][] latinLettersUsedForEachRow = new Boolean[SIZE][SIZE];
    private static Boolean [][] latinLettersUsedForEachColum = new Boolean[SIZE][SIZE];
    private static Boolean [][] grecoLettersUsedForEachRow = new Boolean[SIZE][SIZE];
    private static Boolean [][] grecoLettersUsedForEachColum = new Boolean[SIZE][SIZE];
    private static Boolean [][] latinGrecoPair = new Boolean[SIZE][SIZE];

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

    public static void create() {
        for (int i = 1; i < size; ++i) {
            circularPermutationToRight(grecoLatinSquare,i, 1,size);
            circularPermutationToLeft(grecoLatinSquare,i, 0,size);
        }
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.print(grecoLatinSquare[i][j][k] + " ");
                }
            }
            System.out.println();
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
                            grecoLettersUsedForEachColum[colum][greco] = true;

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
    public static void printExample() {
        char[][][] example = new char[3][3][2];
        for (int j = 0; j < 3; j++) {
            example[0][j][0] = (char) ('A' + j);
        }
        example[0][0][1]='\u03B1';
        example[0][1][1]= (char)  ('\u03B1' +2);
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

    public static void ConstructFirstLine(String [] args) {
        size = Integer.parseInt(args[0]);
        if (size<3)
        {
            System.err.print("Nu exista patrate greco-romane de dimensiunea dorita");
        }
        for (int j = 0; j <size; ++j) {
            grecoLatinSquare[0][j][0] = args[j + 1].charAt(0);
            grecoLatinSquare[0][j][1] = args[size + 1 + j].charAt(0);
        }
    }


    public static void main(String [] args) {
        int start=(int) System.currentTimeMillis();
        ConstructFirstLine(args);
        System.out.println("Greco-latin square from given example: \n" );
        printExample();
        System.out.println("One greco-latin square of requested size: \n" );
        create();
        System.out.println("Trying to count here all of them, be patient...\n");
        InitializeMatrixes();
        NumberGrecoLatinSquares(0);
        System.out.println(numerOfGrecoLatinSquare);
        System.out.println("Running time= " + ((int) System.currentTimeMillis() - start) + "\n");
    }
}
