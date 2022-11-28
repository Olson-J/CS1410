import java.util.Objects;

/**
 * demonstrates various recursive-solved problems
 * @author JulieOlson a02363064
 * @since april 12 2022
 */
public class Recursion {
    /**
     * creates a report using recursive methods
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public static void main(String[] args) {

        int[] sumMe = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        System.out.printf("Array Sum: %d\n", arraySum(sumMe, 0));

        int[] minMe = { 0, 1, 1, 2, 3, 5, 8, -42, 13, 21, 34, 55, 89 };
        System.out.printf("Array Min: %d\n", arrayMin(minMe, 0));

        String[] amISymmetric =  {
                "You can cage a swallow can't you but you can't swallow a cage can you",
                "I still say cS 1410 is my favorite class"
        };
        for (String test : amISymmetric) {
            String[] words = test.toLowerCase().split(" ");
            System.out.println();
            System.out.println(test);
            System.out.printf("Is word symmetric: %b\n", isWordSymmetric(words, 0, words.length - 1));
        }

        double[][] masses = {
                { 51.18 },
                { 55.90, 131.25 },
                { 69.05, 133.66, 132.82 },
                { 53.43, 139.61, 134.06, 121.63 }
        };
        System.out.println();
        System.out.println("--- Weight Pyramid ---");
        for (int row = 0; row < masses.length; row++) {
            for (int column = 0; column < masses[row].length; column++) {
                double weight = computePyramidWeights(masses, row, column);
                System.out.printf("%.2f ", weight);
            }
            System.out.println();
        }

        char[][] image = {
                {'*','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ','*','*',' ',' '},
                {' ','*',' ',' ','*','*','*',' ',' ',' '},
                {' ','*','*',' ','*',' ','*',' ','*',' '},
                {' ','*','*',' ','*','*','*','*','*','*'},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ','*','*','*',' ',' ','*',' '},
                {' ',' ',' ',' ',' ','*',' ',' ','*',' '}
        };
        int howMany = howManyOrganisms(image);
        System.out.println();
        System.out.println("--- Labeled Organism Image ---");
        for (char[] line : image) {
            for (char item : line) {
                System.out.print(item);
            }
            System.out.println();
        }
        System.out.printf("There are %d organisms in the image.\n", howMany);
    }

    /**
     * determines if an array of strings is symmetric
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public static boolean isWordSymmetric(String[] words, int start, int end) {
        if (words.length > 0) {                                                 // if valid input
            words[start] = words[start].toLowerCase();                          // make case consistent
            words[end] = words[end].toLowerCase();
            if (Objects.equals(words[start], words[end])) {                     // if word pair matches, continue
                if ((start + 1) < (end - 1)) {
                    return isWordSymmetric(words, start + 1, end - 1);
                } else {                                                        // if at center, words match
                    return true;
                }
            } else {
                return false;
            }
        }
        else {return true;}
    }

    /**
     * determines the sum of all elements of an array
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public static long arraySum(int[] data, int position) {
        if (data.length > 0) {                                  // if valid input
            int total = data[position];
            if (position + 1 < data.length) {                   // if there are more elements in array, repeat
                total += arraySum(data, position + 1);
            }
            return total;
        }
        else{
            return 0;
        }
    }

    /**
     * finds the minimum value of an array
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public static int arrayMin(int[] data, int position) {
        if (position >= data.length - 1) {       // if in range
            return data[position];
        }
        else {                                  // determine new min if needed
            if (data[position + 1] > data[position]) {
                data[position + 1] = data[position];
            }
             return arrayMin(data, position + 1);
        }
    }

    /**
     * calculates the weight supported at a location in a pyramid
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public static double computePyramidWeights(double[][] masses, int row, int column) {
        if (row < masses.length && row >= 0 && column < masses[row].length && column >= 0) {      //check input
            if (row > 0) {
                return masses[row][column] + (computePyramidWeights(masses, row - 1, column - 1) / 2) +
                        (computePyramidWeights(masses, row - 1, column) / 2);       // find weight supported
            }
            else {
                return masses[0][0];            // if only one location, return weight
            }
        }
        else {
            return 0.0;                         // if no location, return 0
        }
    }

    /**
     * determines how many organisms are in an image and labels
     * each organism
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public static int howManyOrganisms(char[][] image) {
        int count = 0;
        char ch = 97;
        for (int i = 0; i < image.length; i++){                 // search image for *
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == '*') {
                    testBuddies(image, i, j, ch);               // find and label all parts of organism
                    ch += 1;
                    count += 1;
                }
            }
        }
        return count;
    }

    /**
     * finds and relabels each part of an organism
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public static void testBuddies(char[][] image, int row, int col, char let){
        if (row >= 0 && row + 1 <= image.length && col >= 0 && col + 1 <= image[row].length) { // if in range
            if (row - 1 >= 0 && col < image[row - 1].length) {
                if (image[row - 1][col] == '*') {                                    // check position above
                    image[row - 1][col] = let;                                       // replace * with a letter
                    testBuddies(image, row - 1, col, let);                      // call method again on new cell
                }
            }
            if (row + 1 < image.length && col < image[row + 1].length) {
                if (image[row + 1][col] == '*') {                                    // check position below
                    image[row + 1][col] = let;
                    testBuddies(image, row + 1, col, let);
                }
            }
            if (col - 1 >= 0) {
                if (image[row][col - 1] == '*') {                                    // check position to the left
                    image[row][col - 1] = let;
                    testBuddies(image, row, col - 1, let);
                }
            }
            if (col + 1 < image[row].length) {
                if (image[row][col + 1] == '*') {                                    // check position to the right
                    image[row][col + 1] = let;
                    testBuddies(image, row, col + 1, let);
                }
            }
        }
    }
}

