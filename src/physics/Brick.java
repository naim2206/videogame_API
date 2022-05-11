package physics;

import java.awt.image.BufferedImage;

import loader.Assets;

public class Brick extends RectObj {

    private BufferedImage texture = Assets.WoodBrick;

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
    public Brick(int x, int y, double weight, Material material, double velX, double velY, double accX, double accY,
            double width, double height) {
        super(x, y, weight, material, velX, velY, accX, accY, width, height);
        if (material == Material.Stone)
            this.setTexture(Assets.StoneBrick);
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
    public Brick(int x, int y, double weight, Material material, double width, double height) {
        super(x, y, weight, material, width, height);
        if (material == Material.Stone)
            this.setTexture(Assets.StoneBrick);
    }

    /**
     * @param x
     * @param y
     * @param weight
     * @param width
     * @param height
     */
    public Brick(int x, int y, double weight, double width, double height) {
        super(x, y, weight, width, height);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

}
