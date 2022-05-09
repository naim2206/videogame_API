// 
// Decompiled by Procyon v0.5.36
// 
package Physics;


public class RectObj extends Collisionable {
    private double width;
    private double height;

    public RectObj(int x, int y, double weight, Material material, double velX,
            double velY, double accX, double accY, double width, double height) {
        super(x, y, weight, material, velX, velY, accX, accY);
        this.setWidth(width);
        this.setHeight(height);
    }

    public RectObj(int x, int y, double weight, Material material, double width,
            double height) {
        super(x, y, weight, material);
        this.setWidth(width);
        this.setHeight(height);
    }

    public RectObj(int x, int y, double weight, double width, double height) {
        super(x, y);
        this.setWidth(width);
        this.setHeight(height);
    }

    public boolean checkCollision(Collisionable obj) {
        if (obj instanceof RectObj) {
            return this.checkCollisionRect((RectObj) obj);
        }
        return obj instanceof CircleObj && this.checkCollisionCircle((CircleObj) obj);
    }

    private boolean checkCollisionRect(RectObj obj) {
        boolean collision = false;
        if (this.getX() < obj.getX() + obj.getWidth() && this.getX() + this.getWidth() > obj.getX()
                && this.getY() < obj.getY() + obj.getHeight() && this.getY() + this.getHeight() > obj.getY()) {
            collision = true;
        }
        return collision;
    }

    private boolean checkCollisionCircle(CircleObj obj) {
        int recCenterX = (int) (this.getX() + this.getWidth() / 2.0);
        int recCenterY = (int) (this.getY() + this.getHeight() / 2.0);

        float dx = Math.abs(obj.getX() - (float) recCenterX);
        float dy = Math.abs(obj.getY() - (float) recCenterY);

        if (dx > (this.getWidth() / 2.0 + obj.getRadius())) {
            return false;
        }
        if (dy > (this.getHeight() / 2.0 + obj.getRadius())) {
            return false;
        }

        // aki le cambiamos porque staba raro
        if (dx <= (this.getWidth() / 2.0) + obj.getRadius()) {
            return true;
        }
        if (dy <= (this.getHeight() / 2.0) + obj.getRadius()) {
            return true;
        }

        double cornerDistanceSq = (dx - this.getWidth() / 2.0) * (dx - this.getWidth() / 2.0) +
                (dy - this.getHeight() / 2.0) * (dy - this.getHeight() / 2.0);

        return (cornerDistanceSq <= (obj.getRadius() * obj.getRadius()));
    }

    public void impact(Collisionable obj) {
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
