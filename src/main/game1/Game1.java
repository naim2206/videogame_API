package main.game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

import game.Assets;
import game.Keyboard;
import graphics.Window;
import physics.Bolder;
import physics.Collisionable;

public class Game1 implements Runnable {

	private static GameState1 gameState;
	private static Keyboard keyboard;
	private static Window ventana;
	private static BufferStrategy bs;
	private static Graphics g;
	private Thread thread;
	private boolean running;
	private long time;
	private long delta;

	public Game1() {
		running = false;
		this.time = System.currentTimeMillis();
	}

	public static void Init() {
		ventana = new Window("Jueguito", GameState1.width, GameState1.heigth, Color.CYAN);
		Assets.init();
		gameState = new GameState1();
		keyboard = ventana.getKeyboard();

	}

	@Override
	public void run() {

		// long now = 0; // Reg del tiempo
		// long lastTime = System.nanoTime();
		// int frames = 0;
		// long time = 0;
		// long delta = 0;
		// int FPS = 60;
		// int AVERAGEFPS = FPS;
		// double TARGETTIME = 1000000000.0 / FPS; // 1s/FPS

		Init();

		while (running) {

			update();
			draw();
			boolean siHay = false;
			for (Collisionable c : gameState.getColObjects()) {
				if (c instanceof Bolder) {
					Bolder cB = (Bolder) c;
					this.delta = System.currentTimeMillis();
					siHay = true;
					if (cB.getY() >= GameState1.heigth - 25 - cB.getRadius() - 20) {
						JOptionPane.showMessageDialog(null, "Game over", "You lost", JOptionPane.ERROR_MESSAGE);
						siHay = false;
						break;
					}
				}
			}

			if (!siHay) {
				break;
			}

			try {
				Thread.sleep(17l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null,
				"Your game time was: " + (this.delta - this.time) / 1000 + " seconds", "Time",
				JOptionPane.INFORMATION_MESSAGE);
		ventana.setVisible(false);
		ventana.dispose();

	}

	public static void update() {
		keyboard.update();
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
		g.fillRect(0, 0, GameState1.width, GameState1.heigth);

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

	// private void stop() // Termina el hilo
	// {
	// try {
	// thread.join();
	// running = false;
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }

	// }

	public static void main(String[] args) {

		new Game1().start();

	}

}
