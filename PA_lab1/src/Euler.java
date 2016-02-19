/**
 * Created by Marta&Alberto on 2/19/2016.
 */


import java.lang.reflect.Array;
import java.util.*;
public class Euler {
    private static int size = 0;
    private static char [][][] grecoLatinSquare = new char[3][3][2];

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

    public static void main(String [] args) {
        ConstructFirstLine(args);
        create();
        System.out.println(Arrays.deepToString(grecoLatinSquare));
        StringBuilder a;
    }
}
