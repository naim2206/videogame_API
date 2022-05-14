package physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import game.GameState;
import game.Loader;

public abstract class Player extends CircleObj implements Movable {

	protected boolean created = false; // singleton
	protected double angle = 0;
	protected BufferedImage texture;
	protected Player player;

	public Player(int x, int y, double weight, double velX, double velY, double accX, double accY,
			double radius, BufferedImage texture, GameState gamestate) {
		super(x, y, weight, Material.Wood, velX, velY, accX, accY, radius, texture, gamestate);
		this.texture = texture;
		this.gameState = gamestate;
	}

	public Player(int x, int y, double weight, double radius, BufferedImage texture, GameState gamestate) {
		super(x, y, weight, Material.Wood, radius, gamestate);
		this.texture = texture;
		this.gameState = gamestate;
	}

	public abstract void moveByPlayer();

	public void destroy() {
		gameState.getColObjects().remove(this);
	}

	public void fall() {
		if (MAX_SPEED_Y > getVelY())
			this.setVelY(getVelY() + GRAVITY + getAccY());
	}

	@Override
	public void stop() {
		this.setAccX(getAccX() - 1);
	}

	public void move() {

		// this.setVelX(getVelX() + getAccX());
		// this.setVelY(getVelY() + getAccY());

		this.setX(Math.round((float) (this.getX() + this.getVelX())));
		this.setY(Math.round((float) (this.getY() + this.getVelY())));

		// System.out.println(Math.round((float) (this.getX() + this.getVelX())));
		// System.out.printf("Moving X = %d Y = %d\n", getX(),getY());
		// System.out.printf("Vel X = %f, Y = %f\n", getVelX(),getVelY());
	}

	public void update() {
		this.moveByPlayer();
		fall();
		this.move();
		stop();

		stop();
		// for (Collisionable c : gameState.getColObjects()) {
		for (int i = 0; i < gameState.getColObjects().size(); i++) {
			Collisionable c = gameState.getColObjects().get(i);
			if (c.equals(this)) {
				continue;
			}

			if (this.checkCollision(c)) {
				// System.out.println("colision de player");

				if (this.breakObject(c)) {
					destroy();
					break;
				} else {
					impact(this, c);
					if (c instanceof Movable) {
						// if (this.getVelY() > 0) {
						// this.setY(this.getY() - 1);
						// c.setY(c.getY() + 1);
						// }
						// if (this.getVelY() < 0) {
						// this.setY(this.getY() + 1);
						// c.setY(c.getY() - 1);
						// }
						// if (this.getVelX() > 0) {
						// this.setX(this.getX() - 1);
						// c.setX(c.getX() + 1);
						// }
						// if (this.getVelX() < 0) {
						// this.setX(this.getX() + 1);
						// c.setX(c.getX() - 1);
						// }

						if (this.getVelY() > 0)
							this.setY(this.getY() - 1);
						if (this.getVelY() < 0)
							this.setY(this.getY() + 1);
						if (this.getVelX() > 0)
							this.setX(this.getX() - 1);
						if (this.getVelX() < 0)
							this.setX(this.getX() + 1);
						// cm.move();

					}
					this.move();
				}
				if (c.breakObject(this)) {
					c.destroy();
					continue;
				}

			}

			// fall();

		}

		// this.move();

		// stop();

	}

	public void draw(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		AffineTransform at = AffineTransform.getTranslateInstance((double) getX() - getRadius(),
				(double) getY() - getRadius());

		/*
		 * if( this.getAccX() > 0) {
		 * angle += 0.1;
		 * at.rotate(angle, getRadius(), getRadius());
		 * }
		 * 
		 * if( this.getAccX() < 0) {
		 * angle -= 0.1;
		 * at.rotate(angle, getRadius(), getRadius());
		 * }
		 */
		texture = Loader.resize(texture, (int) getRadius() * 2, (int) getRadius() * 2);

		g2d.drawImage(texture, at, null);

	}

}
