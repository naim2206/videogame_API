// 
// Decompiled by Procyon v0.5.36
// 
package physics;

import java.awt.Graphics;

import org.w3c.dom.css.Rect;

import states.GameState;

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
    public static final double WOOD_BREAK_SPEED = 120;
    public static final double STONE_BREAK_SPEED = 170;

    protected GameState gameState;

    public Collisionable(int x, int y, GameState gameState) {
        this(x, y, 20.0, Material.Wood, gameState);
    }

    public Collisionable(int x, int y, double weight, Material material, GameState gameState) {
        this.velX = 0.0;
        this.velY = 0.0;
        this.accX = 0.0;
        this.accY = 0.0;
        this.setX(x);
        this.setY(y);
        this.weight = weight;
        this.material = material;
        this.gameState = gameState;
    }

    public Collisionable(int x, int y, double weight, Material material, double velX, double velY, double accX,
            double accY, GameState gameState) {
        this(x, y, weight, material, gameState);
        this.setVelX(velX);
        this.setVelY(velY);
        this.setAccX(accX);
        this.setAccY(accY);
    }

    public abstract boolean checkCollision(Collisionable p0);

    public static void impact(Collisionable one, Collisionable two) {
        double oneMass = one.getWeight() / 9.81;
        double twoMass = two.getWeight() / 9.81;
        double prevOneVelX = one.getVelX();
        double prevOneVelY = one.getVelY();

        if (one instanceof Movable && one instanceof Movable) {

            one.setVelX(
                    ((one.getVelX()) * ((oneMass / twoMass) - 1) + (2 * two.getVelX())) / (1 + (oneMass / twoMass)));
            one.setVelY(
                    ((one.getVelY()) * ((oneMass / twoMass) - 1) + (2 * two.getVelY())) / (1 + (oneMass / twoMass)));

            two.setVelX(
                    prevOneVelX + one.getVelX() - two.getVelX());
            two.setVelY(
                    prevOneVelY + one.getVelY() - two.getVelY());
            return;
        }

        if (one instanceof Movable) {

            one.setVelX(one.getVelX() * -1);
            one.setVelY(one.getVelY() * -1);
        }

        else if (two instanceof Movable)

        {
            two.setVelX(two.getVelX() * -1);
            two.setVelY(two.getVelY() * -1);
        }

    }

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

    public abstract void update();

    public abstract void draw(Graphics g);

}
