package Physics;

public class Brick extends RectObj {

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

}
