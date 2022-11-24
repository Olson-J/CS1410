/**
 * contains shared code for determining calendar dates
 * @author JulieOlson a02363064
 * @since march 14 2022
 */
public class Date {

    protected int year;
    protected int month;
    protected int day;

    /**
     * will return the time passed from 1/1/1970 to today
     * @author JulieOlson a02363064
     * @since march 4 2022
     */
    public int toToday() {
        double millis = System.currentTimeMillis();                     // time since 1/1/1970
        double zone = java.util.TimeZone.getDefault().getRawOffset();   //timezone difference
        double totalMillis = millis + zone;
        return (int) (totalMillis / 86400000);
    }

    /**
     * takes a number of days, subtracts it from the date object,
     * and determines the date to which the number corresponds
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public void subtractDays(int days) {
        int i = 0;
        while (i < days) {                                      // loop over days to be subtracted
            i++;
            day -= 1;                                           // subtract day
            if (day < 1) {                                      // if day = 0
                month -= 1;
                if (month < 1) {                                // if months = 0
                    month = 12;                                 // set month to 12
                    year -= 1;                                  // reset to last year
                }
                day = getNumberOfDaysInMonth(year, month);      // reset to last day of previous month
            }
        }
    }

    /**
     * prints the date object in a mm/dd/yyyy format with no
     * carriage return
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public void printShortDate() {
        System.out.format("%d/%d/%d", month, day, year);
    }

    /**
     * prints the date object in a month dd, yyyy format
     * with no carriage return
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public void printLongDate() {
        System.out.format(getMonthName(month) + " %d, %d", day, year);
    }

    /**
     * returns a string of the name of the given month
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public String getMonthName() {
        return getMonthName(month);
    }

    /**
     * returns the number equivalent of the given month
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public int getMonth() {
        return month;
    }

    /**
     * returns the number equivalent of the given year
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public int getYear() {
        return year;
    }

    /**
     * returns the number equivalent of the given day
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public int getDayOfMonth() {
        return day;
    }

    /**
     * returns the number of days in the given month in the given
     * year
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    protected int getNumberOfDaysInMonth(int year, int month) {
        // return the num of days in month
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
     * @since march 14 2022
     */
    protected int getNumberOfDaysInYear(int year) {
        // return days in year
        if (isLeapYear(year)) {
            return 366;
        }
        return 365;
    }

    /**
     * returns a string of the given month's name with the
     * first letter capitalized
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    protected String getMonthName(int month) {
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

    /**
     * determines if the given year is a leap year in the
     * julian calendar
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public boolean isLeapYear(int year) {
        return true;
    }

    /**
     * returns if the given year is a leap year in the julian
     * calendar
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public boolean isLeapYear() {
        return isLeapYear(year);
    }

    /**
     * takes a number of days, adds it to the date object,
     * and determines the date to which the number corresponds
     * @author JulieOlson a02363064
     * @since march 14 2022
     */
    public void addDays(int days) {
    }
}