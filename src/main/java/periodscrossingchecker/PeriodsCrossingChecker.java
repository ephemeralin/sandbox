package periodscrossingchecker;


import java.time.LocalDate;

/**
 * The Periods crossing checker.
 */
public class PeriodsCrossingChecker {
    /**
     * Main method for to check crossing periods.
     *
     * @param firstDatesInterval  the first period
     * @param secondDatesInterval the second period
     * @return the int
     */
    public DatesInterval check(DatesInterval firstDatesInterval, DatesInterval secondDatesInterval) {
        DatesInterval crossingDatesInterval;

        LocalDate startDateFirst = firstDatesInterval.getStartDate();
        LocalDate endDateFirst = firstDatesInterval.getEndDate();
        LocalDate startDateSecond = secondDatesInterval.getStartDate();
        LocalDate endDateSecond = secondDatesInterval.getEndDate();

        if (startDateSecond.compareTo(startDateFirst) < 0 & endDateSecond.compareTo(startDateFirst) < 0) {        //1
            crossingDatesInterval = new DatesInterval();

        } else if (startDateSecond.compareTo(startDateFirst) < 0 & endDateSecond.compareTo(startDateFirst) >= 0
                & endDateSecond.compareTo(endDateFirst) < 0) { //2
            crossingDatesInterval = new DatesInterval(startDateFirst, endDateSecond);

        } else if (startDateSecond.compareTo(startDateFirst) >= 0 & endDateSecond.compareTo(endDateFirst) <= 0) { //3
            crossingDatesInterval = new DatesInterval(startDateSecond, endDateSecond);

        } else if (startDateSecond.compareTo(endDateFirst) <= 0 & endDateSecond.compareTo(endDateFirst) > 0
                & startDateFirst.compareTo(startDateFirst) > 0) { //4
            crossingDatesInterval = new DatesInterval(startDateSecond, endDateFirst);

        } else if (startDateSecond.compareTo(endDateFirst) > 0 & endDateSecond.compareTo(endDateFirst) > 0) { //5
            crossingDatesInterval = new DatesInterval();

        } else if (startDateSecond.compareTo(startDateFirst) < 0 & endDateSecond.compareTo(endDateFirst) > 0) { //6
            crossingDatesInterval = new DatesInterval(startDateFirst, endDateFirst);

        } else if (startDateSecond.compareTo(endDateFirst) < 0) {
            crossingDatesInterval = new DatesInterval(startDateSecond, endDateFirst);

        } else if (endDateSecond.compareTo(startDateFirst) < 0) {
            crossingDatesInterval = new DatesInterval(startDateFirst, endDateSecond);

        } else {
            crossingDatesInterval = new DatesInterval();
        }

        return crossingDatesInterval;
    }

    /**
     * The type Period.
     */
    static class DatesInterval {
        /**
         * Start date of the period.
         */
        private final LocalDate startDate;
        /**
         * * End date of the period.
         */
        private final LocalDate endDate;

        /**
         * Dates interval is empty.
         */
        private boolean isEmpty;

        /**
         * Instantiates a new empty Period.
         */
        DatesInterval() {
            this.startDate = null;
            this.endDate = null;
            this.isEmpty = true;
        }

        /**
         * Instantiates a new Period.
         *
         * @param startDate the start date
         * @param endDate   the end date
         */
        DatesInterval(LocalDate startDate, LocalDate endDate) {
            if (startDate == null) {
                this.startDate = LocalDate.MIN;
            } else {
               this.startDate = startDate;
            }
            if (endDate == null) {
                this.endDate = LocalDate.MAX;
            } else {
                this.endDate = endDate;
            }
            this.isEmpty = false;
        }

        /**
         * Gets start date.
         *
         * @return the start date
         */
        public LocalDate getStartDate() {
            return startDate;
        }

        /**
         * Gets end date.
         *
         * @return the end date
         */
        public LocalDate getEndDate() {
            return endDate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            DatesInterval that = (DatesInterval) o;

            if (isEmpty != that.isEmpty) {
                return false;
            }
            if (getStartDate() != null ? !getStartDate().equals(that.getStartDate()) : that.getStartDate() != null) {
                return false;
            }
            return getEndDate() != null ? getEndDate().equals(that.getEndDate()) : that.getEndDate() == null;
        }

        @Override
        public int hashCode() {
            int result = getStartDate() != null ? getStartDate().hashCode() : 0;
            result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
            result = 31 * result + (isEmpty ? 1 : 0);
            return result;
        }
    }
}
