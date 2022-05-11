package physics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import loader.Assets;

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
            double width, double height) {
        super(x, y, weight, material, velX, velY, accX, accY, width, height);
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
    public Box(int x, int y, double weight, Material material, double width, double height) {
        super(x, y, weight, material, width, height);
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
    public Box(int x, int y, double weight, double width, double height) {
        super(x, y, weight, width, height);
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
        if (!status) {
            double friction = FRICC_FLOOR * this.getWeight();
            if (this.getVelX() > 0) {
                this.setAccX(this.getAccX() - friction);
            } else if (this.getVelX() < 0) {
                this.setAccX(this.getAccX() + friction);
            }
        }

    }

    @Override
    public boolean statusAir(ArrayList<Collisionable> objectsInGame) {
        for (Collisionable obj : objectsInGame)
            if (this.checkCollision(obj))
                return true;
        return false;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

}
