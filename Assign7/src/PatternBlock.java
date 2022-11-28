/**
 * creates template for the block pattern
 * @author JulieOlson a02363064
 * @since march 28 2022
 */
public class PatternBlock extends Pattern{
    @Override
    public int getSizeX() {
        return 2;
    }

    @Override
    public int getSizeY() {
        return 2;
    }

    @Override
    public boolean getCell(int x, int y) {
        return block[y][x];
    }
    boolean [][] block = {{true, true},{true, true}};
}
