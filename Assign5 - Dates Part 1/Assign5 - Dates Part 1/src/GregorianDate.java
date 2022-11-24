/**
 * calculates the gregorian date
 * @author JulieOlson a02363064
 * @since march 4 2022
 */
public class GregorianDate {
    private int year;
    private int month;
    private int day;

    /**
     * calculates today's date based on the gregorian calendar
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    public GregorianDate() {
        year = 1970;
        month = 1;
        day = 1;
        double millis = System.currentTimeMillis();                     // time since 1/1/1970
        double zone = java.util.TimeZone.getDefault().getRawOffset();   //timezone difference
        double totalMillis = millis + zone;
        int days = (int) (totalMillis / 86400000);                      // convert millis to days
        addDays(days);                                                  // add days to the date object with addDays()
    }

    /**
     * calculates the gregorian date of a given day
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    public GregorianDate(int year, int month, int day) {
        int i = 0, j = 0, k = 0;
        int oldDays = 0;
        while (i < year) {                          // find number of days in the years up until given year
            oldDays += getNumberOfDaysInYear(i);
            i++;
        }
        while (j < month) {                         // find number of days in the months up until given month
            oldDays += getNumberOfDaysInMonth(year, j);
            j++;
        }
        while (k < day) {                           // add number of days given
            oldDays += 1;
            k++;
        }
        addDays(oldDays);                           // add to date, sets date to the given
    }

    /**
     * takes a number of days, adds it to the date object,
     * and determines the date to which the number corresponds
     * @author JulieOlson a02363064
     * @since march 4 2022
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

    /**
     * takes a number of days, subtracts it from the date object,
     * and determines the date to which the number corresponds
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    public void subtractDays(int days) {
        int i = 0;
        while (i < days) {                                      // loop over days to be subtracted
            i++;
            day -= 1;                                           // subtract day
            if (day < 1) {                                      // if day = 0
                month -= 1;
                day = getNumberOfDaysInMonth(year, month);      // reset to last day of previous month
                if (month < 1) {                                // if months = 0
                    month = 12;                                 // set month to 12
                    year -= 1;                                  // reset to last year
                }
            }
        }
    }

    /**
     * returns if the given year is a leap year in the gregorian
     * calendar
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    public boolean isLeapYear() {
        return isLeapYear(year);
    }

    /**
     * prints the date object in a mm/dd/yyyy format with no
     * carriage return
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    public void printShortDate() {
        System.out.format("%d/%d/%d", month, day, year);
    }

    /**
     * prints the date object in a month dd, yyyy format
     * with no carriage return
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    public void printLongDate() {
        System.out.format(getMonthName(month) + " %d, %d", day, year);
    }

    /**
     * returns a string of the name of the given month
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    public String getMonthName() {
        return getMonthName(month);
    }

    /**
     * returns the number equivalent of the given month
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    public int getMonth() {
        return month;
    }

    /**
     * returns the number equivalent of the given year
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    public int getYear() {
        return year;
    }

    /**
     * returns the number equivalent of the given day
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    public int getDayOfMonth() {
        return day;
    }

    /**
     * determines if the given year is a leap year in the
     * gregorian calendar
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        else if (year % 100 == 0) {
            return false;
        }
        else return year % 4 == 0;
    }

    /**
     * returns the number of days in the given month in the given
     * year
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    private int getNumberOfDaysInMonth(int year, int month) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;                      // april, june, september, or november
        }
        if (month == 2) {                   // february changes based on leap years
            if (isLeapYear(year)) {
                return 29;
            }
            else {
                return 28;
            }
        }
        return 31;                          // all the other months
    }

    /**
     * returns the number of days in the given year
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    private int getNumberOfDaysInYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        }
        return 365;
    }

    /**
     * returns a string of the given month's name with the
     * first letter capitalized
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    private String getMonthName(int month) {
        if (month == 1) {
            return "January";
        }
        else if (month == 2) {
            return "February";
        }
        else if (month == 3) {
            return "March";
        }
        else if (month == 4) {
            return "April";
        }
        else if (month == 5) {
            return "May";
        }
        else if (month == 6) {
            return "June";
        }
        else if (month == 7) {
            return "July";
        }
        else if (month == 8) {
            return "August";
        }
        else if (month == 9) {
            return "September";
        }
        else if (month == 10) {
            return "October";
        }
        else if (month == 11) {
            return "November";
        }
        return "December";
    }
}