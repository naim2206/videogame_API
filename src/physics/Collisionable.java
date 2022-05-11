// 
// Decompiled by Procyon v0.5.36
// 
package Physics;

public abstract class Collisionable {
    private int x;
    private int y;
    // arriba a la izquierda
    private double weight;
    private double velX;
    private double velY;
    private double accX;
    private double accY;
    private final Material material;

    public Collisionable(int x, int y) {
        this(x, y, 20.0, Material.Wood);
    }

    public Collisionable(int x, int y, double weight, Material material) {
        this.velX = 0.0;
        this.velY = 0.0;
        this.accX = 0.0;
        this.accY = 0.0;
        this.setX(x);
        this.setY(y);
        this.weight = weight;
        this.material = material;
    }

    public Collisionable(int x, int y, double weight, Material material, double velX, double velY, double accX,
            double accY) {
        this(x, y, weight, material);
        this.setVelX(velX);
        this.setVelY(velY);
        this.setAccX(accX);
        this.setAccY(accY);
    }

    public abstract boolean checkCollision(Collisionable p0);

    public abstract void impact(Collisionable p0);

    // public abstract void break();
    public abstract void breakObject();

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getVelX() {
        return this.velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return this.velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public double getAccX() {
        return this.accX;
    }

    public void setAccX(double accX) {
        this.accX = accX;
    }

    public double getAccY() {
        return this.accY;
    }

    public void setAccY(double accY) {
        this.accY = accY;
    }

    public Material getMaterial() {
        return this.material;
    }

}
