/**
 * handles the mechanics of the game and patterns
 * @author JulieOlson a02363064
 * @since march 28 2022
 */
public class LifeSimulator {
    private final int SizeX;
    private final int SizeY;
    boolean [][] world;

    /**
     * constructor, creates an array the size of the screen
     * the game is to be displayed on
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public LifeSimulator(int sizeX, int sizeY) {
        this.SizeX = sizeX;
        this.SizeY = sizeY;
        this.world = new boolean[this.SizeY][this.SizeX];
    }

    /**
     * returns the width of the world
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public int getSizeX() {return this.SizeX;}

    /**
     * return height of the world
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public int getSizeY() {return this.SizeY;}

    /**
     * return true if cell is alive and false if dead
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public boolean getCell(int x, int y) {
        if (x >=0 && x <= SizeX && y >=0 && y <= SizeY) {
            return this.world[y][x];
        }
        return false;
    }

    /**
     * tests to determine how many alive neighbor cells a cell has
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public int testBuddies(int x, int y) {
        int buddyCount = 0;
        if (x == 15 && y == 15) {
            System.out.print("");
        }
        if (!(y - 1 >= 0)) {        // if on top edge
            if (!(x - 1 >= 0)) {    // if on left border
                if (this.world[y][x + 1]) {buddyCount++;}        // same row, right
                if (this.world[y + 1][x]) {buddyCount++;}        // directly down
                if (this.world[y + 1][x + 1]) {buddyCount++;}    // down and right diagonal

            }
            else if (!(x + 1 < this.SizeX)) {   // if on right edge
                if (this.world[y][x - 1]) {buddyCount++;}        // same row, left
                if (this.world[y + 1][x - 1]) {buddyCount++;}    // down and left diagonal
                if (this.world[y + 1][x]) {buddyCount++;}        // directly down
            }
            else {                                               // middle of top row
                if (this.world[y][x - 1]) {buddyCount++;}        // same row, left
                if (this.world[y][x + 1]) {buddyCount++;}        // same row, right
                if (this.world[y + 1][x - 1]) {buddyCount++;}    // down and left diagonal
                if (this.world[y + 1][x]) {buddyCount++;}        // directly down
                if (this.world[y + 1][x + 1]) {buddyCount++;}    // down and right diagonal
            }
        }
        else if (!(y + 1 < this.SizeY)) {       // if on bottom edge
            if (!(x - 1 >= 0)) {                // if on left border
                if (this.world[y - 1][x]) {buddyCount++;}        // directly up
                if (this.world[y - 1][x + 1]) {buddyCount++;}    // up and right diagonal
                if (this.world[y][x + 1]) {buddyCount++;}        // same row, right
            }
            else if (!(x + 1 < this.SizeX)) {       // if on right border
                if (this.world[y - 1][x - 1]) {buddyCount++;}    // up and left diagonal
                if (this.world[y - 1][x]) {buddyCount++;}        // directly up
                if (this.world[y][x - 1]) {buddyCount++;}        // same row, left
            }
            else {                                               // middle of bottom row
                if (this.world[y - 1][x - 1]) {buddyCount++;}    // up and left diagonal
                if (this.world[y - 1][x]) {buddyCount++;}        // directly up
                if (this.world[y - 1][x + 1]) {buddyCount++;}    // up and right diagonal
                if (this.world[y][x - 1]) {buddyCount++;}        // same row, left
                if (this.world[y][x + 1]) {buddyCount++;}        // same row, right
            }
        }
        else {                                              // if in middle
            if (!(x - 1 >= 0)) {                            // if on left border
                if (this.world[y - 1][x]) {buddyCount++;}        // directly up
                if (this.world[y - 1][x + 1]) {buddyCount++;}    // up and right diagonal
                if (this.world[y][x + 1]) {buddyCount++;}        // same row, right
                if (this.world[y + 1][x]) {buddyCount++;}        // directly down
                if (this.world[y + 1][x + 1]) {buddyCount++;}    // down and right diagonal
            }
            else if (!(x + 1 < this.SizeX)) {       // if on right border
                if (this.world[y - 1][x - 1]) {buddyCount++;}    // up and left diagonal
                if (this.world[y - 1][x]) {buddyCount++;}        // directly up
                if (this.world[y][x - 1]) {buddyCount++;}        // same row, left
                if (this.world[y + 1][x - 1]) {buddyCount++;}    // down and left diagonal
                if (this.world[y + 1][x]) {buddyCount++;}        // directly down
            }
            else {                                  // middle no edges
                if (this.world[y - 1][x - 1]) {buddyCount++;}    // up and left diagonal
                if (this.world[y - 1][x]) {buddyCount++;}        // directly up
                if (this.world[y - 1][x + 1]) {buddyCount++;}    // up and right diagonal
                if (this.world[y][x - 1]) {buddyCount++;}        // same row, left
                if (this.world[y][x + 1]) {buddyCount++;}        // same row, right
                if (this.world[y + 1][x - 1]) {buddyCount++;}    // down and left diagonal
                if (this.world[y + 1][x]) {buddyCount++;}        // directly down
                if (this.world[y + 1][x + 1]) {buddyCount++;}    // down and right diagonal
            }
        }
        return buddyCount;
    }

    /**
     * adds a pattern into world, starting positions are in the top left
     * corner of the pattern
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public void insertPattern(Pattern pattern, int startX, int startY) {
        for (int i = 0; i < pattern.getSizeY(); i++) {           // go through cell by cell and copy into original
            for (int j = 0; j < pattern.getSizeX(); j++) {
                this.world[i + startY][j + startX] = pattern.getCell(j, i);
            }
        }
    }

    /**
     * determines which cells live on to the next generation,
     * and update the array accordingly
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public void update() {
        // make a 2-D array of the same size as the current grid
        boolean [][] update = new boolean[this.SizeY][this.SizeX];

        for (int row = 0; row < this.SizeX; row++) {           // go through cell by cell and determine life
            for (int col = 0; col < this.SizeY; col++) {
                update[col][row] = false;                           // default to false
                if (this.world[col][row]){                          // if cell is alive
                    if (testBuddies(row, col) == 2 || testBuddies(row, col) == 3) {    // and has 2-3 alive buddies
                        update[col][row] = true;                    // cell lives
                    }
                }
                if (!this.world[col][row]) {                        // if cell is dead
                    update[col][row] = (testBuddies(row, col) == 3);      // if 3 neighbor cells are alive, cell lives
                }
            }
        }
        this.world = update;
    }
}