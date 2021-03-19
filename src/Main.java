public class Main {

    public static void main(String[] args) {
        double[][] matrix = createRandomMatrix(3, 100);

        System.out.println("determinant of:\n");
        printMatrix(matrix);
        System.out.println("= " + expanse(matrix));
    }


    private static double expanse(double[][] matrix) {
        if (matrix.length == 1)
            return matrix[0][0];

        double sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            double d = expanse((reduceMatrix(matrix, i)));
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

    private static double[][] createRandomMatrix(int size, int boarder) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                matrix[i][j] = boarder - (2 * Math.random() * boarder);

        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (double d : doubles) {
                System.out.print(d + " ");
            }
            System.out.println();
        }

        System.out.println("\n");
    }
}
