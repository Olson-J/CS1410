import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

/**
 * creates a demonstration of Conway's game of life
 * @author JulieOlson a02363064
 * @since march 28 2022
 */
public class ConwaysLife {
    /**
     * creates the screen and animations
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public static void main(String[] args) {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();

            TerminalSize size = screen.getTerminalSize();
            LifeSimulator simulation = new LifeSimulator(size.getColumns(), size.getRows());

            screen.startScreen();
            screen.setCursorPosition(null);

            simulation.insertPattern(new PatternBlock(), 12, 0);
            simulation.insertPattern(new PatternGlider(), 2, 2);
            simulation.insertPattern(new PatternBlinker(), 5, 10);
            simulation.insertPattern(new PatternAcorn(), 8, 20);

            for (int i = 0; i < 20; i++) {
                render(simulation, screen, graphics);   // Render the current state of the simulation
                Thread.yield();                         // Let the JVM have some time to update other things
                Thread.sleep(100);                // Sleep for a bit to make for a nicer paced animation
                simulation.update();                    // Tell the simulation to update
            }

            simulation.insertPattern(new PatternBlinker(), 3, 17);
            simulation.insertPattern(new PatternGlider(), 2, 2);

            for (int i = 0; i < 20; i++) {
                render(simulation, screen, graphics);   // Render the current state of the simulation
                Thread.yield();                         // Let the JVM have some time to update other things
                Thread.sleep(100);                // Sleep for a bit to make for a nicer paced animation
                simulation.update();                    // Tell the simulation to update
            }

            screen.stopScreen();
        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }

    /**
     * renders the animation of the patterns between generations
     * @author JulieOlson a02363064
     * @since march 28 2022
     */
    public static void render(LifeSimulator simulation, Screen screen, TextGraphics graphics) {
        screen.clear();
        for (int i = 0; i < simulation.getSizeY(); i++) {
            for (int j = 0; j < simulation.getSizeX(); j++) {
                if (simulation.getCell(j, i)) {
                    graphics.setCharacter(i, j, 'X');
                }
                try {
                    screen.refresh();
                } catch (Exception ex) {
                    System.out.println("uh oh");
                }
            }
        }
    }
}
