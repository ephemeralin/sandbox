package multiplymatrixtovector;

/**
 * The Matrix multiplier.
 */
public class MatrixMultiplier {

    /**
     * Multiply matrix to vector.
     *
     * @param matrix the matrix
     * @param vector the vector
     * @return the result vector
     */
    public static int[] multiplyMatrixToVector(int[][] matrix, int[] vector) {
        int length = vector.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = 0;
            for (int j = 0; j < length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }
}
