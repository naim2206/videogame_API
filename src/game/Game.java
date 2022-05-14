package game;

import java.awt.Color;
import java.awt.image.BufferStrategy;
import graphics.Window;
import java.awt.Graphics;

public abstract class Game implements Runnable {
    protected static BufferStrategy bs;
    protected static Window ventana;
    protected static GameState gameState;
    protected Thread thread;
    protected boolean running;
    protected static Graphics g;

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

    public void start() // Inicia el hilo
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public static void update() {
        gameState.update();
    }
}
