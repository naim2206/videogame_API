// 
// Decompiled by Procyon v0.5.36
// 

public abstract class Collisionable
{
    private int x;
    private int y;
    private final double weight;
    private double velX;
    private double velY;
    private double accX;
    private double accY;
    private final Material material;
    
    public Collisionable(final int x, final int y) {
        this(x, y, 20.0, Material.Wood);
    }
    
    public Collisionable(final int x, final int y, final double weight, final Material material) {
        this.velX = 0.0;
        this.velY = 0.0;
        this.accX = 0.0;
        this.accY = 0.0;
        this.setX(x);
        this.setY(y);
        this.weight = weight;
        this.material = material;
    }
    
    public Collisionable(final int x, final int y, final double weight, final Material material, final double velX, final double velY, final double accX, final double accY) {
        this(x, y, weight, material);
        this.setVelX(velX);
        this.setVelY(velY);
        this.setAccX(accX);
        this.setAccY(accY);
    }
    
    public abstract boolean checkCollision(final Collisionable p0);
    
    public abstract void impact(final Collisionable p0);
    
    public int getX() {
        return this.x;
    }
    
    public void setX(final int x) {
        this.x = x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setY(final int y) {
        this.y = y;
    }
    
    public double getWeight() {
        return this.weight;
    }
    
    public double getVelX() {
        return this.velX;
    }
    
    public void setVelX(final double velX) {
        this.velX = velX;
    }
    
    public double getVelY() {
        return this.velY;
    }
    
    public void setVelY(final double velY) {
        this.velY = velY;
    }
    
    public double getAccX() {
        return this.accX;
    }
    
    public void setAccX(final double accX) {
        this.accX = accX;
    }
    
    public double getAccY() {
        return this.accY;
    }
    
    public void setAccY(final double accY) {
        this.accY = accY;
    }
    
    public Material getMaterial() {
        return this.material;
    }
}
