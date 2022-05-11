// 
// Decompiled by Procyon v0.5.36
// 
package physics;

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
    public static final int WOOD_BREAK_SPEED = 100;
    public static final int STONE_BREAK_SPEED = 25;

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

    public boolean breakObject(Collisionable p0) {
        if (this.material == Material.Stone)
            return false;
        if (p0.material == Material.Wood) {
            // no se rompe mucho
            if (this.getVelX() + this.getVelY() + p0.getVelX() + p0.getVelY() > WOOD_BREAK_SPEED)
                return true;
            return false;
        }
        // se rompe bastante
        if (this.getVelX() + this.getVelY() + p0.getVelX() + p0.getVelY() > STONE_BREAK_SPEED)
            return true;
        return false;
    }

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
