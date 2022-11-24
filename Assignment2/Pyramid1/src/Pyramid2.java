import java.util.Scanner;
import java.util.Arrays;

/**
 * this program asks the user for an integer, then
 * prints a pyramid with that number of lines. Each line
 * is printed with the same number of spaces between each number.
 * On each line the middle number is double what the previous
 * middle number was, and the rest of the line consists of the
 * middle number being divided in half until it reaches 1 again.
 * @author      Julie Olson     a02363064@aggies.usu.edu
 * @version 1.0
 * @since Feb 1 2022
 **/
public class Pyramid2 {
    /**
     * this method asks the user for an integer input
     * (the number of lines to be printed), then determines
     * how many spaces should be between each number in the
     * printed pyramid based on how many digits are in the user's
     * input. The pyramid is then build and printed line by line,
     * with each line building off of the last (the middle number
     * is doubled each time) until the final line count is met.
     * parameters: none
     * returns: none
     **/
    public static void main(String[] args) {

        Scanner Number = new Scanner(System.in);
        System.out.println("Enter the number of lines: ");          // ask user for the number of lines
        int numRows = Number.nextInt();

        int size = (numRows * 2) + 1;                               // create the array
        String[] pyramid = new String[size];

        int count = 0;
        int bigValue = (int) Math.pow(2, numRows);                  //find number of digits in the largest number in the pyramid
        while (bigValue != 0) {
            bigValue = bigValue / 10;
            count++;
        }
        count++;                                                    // add one additional space to the digit count

        int fillCount = 0;
        for (int i = 0; i < count; i++) {
            fillCount++;
        }
        String fill = " ".repeat(fillCount);                        // fill one 'spot' with the spaces
        Arrays.fill(pyramid, fill);                                 // fill array with 'spots'

        for (int i = 0; i <= numRows; i++) {                        // repeat for each row of the pyramid
            int value = (int) Math.pow(2, i);                       // calculate the middle number
            String val = "" + value;
            pyramid[numRows] = val;                                 // sets middle of array to the middle number
            if (value > 1) {                                        // for every row except row 0
                int check = value;                                  // divide the middle number in half
                int x = 1;
                do {                                                // divides the previous number in half until it reaches 1 ('edge' of the pyramid)
                    check = check / 2;
                    String checkString = "" + check;
                    if ((numRows + x) < size) {
                        pyramid[numRows + x] = checkString;         // will offset the new number's spot each time around
                    }
                    if ((numRows - x) >= 0) {
                        pyramid[numRows - x] = checkString;         // also offsets the new spot, but on the other side of the pyramid
                    }
                    x++;                                            // increases offset
                } while (check > 1);
            }
            for (String s : pyramid) {                              // prints every element in the array to form one line of the pyramid
                System.out.printf("%" + count + "s", s);
            }
            System.out.print('\n');                                 // begin new line for the next row of numbers
        }
    }
}