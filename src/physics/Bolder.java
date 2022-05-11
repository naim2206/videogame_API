package physics;

import java.util.ArrayList;

import loader.Assets;

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
            double radius) {
        super(x, y, weight, Material.Stone, velX, velY, accX, accY, radius);
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
    public Bolder(int x, int y, double weight, double radius) {
        super(x, y, weight, Material.Stone, radius);
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
    public void stop(boolean status) {
        this.setAccX(getAccX() - 1);
    }

    @Override
    public boolean statusAir(ArrayList<Collisionable> objectsInGame) {
        return false;
    }

}
