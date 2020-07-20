package Factory;

/**
 * Factory Design Pattern
 */
public class MatrixFactory {

    public MatrixFactory() {
    }

    public boolean[][] getMatrix(StringBuilder sb, int rows, int columns){
        boolean[][] matrix = new boolean[rows][columns];

        String[] lines = sb.toString().split("\n");

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                switch (lines[i].charAt(j)) {
                    case '1' -> matrix[i][j] = true;
                    case '0' -> matrix[i][j] = false;
                }
            }
        }

        return matrix;
    }
}
