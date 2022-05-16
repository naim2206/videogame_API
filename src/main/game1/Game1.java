package main.game1;

import java.awt.Color;

import javax.swing.JOptionPane;

import game.Assets;
import game.Game;
import game.Keyboard;
import graphics.Window;
import physics.Bolder;
import physics.Collisionable;

public class Game1 extends Game {

	private static Keyboard keyboard;
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
		Init();

		while (running) {

			update();
			draw(GameState1.width, GameState1.heigth);
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

	public static void main(String[] args) {
		new Game1().start();

	}

}
