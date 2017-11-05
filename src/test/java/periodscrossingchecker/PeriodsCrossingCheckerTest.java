package periodscrossingchecker;

import org.junit.Test;

import java.time.LocalDate;

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
    public void normalCrossingTest() throws Exception {
        PeriodsCrossingChecker.DatesInterval firstDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2000, 1, 1),
                        LocalDate.of(2010, 1, 1));
        PeriodsCrossingChecker.DatesInterval secondDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2008, 3, 10),
                        LocalDate.of(2015, 2, 8));

        PeriodsCrossingChecker pcc = new PeriodsCrossingChecker();
        PeriodsCrossingChecker.DatesInterval resultDatesInterval = pcc.check(firstDatesInterval, secondDatesInterval);

        PeriodsCrossingChecker.DatesInterval expectedDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2008, 3, 10),
                        LocalDate.of(2010, 1, 1));

        assertThat(resultDatesInterval.equals(expectedDatesInterval), is(true));
    }

    /**
     * Second period is minimal start date test.
     *
     * @throws Exception the exception
     */
    @Test
    public void secondPeriodIsMinimalStartDateTest() throws Exception {
        PeriodsCrossingChecker.DatesInterval firstDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2000, 1, 1),
                        LocalDate.of(2010, 1, 1));
        PeriodsCrossingChecker.DatesInterval secondDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(null,
                        LocalDate.of(2015, 1, 1));

        PeriodsCrossingChecker pcc = new PeriodsCrossingChecker();
        PeriodsCrossingChecker.DatesInterval resultDatesInterval = pcc.check(firstDatesInterval, secondDatesInterval);

        PeriodsCrossingChecker.DatesInterval expectedDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2000, 1, 1),
                        LocalDate.of(2010, 1, 1));

        assertThat(resultDatesInterval.equals(expectedDatesInterval), is(true));
    }

    /**
     * First has max end date and second inside test.
     *
     * @throws Exception the exception
     */
    @Test
    public void firstHasMaxEndDateAndSecondInsideTest() throws Exception {
        PeriodsCrossingChecker.DatesInterval firstDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2000, 1, 1),
                        null);
        PeriodsCrossingChecker.DatesInterval secondDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2008, 1, 1),
                        LocalDate.of(2015, 1, 1));

        PeriodsCrossingChecker pcc = new PeriodsCrossingChecker();
        PeriodsCrossingChecker.DatesInterval resultDatesInterval = pcc.check(firstDatesInterval, secondDatesInterval);

        PeriodsCrossingChecker.DatesInterval expectedDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2008, 1, 1),
                        LocalDate.of(2015, 1, 1));

        assertThat(resultDatesInterval.equals(expectedDatesInterval), is(true));
    }

    /**
     * First has max end date and second cross test.
     *
     * @throws Exception the exception
     */
    @Test
    public void firstHasMaxEndDateAndSecondCrossTest() throws Exception {
        PeriodsCrossingChecker.DatesInterval firstDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2000, 1, 1),
                        null);
        PeriodsCrossingChecker.DatesInterval secondDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(1990, 1, 1),
                        LocalDate.of(2015, 1, 1));

        PeriodsCrossingChecker pcc = new PeriodsCrossingChecker();
        PeriodsCrossingChecker.DatesInterval resultDatesInterval = pcc.check(firstDatesInterval, secondDatesInterval);

        PeriodsCrossingChecker.DatesInterval expectedDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2000, 1, 1),
                        LocalDate.of(2015, 1, 1));

        assertThat(resultDatesInterval.equals(expectedDatesInterval), is(true));
    }

    /**
     * Intervals do not crosses test.
     *
     * @throws Exception the exception
     */
    @Test
    public void intervalsDoNotCrossesTest() throws Exception {
        PeriodsCrossingChecker.DatesInterval firstDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2000, 1, 1),
                        LocalDate.of(2008, 1, 1));
        PeriodsCrossingChecker.DatesInterval secondDatesInterval =
                new PeriodsCrossingChecker.DatesInterval(LocalDate.of(2010, 1, 1),
                        LocalDate.of(2015, 1, 1));

        PeriodsCrossingChecker pcc = new PeriodsCrossingChecker();
        PeriodsCrossingChecker.DatesInterval resultDatesInterval = pcc.check(firstDatesInterval, secondDatesInterval);

        PeriodsCrossingChecker.DatesInterval expectedDatesInterval =
                new PeriodsCrossingChecker.DatesInterval();

        assertThat(resultDatesInterval.equals(expectedDatesInterval), is(true));
    }
}
