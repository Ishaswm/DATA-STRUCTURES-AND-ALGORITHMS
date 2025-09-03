import java.util.*;

public class SpiralMatrixRecursion {

    public static void printSpiral(int[][] matrix, int top, int bottom, int left, int right) {
        if (top > bottom || left > right) {
            return; // Base case: no more elements
        }

        // Step 1: Print top row
        for (int i = left; i <= right; i++) {
            System.out.print(matrix[top][i] + " ");
        }

        // Step 2: Print right column
        for (int i = top + 1; i <= bottom; i++) {
            System.out.print(matrix[i][right] + " ");
        }

        // Step 3: Print bottom row (only if more than one row left)
        if (top < bottom) {
            for (int i = right - 1; i >= left; i--) {
                System.out.print(matrix[bottom][i] + " ");
            }
        }

        // Step 4: Print left column (only if more than one column left)
        if (left < right) {
            for (int i = bottom - 1; i > top; i--) {
                System.out.print(matrix[i][left] + " ");
            }
        }

        // Recursive call for inner matrix
        printSpiral(matrix, top + 1, bottom - 1, left + 1, right - 1);
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Spiral order of matrix1:");
        printSpiral(matrix1, 0, matrix1.length - 1, 0, matrix1[0].length - 1);

        System.out.println("\n\nSpiral order of matrix2:");
        printSpiral(matrix2, 0, matrix2.length - 1, 0, matrix2[0].length - 1);
    }
}

