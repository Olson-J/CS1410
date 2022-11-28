/**
 * creates template for the blinker pattern
 * @author JulieOlson a02363064
 * @since march 28 2022
 */
public class PatternBlinker extends Pattern{
    @Override
    public int getSizeX() {
        return 1;
    }

    @Override
    public int getSizeY() {
        return 3;
    }

    @Override
    public boolean getCell(int x, int y) {
        return blinker[y][x];
    }
    boolean [][] blinker = {{true}, {true}, {true}};
}
