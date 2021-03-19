import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(develop(matrix));
    }


    private static double develop(double[][] matrix) {
        if (matrix.length == 1)
            return matrix[0][0];

        double sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            double d = develop((reduceMatrix(matrix, i)));
            sum += Math.pow(-1, i) * matrix[i][0] * d;
        }

        return sum;
    }

    private static double[][] reduceMatrix(double[][] matrix, int rowToRemove) {
        //reduce matrix
        int reducedSize = matrix.length - 1;
        double[][] reducedMatrix = new double[reducedSize][reducedSize];

        for (int i = 0; i < reducedSize; i++) {
            //row i column j
            for (int j = 0; j < reducedSize; j++) {
                if (i >= rowToRemove)
                    reducedMatrix[i][j] = matrix[i + 1][j + 1];
                else
                    reducedMatrix[i][j] = matrix[i][j + 1];
            }
        }

        return reducedMatrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (double adouble : doubles) {
                System.out.print(adouble + " ");
            }
            System.out.println();
        }

        System.out.println("\n");
    }
}
