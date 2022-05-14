package main.game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

import game.Assets;
import game.Game;
import game.Keyboard;
import graphics.Window;
import physics.Brick;
import physics.Collisionable;

// public class Game2 implements Runnable {
public class Game2 extends Game {
	// private static GameStates2 gameState;
	private static Keyboard keyboard;
	// private static Window ventana;
	// private static BufferStrategy bs;
	// private static Graphics g;
	// private Thread thread;
	// private boolean running;

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
			draw(GameStates2.width, GameStates2.heigth);
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

			if (siHayBrick == 2) {
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

	public static void main(String[] args) {
		new Game2().start();
	}
}
