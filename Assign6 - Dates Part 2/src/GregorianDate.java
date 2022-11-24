/**
 * calculates the gregorian date
 * @author JulieOlson a02363064
 * @since march 14 2022
 */
public class GregorianDate extends Date {

    /**
     * calculates today's date based on the gregorian calendar
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public GregorianDate() {
        year = 1970;
        month = 1;
        day = 1;
        addDays(toToday());
    }

    /**
     * calculates the gregorian date of a given day
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public GregorianDate(int Year, int Month, int Day) {
        year = Year;
        month = Month;
        day = Day;
    }

    /**
     * determines if the given year is a leap year in the
     * gregorian calendar
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public boolean isLeapYear(int year) {

        if (year % 400 == 0) {
            return true;
        }
        else if (year % 100 == 0) {
            return false;
        }
        else return year % 4 == 0;
    }

    /**
     * takes a number of days, adds it to the date object,
     * and determines the date to which the number corresponds
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public void addDays(int days) {
        int i = 0;
        while (i < days) {                                          // loop over days to be added
            i++;
            day += 1;                                               // add day
            if (day > getNumberOfDaysInMonth(year, month)) {        // if more days than in month
                day = 1;                                            // reset day to 1
                month += 1;                                         // add one to month
                if (month == 13) {                                  // if more months than in year
                    month = 1;                                      // set month to 0
                    year += 1;                                      // add one to year
                }
            }
        }
    }
}