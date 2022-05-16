
package physics;

import java.awt.Graphics;

import game.GameState;

/**
 * Main class for all Collisionable type objects
 * 
 * @author Naim Towfighian and Alejandro Casillas
 */
public abstract class Collisionable {
    private int x;
    private int y;
    private double weight;
    private double velX;
    private double velY;
    private double accX;
    private double accY;
    private final Material material;
    public static final double WOOD_BREAK_SPEED = -80;
    public static final double STONE_BREAK_SPEED = 8;
    protected GameState gameState;

    /**
     * Basic constructor
     * defaults: weight = 20, material = Wood, in rest
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param gameState state of the game where object was created
     */
    public Collisionable(int x, int y, GameState gameState) {
        this(x, y, 20.0, Material.Wood, gameState);
    }

    /**
     * Constructor with weight and material
     * default: in rest
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param material  material of the object
     * @param gameState state of the game where object was created
     */
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

    /**
     * Constructor with all the parameters
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param material  material of the object
     * @param velX      initial horizontal velocity
     * @param velY      initial vertical velocity
     * @param accX      initial horizontal acceleration
     * @param accY      initial vertical acceleration
     * @param gameState state of the game where object was created
     */
    public Collisionable(int x, int y, double weight, Material material, double velX, double velY, double accX,
            double accY, GameState gameState) {
        this(x, y, weight, material, gameState);
        this.setVelX(velX);
        this.setVelY(velY);
        this.setAccX(accX);
        this.setAccY(accY);
    }

    /**
     * Chech if the object is collisioning with another object
     * 
     * @param p0 object to check collision with
     * @return true if collision, false if not
     */
    public abstract boolean checkCollision(Collisionable p0);

    /**
     * Makes the collision, changes the velocity of the objects to the velocities
     * after the colission
     * 
     * @param one first object that impacts
     * @param two second object that impacts
     */
    public static void impact(Collisionable one, Collisionable two) {
        double oneMass = one.getWeight() / 9.81;
        double twoMass = two.getWeight() / 9.81;
        double prevOneVelX = one.getVelX();
        double prevOneVelY = one.getVelY();

        if (two instanceof Movable) {
            one.setVelX(
                    ((one.getVelX()) * ((oneMass / twoMass) - 1) + (2 * two.getVelX())) / (1 +
                            (oneMass / twoMass)));
            one.setVelY(
                    ((one.getVelY()) * ((oneMass / twoMass) - 1) + (2 * two.getVelY())) / (1 +
                            (oneMass / twoMass)));
            two.setVelX(
                    prevOneVelX + one.getVelX() - two.getVelX());
            two.setVelY(
                    prevOneVelY + one.getVelY() - two.getVelY());
            return;
        }

        if (one instanceof Movable) {
            one.setVelY(one.getVelY() * -1);
            Movable oneM = (Movable) one;
            oneM.move();
            oneM.move();
            if (one.checkCollision(two)) {
                one.setVelX(one.getVelX() * -1);
                one.setVelY(one.getVelY() * -1);
                oneM.move();
                oneM.move();
            }

            if (one.getVelY() > 0) {
                one.setVelY(one.getVelY() * 0.8);

            }
            if (one.getVelY() < 0) {
                one.setVelY(one.getVelY() * 0.8);
            }

            one.setVelX(one.getVelX() * 0.9);
        }
    }

    /**
     * Checks if an object has to break depending on velocity and weight.
     * (stone does not break)
     * 
     * @param p0
     * @return true if this has to break, false if not
     */
    public boolean breakObject(Collisionable p0) {
        if (this.material == Material.Stone)
            return false;
        if (p0.material == Material.Wood) {
            if (Math.abs(this.getVelX()) + Math.abs(this.getVelY()) + Math.abs(p0.getVelX()) + Math.abs(p0.getVelY())
                    - this.weight > WOOD_BREAK_SPEED)
                return true;
            return false;
        }
        if (this.getVelX() + this.getVelY() + p0.getVelX() + p0.getVelY() - this.weight > STONE_BREAK_SPEED)
            return true;
        return false;
    }

    /**
     * 
     * @return X
     */
    public int getX() {
        return this.x;
    }

    /**
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 
     * @return Y
     */
    public int getY() {
        return this.y;
    }

    /**
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 
     * @return weight
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * 
     * @return velX
     */
    public double getVelX() {
        return this.velX;
    }

    /**
     * 
     * @param velX
     */
    public void setVelX(double velX) {
        this.velX = velX;
    }

    /**
     * 
     * @return velY
     */
    public double getVelY() {
        return this.velY;
    }

    /**
     * 
     * @param velY
     */
    public void setVelY(double velY) {
        this.velY = velY;
    }

    /**
     * 
     * @return accX
     */
    public double getAccX() {
        return this.accX;
    }

    /**
     * 
     * @param accX
     */
    public void setAccX(double accX) {
        this.accX = accX;
    }

    /**
     * 
     * @return accY
     */
    public double getAccY() {
        return this.accY;
    }

    /**
     * 
     * @param accY
     */
    public void setAccY(double accY) {
        this.accY = accY;
    }

    /**
     * 
     * @return material
     */
    public Material getMaterial() {
        return this.material;
    }

    /**
     * Update the position of the object
     */
    public abstract void update();

    /**
     * Draw the object to the screen
     * 
     * @param g
     */
    public abstract void draw(Graphics g);

    /**
     * Delete object from gameState
     */
    public abstract void destroy();

}
