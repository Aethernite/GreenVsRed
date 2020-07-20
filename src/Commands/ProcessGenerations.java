package Commands;

import Utils.Point;
/**
 * Command that processes the generations of the matrix.
 */
public class ProcessGenerations implements Command {
    private Command parent;
    private boolean[][] matrix;
    private Point coordinates;
    private int generations;

    public ProcessGenerations(Command parent, boolean[][] matrix, Point coordinates,int generations) {
        this.parent = parent;
        this.matrix = matrix;
        this.coordinates = coordinates;
        this.generations = generations;
    }

    @Override
    public Command execute() {
        int result = processGenerations();
        System.out.println(System.lineSeparator() + "Result: " + result);
        return new Exit();
    }

    /**
     * Processes the matrix generations.
     * @return counter of how many times the chosen cell was green
     */
    private int processGenerations() {
        int counter = 0;
        boolean[][] tempMatrix = new boolean[matrix.length][matrix[0].length];
        for(int generation = 0; generation<generations; generation++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (!matrix[i][j]) { //IF RED
                        int greens = getGreens(i, j, matrix);
                        tempMatrix[i][j] = greens == 3 || greens == 6;
                    } else if (matrix[i][j]) { //IF GREEN
                        int greens = getGreens(i, j, matrix);
                        tempMatrix[i][j] = greens == 2 || greens == 3 || greens == 6;
                    }
                }
            }
            if(tempMatrix[coordinates.getRow()][coordinates.getColumn()]){
                counter++;
            }
            matrix = tempMatrix;
            tempMatrix = new boolean[matrix.length][matrix[0].length];
        }
        return counter;
    }

    /**
     * Counts and returns the number of all green cell neighbours.
     *
     * @param i - row of the cell
     * @param j - column of the cell
     * @return number of green cell neighbours
     */
    public static int getGreens(int i, int j, boolean[][] matrix){
        int countGreens = 0;
        //Check Down
        if(i+1<matrix.length){
            if(matrix[i+1][j]){
                countGreens++;
            }
        }
        //Check Up
        if(i-1>=0){
            if(matrix[i-1][j]){
                countGreens++;
            }
        }
        //Check Right
        if(j+1<matrix[0].length){
            if(matrix[i][j+1]){
                countGreens++;
            }
        }
        //Check Left
        if(j-1>=0){
            if(matrix[i][j-1]){
                countGreens++;
            }
        }
        //Check Top Right
        if(i-1>=0 && j+1<matrix[0].length){
            if(matrix[i-1][j+1]){
                countGreens++;
            }
        }
        //Check Top Left
        if(i-1>=0 && j-1>=0){
            if(matrix[i-1][j-1]){
                countGreens++;
            }
        }
        //Check Down Left
        if(i+1<matrix.length && j-1>=0){
            if(matrix[i+1][j-1]){
                countGreens++;
            }
        }
        //Check Down Right
        if(i+1<matrix.length && j+1<matrix.length){
            if(matrix[i+1][j+1]){
                countGreens++;
            }
        }
        return countGreens;
    }
}
