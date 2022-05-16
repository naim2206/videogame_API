
package physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import game.Assets;
import game.GameState;
import game.Loader;

/**
 * Class for Bolder objects (circle, stone and movable)
 * 
 * @author Naim Towfighian and Alejandro Casillas
 */
public class Bolder extends CircleObj implements Movable {

    private BufferedImage texture = Assets.Boulder;

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
     * @param gameState state of the game where object was created
     */
    public Bolder(int x, int y, double weight, double velX, double velY, double accX, double accY,
            double radius, GameState gameState) {
        super(x, y, weight, Material.Stone, velX, velY, accX, accY, radius, Assets.Boulder, gameState);
    }

    /**
     * 
     * @return texture
     */
    public BufferedImage getTexture() {
        return texture;
    }

    /**
     * 
     * @param texture
     */
    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    /**
     * Basic constructor
     * defaults: material = Wood, in rest
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param radius    radius of the circle
     * @param gameState state of the game where object was created
     */
    public Bolder(int x, int y, double weight, double radius, GameState gameState) {
        super(x, y, weight, Material.Stone, radius, gameState);
        this.setTexture(Assets.Boulder);

    }

    @Override
    public void move() {
        this.setX(Math.round((float) (this.getX() + this.getVelX())));
        this.setY(Math.round((float) (this.getY() + this.getVelY())));
    }

    @Override
    public void fall() {
        this.setVelY(getVelY() + getAccY() + GRAVITY);
    }

    @Override
    public void stop() {
        this.setAccX(getAccX() - 1);
    }

    @Override
    public void destroy() {
        gameState.getColObjects().remove(this);
    }

    @Override
    public void update() {
        fall();
        this.move();
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
