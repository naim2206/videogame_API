
package game;

import java.awt.Color;
import java.awt.image.BufferStrategy;
import graphics.Window;
import java.awt.Graphics;

/**
 * Class to render images for each type of collisionable object
 * 
 * @author Naim Towfighian and Alejandro Casillas
 */
public abstract class Game implements Runnable {

    protected static BufferStrategy bs;
    protected static Window ventana;
    protected static GameState gameState;
    protected Thread thread;
    protected boolean running;
    protected static Graphics g;

    /**
     * Set parameters to render window
     * 
     * @param width
     * @param height
     */
    public static void draw(int width, int height) {
        bs = ventana.getBufferStrategy();
        if (bs == null) {
            ventana.createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);
        gameState.draw(g);
        g.dispose();
        bs.show();
    }

    /**
     * Start Thread
     * 
     */
    public void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**
     * Update the game State
     */
    public static void update() {
        gameState.update();
    }

    @Override
    public abstract void run();
}
