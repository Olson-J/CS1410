/**
 * creates template for the acorn pattern
 * @author JulieOlson a02363064
 * @since march 28 2022
 */
public class PatternAcorn extends Pattern{
    @Override
    public int getSizeX() {
        return 7;
    }
    @Override
    public int getSizeY() {
        return 3;
    }

    @Override
    public boolean getCell(int x, int y) {
        return acorn[y][x];
    };

    boolean [][] acorn = {{false, true, false, false, false, false, false},
                            {false, false, false, true, false, false, false},
                            {true, true, false, false, true, true, true}};
}

