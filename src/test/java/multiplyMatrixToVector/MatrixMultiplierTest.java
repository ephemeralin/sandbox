package multiplyMatrixToVector;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixMultiplierTest {

    @Test
    public void multiplyMatrixToVector() {
        int[][] matrix = {{2, 4, 0}, {-2, 1, 3}, {-1, 0, 1}};
        int[] vector = {1, 2, -1};
        int[] expectedResult = {10, -3, -2};

        int[] result = MatrixMultiplier.multiplyMatrixToVector(matrix, vector);

        assertThat(result, is(expectedResult));
    }
}