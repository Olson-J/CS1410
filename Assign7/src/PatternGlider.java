/**
 * creates template for the glider pattern
 * @author JulieOlson a02363064
 * @since march 28 2022
 */
public class PatternGlider extends Pattern{
    @Override
    public int getSizeX() {
        return 5;
    }

    @Override
    public int getSizeY() {
        return 3;
    }

    @Override
    public boolean getCell(int x, int y) {
        return glider[y][x];
    }
    boolean [][] glider = {{false, false, true, false, false},
            {true, false, true, false, false},
            {false, true, true, false, false}};
}
