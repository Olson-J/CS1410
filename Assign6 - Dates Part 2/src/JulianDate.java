/**
 * calculates the Julian date
 * @author JulieOlson a02363064
 * @since march 14 2022
 */
public class JulianDate extends Date {
    /**
     * calculates today's date based on the Julian calendar
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public JulianDate() {
        year = 1;
        month = 1;
        day = 1;

        addDays(719164);
        addDays(toToday());
    }

    /**
     * calculates the julian date of a given day
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public JulianDate(int Year, int Month, int Day) {
        year = Year;
        month = Month;
        day = Day;
    }

    /**
     * determines if the given year is a leap year in the
     * julian calendar
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    /**
     * takes a number of days, adds it to the date object,
     * and determines the date to which the number corresponds
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public void addDays(int days) {
        days += day;
        int j = year;
        int k = month;
        while (days >= getNumberOfDaysInYear(j)) {      // if adding 1+ years
            if (k <= 2) {                               // if in or before feb, add current years num of days
                days -= getNumberOfDaysInYear(j);
            }
            if (k > 2) {                                // if after feb, add next year's num of days
                days -= getNumberOfDaysInYear(j + 1);
            }
            j++;                                        // add one year at a time
        }
        while (days > getNumberOfDaysInMonth(j, k)) {   // if adding more days than are in month
            days -= getNumberOfDaysInMonth(j, k);
            k++;                                        // add one month and reduce the number of days
            if (k > 12) {
                k = 1;
                j++;
            }
        }
        year = j;
        month = k;
        day = days;
    }

}