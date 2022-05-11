package Physics;

public class Bolder extends CircleObj implements Movable {

    /**
     * @param x
     * @param y
     * @param weight
     * @param material
     * @param velX
     * @param velY
     * @param accX
     * @param accY
     * @param radius
     */
    public Bolder(int x, int y, double weight, Material material, double velX, double velY, double accX, double accY,
            double radius) {
        super(x, y, weight, material, velX, velY, accX, accY, radius);
    }

    /**
     * @param x
     * @param y
     * @param weight
     * @param material
     * @param radius
     */
    public Bolder(int x, int y, double weight, Material material, double radius) {
        super(x, y, weight, material, radius);
    }

    /**
     * @param x
     * @param y
     * @param weight
     * @param ratius
     */
    public Bolder(int x, int y, double weight, double ratius) {
        super(x, y, weight, ratius);
    }

    @Override
    public void move() {
        this.setX(Math.round((float) (this.getX() + this.getVelX())));
        this.setY(Math.round((float) (this.getY() + this.getVelY())));
    }

    @Override
    public void fall() {
        this.setVelX(getVelX() + GRAVITY);
    }

    @Override
    public void stop() {
    }

    @Override
    public boolean statusAir() {
        return false;
    }

}
