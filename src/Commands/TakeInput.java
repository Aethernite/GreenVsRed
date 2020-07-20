package Commands;

import Factory.MatrixFactory;
import Utils.Point;

import java.util.Scanner;
/**
 * Command that process input from the user.
 * Input validation is not implemented following the assignment.
 */
public class TakeInput implements Command{
    private final Command parent;
    private int rows;
    private int columns;
    private StringBuilder matrix;
    private Point coordinates;
    private int generations;
    Scanner sc;

    public TakeInput(Command parent) {
        this.parent = parent;
        this.matrix = new StringBuilder();
        this.sc = new Scanner(System.in);
    }

    @Override
    public Command execute() {
        boolean[][] grid = interactWithUser();
        return new ProcessGenerations(this,grid,coordinates,generations);
    }

    /**
     * Takes the user input and returns 2d matrix.
     * @return boolean 2d matrix (array)
     */
    private boolean[][] interactWithUser(){
        takeInputMatrixSize();
        takeInputMatrix();
        takeCellCoordinatesAndGenerations();
        MatrixFactory mf = new MatrixFactory();
        return mf.getMatrix(matrix,rows,columns);
    }

    /**
     * Takes input - the matrix size.
     */
    private void takeInputMatrixSize() {
        String[] input = sc.nextLine().split(", ");
        rows = Integer.parseInt(input[0]);
        columns = Integer.parseInt(input[1]);

        //x <= y < 1000 CONSTRAINT
        if(rows <= columns || columns < 1000){
            throw new IllegalArgumentException("Invalid grid size!");
        }
    }

    /**
     * Takes input - the matrix in plain text.
     */
    private void takeInputMatrix() {
        for(int i=0; i<rows; i++){
            matrix.append(sc.nextLine()).append(System.lineSeparator());
        }
        matrix.replace(matrix.length()-1,matrix.length()-1, "");
    }

    /**
     * Takes input - the coordinates of the cell point of interest.
     */
    private void takeCellCoordinatesAndGenerations(){
        String[] input = sc.nextLine().split(", ");
        coordinates = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        generations = Integer.parseInt(input[2]);
    }
}


