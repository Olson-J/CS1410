import java.util.Scanner;

/**
 * this program gets an integer input from the user
 * and finds the 10th digit of the given ISBN number,
 * which is then printed to the screen in its
 * entirety
 * @author      Julie Olson     a02363064@aggies.usu.edu
 * @version 1.0
 * @since Jan 25 2022
 **/
public class ISBN {
    /**
     * this method asks the user for an integer input
     * (the first 9 digits of the ISBN), then divides the
     * number into individual digits. These digits are used
     * to determine the 10th digit of the ISBN, which is
     * then printed in its entirety. If the last digit is 10
     * it is represented by 'X' when printed.
     * parameters: none
     * returns: none
     **/
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);

        System.out.println("Enter the first 9 digits of an ISBN: ");          // get first 9 digits
        int wholeNumber = number.nextInt();

        int d1 = wholeNumber / 100_000_000;                                   // math to break the original number
        int n1 = wholeNumber - (d1 * 100_000_000);                            // into individual digits
        int d2 = n1 / 10_000_000;
        int n2 = n1 - (d2 * 10_000_000);
        int d3 = n2 / 1_000_000;
        int n3 = n2 - (d3 * 1_000_000);
        int d4 = n3 / 100_000;
        int n4 = n3 - (d4 * 100_000);
        int d5 = n4 / 10_000;
        int n5 = n4 - (d5 * 10_000);
        int d6 = n5 / 1_000;
        int n6 = n5 - (d6 * 1_000);
        int d7 = n6 / 100;
        int n7 = n6 - (d7 * 100);
        int d8 = n7 / 10;
        int d9 = n7 - (d8 * 10);


        int check = (d1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6            // math to find last digit
                * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;

        if (check == 10) {                                                  // if last digit is 10, represent
            System.out.println("The ISBN-10 number is: " + d1 + d2 + d3     // it with an 'X' when printed
                    + d4 + d5 + d6 + d7 + d8 + d9 + "X");
        }
        else {                                                              // if not 10 print new number normally
            System.out.println("The ISBN-10 number is: " + d1 + d2 + d3
                    + d4 + d5 + d6 + d7 + d8 + d9 + check);
        }
    }
}