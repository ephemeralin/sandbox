package periodscrossingchecker;


import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * The Periods crossing checker.
 */
public class PeriodsCrossingChecker {

    /**
     * The constant BEGINNING_OF_CALENDAR.
     */
    public static final GregorianCalendar BEGINNING_OF_CALENDAR = new GregorianCalendar();
    /**
     * The constant END_OF_CALENDAR.
     */
    public static final GregorianCalendar END_OF_CALENDAR = new GregorianCalendar();

    static {
        BEGINNING_OF_CALENDAR.set(Calendar.MILLISECOND, 0);
        END_OF_CALENDAR.setTimeInMillis(Long.MAX_VALUE);
    }

    /**
     * Main method for to check crossing periods.
     *
     * @param firstStartDate  the first start date
     * @param firstEndDate    the first end date
     * @param secondStartDate the second start date
     * @param secondEndDate   the second end date
     * @return the int
     */
    public int check(GregorianCalendar firstStartDate, GregorianCalendar firstEndDate,
                               GregorianCalendar secondStartDate, GregorianCalendar secondEndDate) {
        Period firstPeriod = new Period(firstStartDate, firstEndDate);
        Period secondPeriod = new Period(secondStartDate, secondEndDate);

        return check(firstPeriod, secondPeriod);
    }

    /**
     * Main method for to check crossing periods.
     *
     * @param firstPeriod  the first period
     * @param secondPeriod the second period
     * @return the int
     */
    public int check(Period firstPeriod, Period secondPeriod) {
        if (secondPeriod.getStartDate().compareTo(firstPeriod.getEndDate()) < 0) {
            //crossing
            return -1;
        } else if (secondPeriod.getStartDate().compareTo(firstPeriod.getEndDate()) > 0) {
            //no crossing
            return 1;
        } else {
            //crossing in one date
            return 0;
        }
    }

    /**
     * The type Period.
     */
    static class Period {
        /**
         * Start date of the period.
         */
        private final GregorianCalendar startDate;
        /**
         * * End date of the period.
         */
        private final GregorianCalendar endDate;

        /**
         * Instantiates a new Period.
         *
         * @param startDate the start date
         * @param endDate   the end date
         */
        Period(GregorianCalendar startDate, GregorianCalendar endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        /**
         * Gets start date.
         *
         * @return the start date
         */
        public GregorianCalendar getStartDate() {
            return startDate;
        }

        /**
         * Gets end date.
         *
         * @return the end date
         */
        public GregorianCalendar getEndDate() {
            return endDate;
        }
    }

}
