import java.util.Scanner;
import java.lang.Math;

/**
 * this program asks the user for 3 coefficients and
 * determines how many roots the quadratic equation
 * has with the given coefficients. It then calculates
 * and prints all available roots.
 * @author      Julie Olson     a02363064@aggies.usu.edu
 * @version 1.0
 * @since Jan 25 2022
 **/
public class Quadratic {
    /**
     * this method calculates the first root of the
     * quadratic equation with the given coefficients
     *
     * parameters: two floats (coefficients a and b),
     *      and float disc (the discriminant)
     * returns: double result (the first root)
     **/
    static double root1(float a, float b, float disc) {         // math to find first root
        double result = (-b + Math.sqrt(disc)) / (2 * a);
        return result;
    }

    /**
     * this method calculates the second root of the
     * quadratic equation with the given coefficients
     *
     * parameters: two floats (coefficients a and b),
     *     and float disc (the discriminant)
     * returns: double result (the first root)
     **/
    static double root2(float a, float b, float disc) {         // math to find second root
        double result = (-b - Math.sqrt(disc)) / (2 * a);
        return result;
    }

    /**
     * this method asks the user for three coefficients,
     * then uses them to calculate the discriminant
     * and determine how many roots the quadratic
     * equation has with the given coefficients.
     * Once the roots have been determined they are
     * printed to the screen
     * parameters: none
     * returns: none
     **/
    public static void main(String[] args) {

        Scanner numbers = new Scanner(System.in);

        System.out.println("Enter a, b, c: ");                  // ask user for coefficients
        float a = numbers.nextFloat();                             // assign numbers to variables
        float b = numbers.nextFloat();
        float c = numbers.nextFloat();

        float disc = (b * b) - (4 * a * c);                     // solve for discriminant

        if (disc > 0) {                                         // if discriminant is positive
            System.out.println("There are two roots" +          // equation has two roots
                    " for the quadratic equation with" +
                    " these coefficients.");
            double x = root1(a, b, disc);                       // solve for roots
            double y = root2(a, b, disc);
            System.out.println("r1: " + x);                     // print roots
            System.out.println("r2: " + y);
        }
        else if (disc == 0) {                                   // if discriminant is zero
            System.out.println("There is one root for" +        // equation has one root
                    " the quadratic equation with these" +
                    " coefficients.");
            double x = root1(a, b, disc);                       // solve for root
            System.out.println("r1: " + x);                     // print root
        }
        else if (disc < 0) {                                    // if discriminant is negative
            System.out.println("There are no roots for" +       // equation has no roots
                    " the quadratic equation with these " +
                    "coefficients.");
        }
    }
}