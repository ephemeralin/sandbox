package periodscrossingchecker;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type Periods crossing checker test.
 */
public class PeriodsCrossingCheckerTest {

    /**
     * When periods are crossed then has particular crossing period.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenPeriodsAreCrossedThenHasParticularCrossingPeriodTest() throws Exception {
        PeriodsCrossingChecker.Period firstPeriod =
                new PeriodsCrossingChecker.Period(new GregorianCalendar(2000, 0, 1),
                        new GregorianCalendar(2010, 1, 1));
        PeriodsCrossingChecker.Period secondPeriod =
                new PeriodsCrossingChecker.Period(new GregorianCalendar(2008, 3, 10),
                        new GregorianCalendar(2015, 2, 8));

        PeriodsCrossingChecker pcc = new PeriodsCrossingChecker();

        assertThat(pcc.check(firstPeriod, secondPeriod), is(-1));
    }

}