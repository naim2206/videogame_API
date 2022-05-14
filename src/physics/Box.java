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

        AffineTransform at = AffineTransform.getTranslateInstance((double) getX(),
                (double) getY());
        // AffineTransform at = AffineTransform.getTranslateInstance((double) getX() +
        // getWidth() / 2,
        // (double) getY() + getHeight() / 2);

        texture = Loader.resize(texture, (int) getWidth(), (int) getHeight());

        g2d.drawImage(texture, at, null);

    }

}
