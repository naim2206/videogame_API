// 
// Decompiled by Procyon v0.5.36
// 

public class RectObj extends Collisionable
{
    private double width;
    private double height;
    
    public RectObj(final int x, final int y, final double weight, final Material material, final double velX, final double velY, final double accX, final double accY, final double width, final double height) {
        super(x, y, weight, material, velX, velY, accX, accY);
        this.setWidth(width);
        this.setHeight(height);
    }
    
    public RectObj(final int x, final int y, final double weight, final Material material, final double width, final double height) {
        super(x, y, weight, material);
        this.setWidth(width);
        this.setHeight(height);
    }
    
    public RectObj(final int x, final int y, final double weight, final double width, final double height) {
        super(x, y);
        this.setWidth(width);
        this.setHeight(height);
    }
    
    public boolean checkCollision(final Collisionable obj) {
        if (obj instanceof RectObj) {
            return this.checkCollisionRect((RectObj)obj);
        }
        return obj instanceof CircleObj && this.checkCollisionCircle((CircleObj)obj);
    }
    
    private boolean checkCollisionRect(final RectObj obj) {
        boolean collision = false;
        if (this.getX() < obj.getX() + obj.getWidth() && this.getX() + this.getWidth() > obj.getX() && this.getY() < obj.getY() + obj.getHeight() && this.getY() + this.getHeight() > obj.getY()) {
            collision = true;
        }
        return collision;
    }
    
    private boolean checkCollisionCircle(final CircleObj obj) {
        return false;
    }
    
    public void impact(final Collisionable obj) {
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public void setWidth(final double width) {
        this.width = width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setHeight(final double height) {
        this.height = height;
    }
}
