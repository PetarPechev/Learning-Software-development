package com.telerikacademy.core;

import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        String input = "000111010";

        // Generation #0
        int generationNumber = 0;
        int[] generation0 = convertToArray(input);
        printGeneration(generation0, generationNumber);

        // Generation #1 Test
        generationNumber++;
        int[] generation1 = getNextGeneration(generation0);
        printGeneration(generation1, generationNumber);
        validateGeneration(generation1, generationNumber, "010111111");

        // Generation #2 Test
        generationNumber++;
        int[] generation2 = getNextGeneration(generation1);
        printGeneration(generation2, generationNumber);
        validateGeneration(generation2, generationNumber, "111000101");

        // Generation #3 Test
        generationNumber++;
        int[] generation3 = getNextGeneration(generation2);
        printGeneration(generation3, generationNumber);
        validateGeneration(generation3, generationNumber, "010101000");

        // Generation #4 Test
        generationNumber++;
        int[] generation4 = getNextGeneration(generation3);
        printGeneration(generation4, generationNumber);
        validateGeneration(generation4, generationNumber, "010010000");

        // Generation #5 Test
        generationNumber++;
        int[] generation5 = getNextGeneration(generation4);
        String generation5Str = convertToString(generation5);
        printGeneration(generation5Str, generationNumber);
        validateGeneration(generation5, generationNumber, "000000000");
    }

    /**
     * This method converts a String into an array of digits.<br />
     * For example "111000101" will become {1,1,1,0,0,0,1,0,1}
     *
     * @param str The input String
     * @return A one dimensional array of integers.
     */
    static int[] convertToArray(String str) {
        return Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
    }

    /**
     * This method converts a one dimensional array of integers into a String.<br/>
     * For example {1,1,1,0,0,0,1,0,1} will become "111000101"
     *
     * @param array A one-dimensional array of integers.
     * @return String
     */
    static String convertToString(int[] array) {
        return Arrays.toString(array).replaceAll("[\\[\\], ]", "");
    }

    /**
     * This method converts a two-dimensional array of integers into a one-dimensional array of integers.
     * For example:
     * 1 1 1
     * 0 0 0
     * 1 0 1
     * will become {1,1,1,0,0,0,1,0,1}
     *
     * @param matrix A two-dimensional array of integers.
     * @return A one-dimensional array of integers.
     */
    static int[] convertToArray(int[][] matrix) {
        int[] resultMatrix = new int[matrix.length + matrix[0].length];
        int index = 0;

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                resultMatrix[index] = anInt;
                index++;
            }
        }

        return resultMatrix;
    }

    /**
     * This method converts a one-dimensional array of integers into a two-dimensional array of integers.
     * For example {1,1,1,0,0,0,1,0,1} will become:
     * 1 1 1
     * 0 0 0
     * 1 0 1
     *
     * @param array A one-dimensional array of integers.
     * @return A two-dimensional array of integers.
     */
    static int[][] convertToMatrix(int[] array) {
        int size = (int)Math.sqrt(array.length);
        int index = 0;

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = array[index];
                index++;
            }
        }

        return matrix;
    }

    /**
     * This method prints the two-dimensional version of a String.
     * For example, "111000101" will be displayed in the Console as:
     * Generation #1
     * 1 1 1
     * 0 0 0
     * 1 0 1
     *
     * @param generation       The String representation of the generation of cells.
     * @param generationNumber The number of the generation.
     */
    static void printGeneration(String generation, int generationNumber) {
        int[][] matrix = convertToMatrix(convertToArray(generation));

        System.out.println("Generation #" + generationNumber);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

    /**
     * This method prints the two-dimensional version of a one-dimensional array.
     * For example, {1,1,1,0,0,0,1,0,1} will be displayed in the Console as:
     * Generation #1
     * 1 1 1
     * 0 0 0
     * 1 0 1
     *
     * @param generation       An array representing the generation of cells to mutate.
     * @param generationNumber The number of the generation.
     */
    static void printGeneration(int[] generation, int generationNumber) {
        int[][] matrix = convertToMatrix(generation);

        System.out.println("Generation #" + generationNumber);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

    /**
     * This method takes a one-dimensional array representation of a generation and mutates (transforms) it into a one-dimensional array representation of the next generation.
     *
     * @param generation A one-dimensional array representing the generation of cells to mutate.
     * @return A one-dimensional array representing the generation of cells after mutation.
     */
    static int[] getNextGeneration(int[] generation) {
        throw new UnsupportedOperationException("Mutating one-dimensional generation is not implemented.");
    }

    /**
     * This method takes a two-dimensional array representation of a generation and mutates (transforms) it into a two-dimensional array representation of the next generation.
     *
     * @param generation A two-dimensional array representing the generation of cells to mutate.
     * @return A two-dimensional array representing the generation of cells after mutation.
     */
    static int[][] getNextGeneration(int[][] generation) {
        int numRows = generation.length;
        int numCols = generation[0].length;
        int[][] nextGen = new int[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int numNeighbors = getAliveNeighborsCount(row, col, generation);

                if (generation[row][col] == 1) { // alive cell
                    if (numNeighbors == 2 || numNeighbors == 3) {
                        nextGen[row][col] = 1; // stays alive
                    } else {
                        nextGen[row][col] = 0; // dies
                    }
                } else { // dead cell
                    if (numNeighbors == 3) {
                        nextGen[row][col] = 1; // comes to life
                    } else {
                        nextGen[row][col] = 0; // stays dead
                    }
                }
            }
        }

        return nextGen;
    }

    /**
     * This method applies the rules of "Game of Life" and returns whether the cell at position [row,column] will be alive in the next generation.
     * Rules of "Game of Life":
     * 1. Any live cell with 0 or 1 live neighbors becomes dead, because of underpopulation.
     * 2. Any live cell with 2 or 3 live neighbors stays alive, because its neighborhood is just right.
     * 3. Any live cell with more than 3 live neighbors becomes dead, because of overpopulation.
     * 4. Any dead cell with exactly 3 live neighbors becomes alive, by reproduction.
     *
     * @param row        The row position of the cell on which the rules are being applied on.
     * @param column     The column position of the cell on which the rules are being applied on.
     * @param generation The two-dimensional array representing the entire generation of cells.
     * @return 0 if the cell will be dead in the next generation; <br/> 1 if the cell will be alive in the next generation;
     */
    static int applyGameRules(int row, int column, int[][] generation) {
        throw new UnsupportedOperationException("Applying the rules of 'Game of Life' on a cell is not implemented.");
    }

    /**
     * Given the position of a cell within the generation this method returns the number of alive neighbors.
     *
     * @param row        The row position of the cell on which the rules are being applied on.
     * @param column     The column position of the cell on which the rules are being applied on.
     * @param generation The two-dimensional array representing the entire generation of cells.
     * @return The number of alive neighbors.
     */
    static int getAliveNeighborsCount(int row, int column, int[][] generation) {
        int numRows = generation.length;
        int numCols = generation[0].length;
        int count = 0;

        // check 8 neighbors
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = row + i;
                int c = column + j;

                // make sure the neighbor is inside the grid
                if (r >= 0 && r < numRows && c >= 0 && c < numCols) {
                    if (generation[r][c] == 1) {
                        count++;
                    }
                }
            }
        }

        // exclude the cell itself
        if (generation[row][column] == 1) {
            count--;
        }

        return count;
    }

    static void validateGeneration(int[] generation, int generationNumber, String expectedGeneration) {
        String generationStr = convertToString(generation);
        String testResult = "PASS";
        if (!generationStr.equals(expectedGeneration)) {
            testResult = "FAIL";
        }
        System.out.printf("Generation #%d Test: %s%n", generationNumber, testResult);
    }
}
