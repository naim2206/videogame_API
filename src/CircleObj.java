// 
// Decompiled by Procyon v0.5.36
// 

public class CircleObj extends Collisionable
{
    public CircleObj(final int x, final int y) {
        super(x, y);
    }
    
    public CircleObj(final int x, final int y, final double weight, final Material material) {
        super(x, y, weight, material);
    }
    
    public CircleObj(final int x, final int y, final double weight, final Material material, final double velX, final double velY, final double accX, final double accY) {
        super(x, y, weight, material, velX, velY, accX, accY);
    }
    
    @Override
    public boolean checkCollision(final Collisionable obj) {
        return false;
    }
    
    @Override
    public void impact(final Collisionable obj) {
    }
}
