package physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import loader.Assets;
import loader.Loader;
import states.GameState;

public class Box extends RectObj implements Movable {

    private BufferedImage texture = Assets.WoodBox;

    /**
     * @param x
     * @param y
     * @param weight
     * @param material
     * @param velX
     * @param velY
     * @param accX
     * @param accY
     * @param width
     * @param height
     */
    public Box(int x, int y, double weight, Material material, double velX, double velY, double accX, double accY,
            double width, double height, GameState gameState) {
        super(x, y, weight, material, velX, velY, accX, accY, width, height, gameState);
        if (material == Material.Stone)
            this.setTexture(Assets.StoneBox);
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
     * @param material
     * @param width
     * @param height
     */
    public Box(int x, int y, double weight, Material material, double width, double height, GameState gameState) {
        super(x, y, weight, material, width, height, gameState);
        if (material == Material.Stone)
            this.setTexture(Assets.StoneBox);
    }

    /**
     * @param x
     * @param y
     * @param weight
     * @param width
     * @param height
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
        this.setVelY(getVelY() + GRAVITY + getAccY());
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

    public void destroyBox() {
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
                    destroyBox();
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

        AffineTransform at = AffineTransform.getTranslateInstance((double) getX(),
                (double) getY());
        // AffineTransform at = AffineTransform.getTranslateInstance((double) getX() +
        // getWidth() / 2,
        // (double) getY() + getHeight() / 2);

        texture = Loader.resize(texture, (int) getWidth(), (int) getHeight());

        g2d.drawImage(texture, at, null);

    }

}
