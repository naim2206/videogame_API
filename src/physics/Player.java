
package physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import game.GameState;
import game.Loader;

/**
 * Class for Player objects (Circular, movable and wood)
 * 
 * @author Naim Towfighian and Alejandro Casillas
 */
public abstract class Player extends CircleObj implements Movable {

	protected BufferedImage texture;

	/**
	 * Constructor with all parameters
	 * 
	 * @param x         X position of the object
	 * @param y         Y position of the object
	 * @param weight    weight of the object
	 * @param velX      initial horizontal velocity
	 * @param velY      initial vertical velocity
	 * @param accX      initial horizontal acceleration
	 * @param accY      initial vertical acceleration
	 * @param radius    radius of the circle
	 * @param texture   image to render
	 * @param gameState state of the game where object was created
	 */
	public Player(int x, int y, double weight, double velX, double velY, double accX, double accY,
			double radius, BufferedImage texture, GameState gamestate) {
		super(x, y, weight, Material.Wood, velX, velY, accX, accY, radius, texture, gamestate);
		this.texture = texture;
		this.gameState = gamestate;
	}

	/**
	 * Basic constructor
	 * defaults: material = Wood, in rest
	 * 
	 * @param x         X position of the object
	 * @param y         Y position of the object
	 * @param weight    weight of the object
	 * @param radius    radius of the circle
	 * @param texture   image to render
	 * @param gameState state of the game where object was created
	 */
	public Player(int x, int y, double weight, double radius, BufferedImage texture, GameState gamestate) {
		super(x, y, weight, Material.Wood, radius, gamestate);
		this.texture = texture;
		this.gameState = gamestate;
	}

	/**
	 * Change player position by user
	 */
	public abstract void moveByPlayer();

	@Override
	public void destroy() {
		gameState.getColObjects().remove(this);
	}

	@Override
	public void fall() {
		if (MAX_SPEED_Y > getVelY())
			this.setVelY(getVelY() + GRAVITY + getAccY());
	}

	@Override
	public void stop() {
		this.setAccX(getAccX() - 1);
	}

	@Override
	public void move() {
		this.setX(Math.round((float) (this.getX() + this.getVelX())));
		this.setY(Math.round((float) (this.getY() + this.getVelY())));
	}

	@Override
	public void update() {
		this.moveByPlayer();
		fall();
		this.move();
		stop();
		stop();
		for (int i = 0; i < gameState.getColObjects().size(); i++) {
			Collisionable c = gameState.getColObjects().get(i);
			if (c.equals(this)) {
				continue;
			}
			if (this.checkCollision(c)) {
				if (this.breakObject(c)) {
					destroy();
					break;
				} else {
					impact(this, c);
					if (c instanceof Movable) {
						if (this.getVelY() > 0)
							this.setY(this.getY() - 1);
						if (this.getVelY() < 0)
							this.setY(this.getY() + 1);
						if (this.getVelX() > 0)
							this.setX(this.getX() - 1);
						if (this.getVelX() < 0)
							this.setX(this.getX() + 1);
					}
					this.move();
				}
				if (c.breakObject(this)) {
					c.destroy();
					continue;
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = AffineTransform.getTranslateInstance((double) getX() - getRadius(),
				(double) getY() - getRadius());
		texture = Loader.resize(texture, (int) getRadius() * 2, (int) getRadius() * 2);
		g2d.drawImage(texture, at, null);
	}
}
