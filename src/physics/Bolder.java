package physics;

import loader.Assets;
import loader.Loader;
import states.GameState;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.Graphics;

import java.awt.image.BufferedImage;

public class Bolder extends CircleObj implements Movable {

    private BufferedImage texture = Assets.Boulder;

    /**
     * @param x
     * @param y
     * @param weight
     * @param velX
     * @param velY
     * @param accX
     * @param accY
     * @param radius
     */
    public Bolder(int x, int y, double weight, double velX, double velY, double accX, double accY,
            double radius, GameState gameState) {
        super(x, y, weight, Material.Stone, velX, velY, accX, accY, radius, gameState);
        this.setTexture(Assets.Boulder);
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    /**
     * @param x
     * @param y
     * @param weight
     * @param radius
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

    public void destroyBoulder() {
        gameState.getColObjects().remove(this);
    }

    @Override
    public void update() {
        this.move();
        stop();
        fall();
        boolean status = true; // Air status
        for (Collisionable c : gameState.getColObjects()) {

            if (c.equals(this)) {
                fall();
                continue;
            }

            if (this.checkCollision(c)) {
                status = false;

                if (this.breakObject(c)) {
                    destroyBoulder();
                    break;
                } else {
                    impact(this, c);
                    this.move();
                }

            }

            // fall();

        }

        // this.move();

        // stop();

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
