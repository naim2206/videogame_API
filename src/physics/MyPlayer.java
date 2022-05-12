package physics;

import java.awt.image.BufferedImage;

import input.Keyboard;
import states.GameState;

public class MyPlayer extends Player {

	public MyPlayer(int x, int y, double weight, double velX, double velY, double accX, double accY, double radius,
			BufferedImage texture, GameState gameState) {
		super(x, y, weight, velX, velY, accX, accY, radius, texture, gameState);
		// TODO Auto-generated constructor stub
	}

	public MyPlayer(int x, int y, double weight, double radius, BufferedImage texture, GameState gameState) {
		super(x, y, weight, radius, texture, gameState);
		// TODO Auto-generated constructor stub

		setVelX(0);
		setVelY(0);
	}

	@Override
	public void moveByPlayer() {

		if (getX() > 500) {
			setX(0);
		}
		if (getY() > 700) {
			setY(0);
		}

		if (getX() < 0) {
			setX(500);
		}

		if (getY() < 0) {
			setY(700);
		}

		if (Keyboard.RIGHT && (MAX_SPEED_X > getVelX())) {
			this.setVelX(getVelX() + 0.5);
			// move();

			this.setX((int) (getX() + 5));
			return;
		}

		if (Keyboard.LEFT && (-MAX_SPEED_X < getVelX())) {
			this.setVelX(getVelX() - 0.5);
			// move();

			this.setX((int) (getX() - 5));
			return;
		}

		if (Keyboard.UP && (-MAX_SPEED_Y < getVelY())) {
			// this.setVelX(0);
			this.setVelY(getVelY() - 0.5);

			this.setY((int) (getY() - 5));
			return;
		}

		else {
			this.setAccX(0);
			this.setAccY(0);
		}

	}

}
