package main.game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

import game.Assets;
import game.Keyboard;
import graphics.Window;
import physics.Brick;
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
		keyboard = ventana.getKeyboard();

	}

	@Override
	public void run() {
		Init();
		while (running) {
			update();
			draw();
			boolean siHayPlayer = false;
			int siHayBrick = 0;
			for (Collisionable c : gameState.getColObjects()) {
				if (c instanceof Brick) {
					siHayBrick++;
				}
				if (c instanceof MyPlayer2) {
					siHayPlayer = true;
				}
			}
			if (!siHayPlayer) {
				JOptionPane.showMessageDialog(null, "You lost", "You lost", JOptionPane.ERROR_MESSAGE);
				break;
			}
			if (siHayBrick == 1) {
				JOptionPane.showMessageDialog(null, "You win", "Win", JOptionPane.INFORMATION_MESSAGE);
				break;
			}

			try {
				Thread.sleep(17l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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