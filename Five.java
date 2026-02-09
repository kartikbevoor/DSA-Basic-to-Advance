public class Five {
    public static void main(String[] args) {
        
    }

    public static int[][] matrixAddition(int[][] a, int[][] b) {  // Addition of matrix
        if (a == null || b == null) {
            throw new IllegalArgumentException("Matrices must not be null");
        }

        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("Matrices must have same dimensions");
        }

        int rows = a.length;
        int cols = a[0].length;

        int[][] res = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }

        return res;
    }

    public static int[][] matrixSubtraction(int[][] a, int[][] b){  // Matrix Subtraction
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("Matrix must be of same size");
        }

        int rows = a.length;
        int cols = a[0].length;

        int[][] res = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = a[i][j] - b[i][j];
            }
        }

        return res;
    }

    public static int[][] matrixMultiplication(int[][] a, int[][] b) { // Matrix Multiplication
        if (a == null || b == null) {
            throw new IllegalArgumentException("Matrices cannot be null");
        }

        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        // Condition for matrix multiplication
        if (colsA != rowsB) {
            throw new IllegalArgumentException(
                "Number of columns of A must equal number of rows of B"
            );
        }

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    public static int[][] transposeMatrix(int[][] a){   // Transpose of a matrix
        int row = a.length;
        int col = a[0].length;

        int[][] res = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[j][i] = a[i][j];   
            }
        }

        return res;
    }
    
}
