/**
 * Assignment 4 for CS 1410
 * This program evaluates the linear and binary searching, along
 * with comparing performance difference between the selection sort
 * and the built-in java.util.Arrays.sort.
 *
 * @author James Dean Mathias
 */
public class EvaluationDriver {
    static final int MAX_VALUE = 1_000_000;
    static final int MAX_ARRAY_SIZE = 100_000;
    static final int ARRAY_SIZE_START = 20_000;
    static final int ARRAY_SIZE_INCREMENT = 20_000;
    static final int NUMBER_SEARCHES = 50_000;

    /**
     * This method creates and returns an array of ints that are
     * randomly generated
     * @author Julie Olson a02363064
     * @since Feb 21, 2022
     */
    public static int[] generateNumbers(int howMany, int maxValue) {
        if (howMany > 0) {                                          // make sure howMany is a valid length
            int[] randArray = new int[howMany];                     // create array
            for (int i = 0; i < randArray.length; i++) {
                randArray[i] = (int)(Math.random() * maxValue);     // fill with random numbers
            }
            return randArray;
        }
        return null;
    }

    /**
     * This method uses linear search to determine if the given value is
     * present in the array, and returns true/false accordingly
     * @author Julie Olson a02363064
     * @since Feb 21, 2022
     */
    public static boolean linearSearch(int[] data, int search) {
        for (int datum : data) {                                    // go through array one element at a time
            if (datum == search) {                                  // if number is found return true
                return true;
            }
        }
        return false;
    }

    /**
     * This method uses binary searching to determine if the given value
     * is present in the array, and returns true/false accordingly
     * @author Julie Olson a02363064
     * @since Feb 21, 2022
     */
    public static boolean binarySearch(int[] data, int search) {
        int first = 0;
        int last = data.length - 1;
        while (first <= last) {
            int middle = first + (last - first) /2;

            if (data[middle] == search) {   // if number is found return true
                return true;
            }
            if (data[middle] < search) {
                first = middle + 1;         // if search is bigger than middle, it has to be in the right sub-array
            }
            else {
                last = middle - 1;          // if search is smaller than middle, it has to be in the left sub-array
            }

        }
        return false;
    }

    /**
     * This method sorts the integers in the array from lowest to highest
     * @author Julie Olson a02363064
     * @since Feb 21, 2022
     */
    public static void selectionSort(int[] data) {

        for (int a = 0; a < data.length; a++) {             // will loop until whole array is sorted
            for (int b = a + 1; b < data.length; b++) {
                if (data[a] > data[b]) {                    // rearranges the numbers in ascending order
                    int c = data[a];
                    data[a] = data[b];
                    data[b] = c;
                }
            }
        }
    }

    /**
     * This method creates an array of random numbers and times how long
     * it takes to linear search the array for a random number NUMBER_SEARCH
     * times. The number of times a match is found is recorded, and a report
     * printed out
     * @author Julie Olson a02363064
     * @since Feb 26, 2022
     */
    public static void demoLinearSearchUnsorted(int index, int x) {
        int[] numbers = generateNumbers(x, index);                          // create array
        int count = 0;
        double before = System.currentTimeMillis();                         // start timer
        for(int i = 0; i < NUMBER_SEARCHES; i++) {
            int searchFor = (int)(Math.random() * MAX_VALUE);               // create random number
            if (numbers != null) {
                if (linearSearch(numbers, searchFor)) {                     // search array for number
                    count++;                                                // count how many times it is found
                }
            }
        }

        double after = System.currentTimeMillis();                          // stop timer
        int time = (int) (after - before);                                  // find how long it took
        System.out.println("Number of items       : " + x);                 // print report
        System.out.println("Times value was found : " + count);
        System.out.println("Total search time     : " + time + " ms");
        System.out.println();
    }

    /**
     * This method creates and sorts an array of random numbers and times how
     * long it takes to linear search the array for a random number NUMBER_SEARCH
     * times. The number of times a match is found is recorded, and a report
     * printed out
     * @author Julie Olson a02363064
     * @since Feb 26, 2022
     */
    public static void demoLinearSearchSorted(int index, int x) {
        int[] numbers = generateNumbers(x, index);                          // create array of random numbers
        int count = 0;
        double before = System.currentTimeMillis();                         // start timer
        if (numbers != null) {
            selectionSort(numbers);                                         // sort array
        }
        for(int i = 0; i < NUMBER_SEARCHES; i++) {
            int searchFor = (int)(Math.random() * MAX_VALUE);               // create random number
            if (numbers != null) {
                if (linearSearch(numbers, searchFor)) {                     // search array for number
                    count++;                                                // count the number of times it is found
                }
            }
        }
        double after = System.currentTimeMillis();                          // end timer
        int time = (int) (after - before);                                  // find how long it took

        System.out.println("Number of items       : " + x);                 // print report
        System.out.println("Times value was found : " + count);
        System.out.println("Total search time     : " + time + " ms");
        System.out.println();
    }

