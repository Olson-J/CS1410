/**
 * Assignment 3 for CS 1410
 * This program determines if points are contained within circles or rectangles.
 * @author Julie Olson     a02363064@aggies.usu.edu
 * @version 1.0
 * @since Feb 12 2022
 */
public class Inside {
    /**
     * This is the primary driver code to test the "inside" capabilities of the
     * various functions.
     */
    public static void main(String[] args) {
        double[] ptX = { 1, 2, 3, 4 };
        double[] ptY = { 1, 2, 3, 4 };
        double[] circleX = { 0, 5 };
        double[] circleY = { 0, 5 };
        double[] circleRadius = { 3, 3 };
        double[] rectLeft = { -2.5, -2.5 };
        double[] rectTop = { 2.5, 5.0 };
        double[] rectWidth = { 6.0, 5.0 };
        double[] rectHeight = { 5.0, 2.5 };

        System.out.println("--- Report of Points and Circles ---");
        for(int i = 0; i < circleX.length ; i++){                           // loop through circles
            for(int j = 0; j < ptX.length; j++){                            // loop through points
                System.out.print('\n');
                reportPoint(ptX[j], ptY[j]);                                // piece together the report for each loop
                if (isPointInsideCircle(ptX[j], ptY[j], circleX[i], circleY[i], circleRadius[i])) {
                    System.out.print("is inside ");
                }
                else {
                    System.out.print("is outside ");
                }
                reportCircle(circleX[i], circleY[i], circleRadius[i]);
            }
        }
        System.out.println('\n');
        System.out.println("--- Report of Points and Rectangles ---" );
        for(int i = 0; i < rectLeft.length ; i++) {                         // loop through rectangles
            for(int j = 0; j < ptX.length ; j++) {                          // loop through points
                System.out.print('\n');
                reportPoint(ptX[j], ptY[j]);                                // piece together report
                if (isPointInsideRectangle(ptX[j], ptY[j],rectLeft[i], rectTop[i], rectWidth[i],
                        rectHeight[i])) {
                    System.out.print("is inside ");
                }
                else {
                    System.out.print("is outside ");
                }
                reportRectangle(rectLeft[i],rectTop[i], rectWidth[i], rectHeight[i]);
            }
        }

    }
    /**
     * This prints out what point is being tested in the format of 'Point(x, y) '
     */
    static void reportPoint(double x, double y){
        System.out.print("Point(" + x + ", " + y + ") ");
    }

    /**
     * This prints out what circle is being tested in the format of 'Circle(x, y) Radius: r'
     */
    static void reportCircle(double x, double y, double r) {
        System.out.print("Circle(" + x + ", " + y + ") Radius: " + r);
    }

    /**
     * This finds the right and bottom values of the rectangle being tested, then prints in the
     * format of 'Rectangle(left, top, right, bottom)'
     */
    static void reportRectangle(double left, double top, double width, double height) {
        double right = left + width;
        double bottom = top - height;
        System.out.print("Rectangle(" + left + ", " + top + ", " + right +", " + bottom + ")");
    }

    /**
     * This uses the pythagorean theorem to find c (radiusNew), which determines whether the test point
     * is in the given circle. This true/false result is then returned
     */
    static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY,
                                       double circleRadius) {
        double radiusNew = Math.sqrt((Math.pow(ptX - circleX, 2) + (Math.pow(ptY - circleY, 2))));
        return (radiusNew <= circleRadius);
    }

    /**
     * This finds the right and bottom values of a rectangle and determines if the test point is within the
     * bounds of the rectangle before returning a true or false value
     */
    static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop,
                                          double rWidth, double rHeight) {
        double right = rLeft + rWidth;
        double bottom = rTop - rHeight;
        if ((ptX >= rLeft) && (ptX <= right)) {
            return (ptY >= bottom) && (ptY <= rTop);
        }
        return false;
    }
}
