package physics;

import loader.Assets;
import states.GameState;

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
    }

    @Override
    public void move() {
        this.setX(Math.round((float) (this.getX() + this.getVelX())));
        this.setY(Math.round((float) (this.getY() + this.getVelY())));
    }

    @Override
    public void fall() {
        this.setVelY(getVelY() + GRAVITY);
    }

    @Override
    public void stop() {
        this.setAccX(getAccX() - 1);
    }

}