    /**
     * This method creates and sorts an array of random numbers and times how
     * long it takes to binary search the array for a random number NUMBER_SEARCH
     * times. The number of times a match is found is recorded, and a report
     * printed out
     * @author Julie Olson a02363064
     * @since Feb 26, 2022
     */
    public static void demoBinarySearchSelectionSort(int index, int x) {
        int[] numbers = generateNumbers(x, index);                          // create array of random numbers
        int count = 0;
        double before = System.currentTimeMillis();                         // start timer
        if (numbers != null) {
            selectionSort(numbers);                                         // sort array
        }
        for(int i = 0; i < NUMBER_SEARCHES; i++) {
            int searchFor = (int)(Math.random() * MAX_VALUE);               // create random number
            if (numbers != null) {
                if (binarySearch(numbers, searchFor)) {                     // search array for number
                    count++;                                                // keep track of how many times it is found
                }
            }
        }
        double after = System.currentTimeMillis();                          // end timer
        int time = (int) (after - before);                                  // find how long it took
        System.out.println("Number of items       : " + x);                 // print report
        System.out.println("Times value was found : " + count);
        System.out.println("Total search time     : " + time + " ms");
        System.out.println();
    }

    /**
     * This method creates an array of random numbers and uses the java.util.array.sort
     * function to sort the array before timing how long it takes to binary search
     * the array for a random number NUMBER_SEARCH times. The number of times a
     * match is found is recorded, and a report is printed out
     * @author Julie Olson a02363064
     * @since Feb 26, 2022
     */
    public static void demoBinarySearchFastSort(int index, int x) {
        int[] numbers = generateNumbers(x, index);                          // create random array
        int count = 0;
        double before = System.currentTimeMillis();                         // start timer
        if (numbers != null) {
            java.util.Arrays.sort(numbers);                                 // sort array
        }
        for(int i = 0; i < NUMBER_SEARCHES; i++) {
            int searchFor = (int)(Math.random() * MAX_VALUE);               // create random number
            if (numbers != null) {
                if (binarySearch(numbers, searchFor)) {                     // search array for number
                    count++;                                                // count how many times it is found
                }
            }
        }
        double after = System.currentTimeMillis();                          // end timer
        int time = (int) (after - before);                                  // find how long it took
        System.out.println("Number of items       : " + x);                 // print report
        System.out.println("Times value was found : " + count);
        System.out.println("Total search time     : " + time + " ms");
        System.out.println();
    }

    /**
     * This method creates a loop for each search function that starts from
     * ARRAY_SIZE_START and goes up to and including MAX_ARRAY_SIZE,
     * incrementing by ARRAY_SIZE_INCREMENT. A banner is printed before each
     * function's loop to differentiate between the methods
     * @author Julie Olson a02363064
     * @since Feb 26, 2022
     */
    public static void main(String[] args) {
        System.out.println("--- Linear Search Timing (unsorted) ---");
        for(int i = ARRAY_SIZE_START; i <= MAX_ARRAY_SIZE; i += ARRAY_SIZE_INCREMENT) {
            demoLinearSearchUnsorted(ARRAY_SIZE_START, i);
        }
        System.out.println("--- Linear Search Timing (Selection Sort) ---");
        for(int i = ARRAY_SIZE_START; i <= MAX_ARRAY_SIZE; i += ARRAY_SIZE_INCREMENT) {
            demoLinearSearchSorted(ARRAY_SIZE_START, i);
        }
        System.out.println("--- Binary Search Timing (Selection Sort) ---");
        for(int i = ARRAY_SIZE_START; i <= MAX_ARRAY_SIZE; i += ARRAY_SIZE_INCREMENT) {
            demoBinarySearchSelectionSort(ARRAY_SIZE_START, i);
        }
        System.out.println("--- Binary Search Timing (Arrays.sort) ---");
        for(int i = ARRAY_SIZE_START; i <= MAX_ARRAY_SIZE; i += ARRAY_SIZE_INCREMENT) {
            demoBinarySearchFastSort(ARRAY_SIZE_START, i);
        }
    }

}
