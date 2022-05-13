package main.game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

import game.Assets;
import game.Keyboard;
import graphics.Window;
import physics.Collisionable;

public class Game2 implements Runnable {
	private static GameStates2 gameState;
	private static Keyboard keyboard;
	private static Window ventana;
	private static BufferStrategy bs;
	private static Graphics g;
	private Thread thread;
	private boolean running;
	private long time;
	private long delta;

	public Game2() {
		running = false;
	}

	public static void Init() {
		ventana = new Window("Jueguito", GameStates2.width, GameStates2.heigth,
				Color.CYAN);
		Assets.init();
		gameState = new GameStates2();
		// keyboard = ventana.getKeyboard();

	}

	@Override
	public void run() {
		Init();
		while (running) {
			update();
			draw();
			try {
				Thread.sleep(17l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void update() {
		// keyboard.update();
		gameState.update();
	}

	private static void draw() {

		bs = ventana.getBufferStrategy();
		if (bs == null) {
			ventana.createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();

		// ------------------------

		g.setColor(Color.black);
		g.fillRect(0, 0, GameStates2.width, GameStates2.heigth);

		gameState.draw(g);

		/*
		 * g.setColor(Color.white);
		 * g.drawString("FPS = "+AVERAGEFPS, 0, 10);
		 */
		// ------------------------

		g.dispose();
		bs.show();

	}

	private void start() // Inicia el hilo
	{

		thread = new Thread(this);
		thread.start();

		running = true;
	}

	private void stop() // Termina el hilo
	{
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new Game2().start();

	}

}
