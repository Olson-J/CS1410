/**
 * superclass for patterns
 * @author JulieOlson a02363064
 * @since march 28 2022
 */
public abstract class Pattern {
    public abstract int getSizeX();     // returns width in cells
    public abstract int getSizeY();     // returns height in cells
    public abstract boolean getCell(int x, int y);
                            // returns true if cell is filled
}
