/**
 * Class for Box objects (Rectangular and movable)
 * @author Naim Towfighian and Alejandro Casillas
 */

package physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import game.Assets;
import game.GameState;
import game.Loader;

public class Box extends RectObj implements Movable {

    private BufferedImage texture = Assets.WoodBox;

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
     * @param width     width of the circle
     * @param height    height of the circle
     * @param gameState state of the game where object was created
     */
    public Box(int x, int y, double weight, Material material, double velX, double velY, double accX, double accY,
            double width, double height, GameState gameState) {
        super(x, y, weight, material, velX, velY, accX, accY, width, height, gameState);
        if (material == Material.Stone)
            this.setTexture(Assets.StoneBox);
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
     * Basic constructor with material
     * defaults: in rest
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param material  material of the object
     * @param width     width of the circle
     * @param height    height of the circle
     * @param gameState state of the game where object was created
     */
    public Box(int x, int y, double weight, Material material, double width, double height, GameState gameState) {
        super(x, y, weight, material, width, height, gameState);
        if (material == Material.Stone)
            this.setTexture(Assets.StoneBox);
    }

    /**
     ** Basic constructor
     * defaults: material = Wood, in rest
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param width     width of the rectangle
     * @param height    height of the rectangle
     * @param gameState state of the game where object was created
     */
    public Box(int x, int y, double weight, double width, double height, GameState gameState) {
        super(x, y, weight, width, height, gameState);
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
        double friction = FRICC_FLOOR * this.getWeight();
        if (this.getVelX() > 0) {
            this.setAccX(this.getAccX() - friction);
        } else if (this.getVelX() < 0) {
            this.setAccX(this.getAccX() + friction);
        }
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
        AffineTransform at = AffineTransform.getTranslateInstance((double) getX(),
                (double) getY());
        texture = Loader.resize(texture, (int) getWidth(), (int) getHeight());
        g2d.drawImage(texture, at, null);
    }
}
