package physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import game.Assets;
import game.GameState;
import game.Loader;

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
        super(x, y, weight, Material.Stone, velX, velY, accX, accY, radius, Assets.Boulder, gameState);
        // this.setTexture(Assets.Boulder);
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
                // fall();
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
                        // c.setY(c.getY() + 1);
                        // Movable cm = (Movable) c;
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

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform at = AffineTransform.getTranslateInstance((double) getX() - getRadius(),
                (double) getY() - getRadius());

        texture = Loader.resize(texture, (int) getRadius() * 2, (int) getRadius() * 2);

        g2d.drawImage(texture, at, null);

    }

}
