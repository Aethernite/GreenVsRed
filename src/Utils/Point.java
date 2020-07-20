package Utils;

//Point class is used to store cell coordinates (row, column) from a matrix (2d array)
public class Point {
    private int row;
    private int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
