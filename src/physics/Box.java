package Physics;

public class Box extends RectObj implements Movable {

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
        this.setVelX(getVelX() + GRAVITY);
    }

    @Override
    public void stop() {
        if (!statusAir()) {
            double friction = FRICC_FLOOR * this.getWeight();
            if (this.getVelX() > 0) {
                this.setAccX(this.getAccX() - friction);
            } else if (this.getVelX() < 0) {
                this.setAccX(this.getAccX() + friction);
            }
        }

    }

    @Override
    public boolean statusAir() {
        // TODO Auto-generated method stub
        return false;
    }

}
