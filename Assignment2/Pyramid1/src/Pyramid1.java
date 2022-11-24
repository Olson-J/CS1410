import java.util.Scanner;
import java.util.Arrays;

/**
 * this program asks the user for an integer, then
 * prints a pyramid with that number of lines. Each line
 * is printed with the same number of spaces between each number,
 * and progressively adds numbers (on each side of the line, in order)
 * to each line until the outermost number is the same as the line number.
 * @author      Julie Olson     a02363064@aggies.usu.edu
 * @version 1.0
 * @since Feb 1 2022
 **/
public class Pyramid1 {
    /**
     * this method asks the user for an integer input
     * (the number of lines to be printed), then determines
     * how many spaces should be between each number in the
     * printed pyramid based on how many digits are in the user's
     * input. The pyramid is then build and printed line by line,
     * with each line having another number added on either end
     * until the final line count is met.
     * parameters: none
     * returns: none
     **/
    public static void main(String[] args) {

        Scanner Number = new Scanner(System.in);
        System.out.println("Enter the number of lines: ");                  // ask the user for the number of lines to be printed
        int number = Number.nextInt();

        int size = (number * 2);                                            // create the array that will hold the pyramid
        String[] pyramid = new String[size];

        int digits = 0;
        int bigValue = size;                                                //find number of digits in the largest number in the pyramid
        while (bigValue != 0) {
            bigValue = bigValue / 10;
            digits++;
        }
        digits++;                                                           // add one additional space to the digit count

        int fillCount = 0;
        for (int i = 0; i < digits; i++) {
            fillCount++;
        }
        String fill = " ".repeat(fillCount);                                // put the spaces into one 'spot'
        Arrays.fill(pyramid, fill);                                         // fill empty array with blank 'spots'

        int count = 1;
        for (int spot = number; count <= number; count++, spot--){          // on each line add the corresponding number to either end of the array
            pyramid[spot] = String.valueOf(count);
            pyramid[number + (count - 1)] = String.valueOf(count) ;
            for (String s: pyramid) {                                       // then print every element of the array to form one line of the pyramid
                System.out.printf("%" + digits + "s", s);
            }
            System.out.print('\n');                                         // begin next line of pyramid
        }
    }
}

