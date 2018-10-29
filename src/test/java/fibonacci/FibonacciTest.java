package fibonacci;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Fibonacci calculation test.
 */
public class FibonacciTest {

    /**
     * Test first four elements using recursion.
     */
    @Test
    public void testFirstElementsUsingGetRecur() {
        assertThat(Fibonacci.getRecur(0), is(0L));
        assertThat(Fibonacci.getRecur(1), is(1L));
        assertThat(Fibonacci.getRecur(2), is(1L));
        assertThat(Fibonacci.getRecur(3), is(2L));
    }

    /**
     * Test first four elements using loop.
     */

    @Test
    public void testFirstElementsUsingGetLoop() {
        assertThat(Fibonacci.getLoop(0), is(BigInteger.ZERO));
        assertThat(Fibonacci.getLoop(1), is(BigInteger.ONE));
        assertThat(Fibonacci.getLoop(2), is(BigInteger.ONE));
        assertThat(Fibonacci.getLoop(3), is(BigInteger.valueOf(2)));
    }

    /**
     * Test fiftieth element using recursion.
     */

    @Test
    public void testFiftiethElementsUsingGetRecur() {
        assertThat(Fibonacci.getRecur(20), is(6765L));
    }

    /**
     * Test fiftieth element using loop.
     */

    @Test
    public void testFiftiethElementsUsingGetLoop() {
        assertThat(Fibonacci.getLoop(50), is(new BigInteger("12586269025")));
    }

}