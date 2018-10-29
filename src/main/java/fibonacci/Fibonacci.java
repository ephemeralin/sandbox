package fibonacci;

import java.math.BigInteger;

//   a  b  -
//0. 1, 1, 2, 3, 5, 8, 13, ...
/**
 * Fibonacci calculation.
 */
public class Fibonacci {
    /**
     * Calculate fibonacci using recursion.
     * @param n for that position
     * @return result
     */
    public static long getRecur(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getRecur(n - 1) + getRecur(n - 2);
    }

    /**
     * Calculate fibonacci using loop.
     * @param n for that position
     * @return result
     */
    public static BigInteger getLoop(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }
        return a;
    }
}
