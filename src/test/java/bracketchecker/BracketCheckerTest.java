package bracketchecker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Bracket checker test.
 */
public class BracketCheckerTest {
    /**
     * When checking quantity of brackets is incorrect then returns false.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenCheckQuantityWrongThenFalseTest() throws Exception {
        BracketChecker bc = new BracketChecker();

        assertThat(bc.checkQuantity("{[1, 3, 5]]}"), is(false));
    }

    /**
     * When checking quantity of brackets is correct then returns true.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenCheckQuantityCorrectThenTrueTest() throws Exception {
        BracketChecker bc = new BracketChecker();

        assertThat(bc.checkQuantity("{([1, 1, 1], [2, 2]), ([3])}"), is(true));
    }

    /**
     * When check balance correct then true -1.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenCheckBalanceCorrectThenTrue1Test() throws Exception {
        BracketChecker bc = new BracketChecker();

        assertThat(bc.checkBalance("([])"), is(true));
    }

    /**
     * When check balance correct then true -2.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenCheckBalanceCorrectThenTrue2Test() throws Exception {
        BracketChecker bc = new BracketChecker();

        assertThat(bc.checkBalance("{([1, 1, 1], [2, 2]), ([3])}"), is(true));
    }

    /**
     * When check balance wrong then false -1.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenCheckBalanceWrongThenFalse1Test() throws Exception {
        BracketChecker bc = new BracketChecker();

        assertThat(bc.checkBalance("([(]"), is(false));
    }

    /**
     * When check balance wrong then false -2.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenCheckBalanceWrongThenFalse2Test() throws Exception {
        BracketChecker bc = new BracketChecker();

        assertThat(bc.checkBalance("{([}1, 1, 1], [2, 2]), ([3])}"), is(false));
    }

    /**
     * When total check string with wrong quantity then false.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenTotalCheckStringWithWrongQuantityThenFalseTest() throws Exception {
        BracketChecker bc = new BracketChecker();

        assertThat(bc.check("{rock]},{pop}"), is(false));
    }

    /**
     * When total check string with correct quantity but wrong balance then false.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenTotalCheckStringWithCorrectQuantityButWrongBalanceThenFalseTest() throws Exception {
        BracketChecker bc = new BracketChecker();

        assertThat(bc.check("[{rock}],[{pop]}"), is(false));
    }
}
