/**
 * Class for circular objects
 * @author Naim Towfighian and Alejandro Casillas
 */
package physics;

import java.awt.image.BufferedImage;

import game.GameState;

public abstract class CircleObj extends Collisionable {

    private double radius;

    /**
     * Constructor with all the parámeters
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param material  material of the object
     * @param velX      initial horizontal velocity
     * @param velY      initial vertical velocity
     * @param accX      initial horizontal acceleration
     * @param accY      initial vertical acceleration
     * @param radius    radius of the circle
     * @param texture   texture to render
     * @param gameState state of the game where object was created
     */
    public CircleObj(int x, int y, double weight, Material material, double velX,
            double velY, double accX, double accY, double radius, BufferedImage texture, GameState gameState) {
        super(x, y, weight, material, velX, velY, accX, accY, gameState);
        this.setRadius(radius);
    }

    /**
     * 
     * Constructor with weight and material
     * default: in rest
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param material  material of the object
     * @param radius    radius of the circle
     * @param texture   texture to render
     * @param gameState state of the game where object was created
     * 
     */
    public CircleObj(int x, int y, double weight, Material material, double radius, GameState gameState) {
        super(x, y, weight, material, gameState);
        this.setRadius(radius);
    }

    /**
     * Basic constructor
     * defaults: weight = 20, material = Wood, in rest
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param radius    radius of the circle
     * @param gameState state of the game where object was created
     */
    public CircleObj(int x, int y, double weight, double radius, GameState gameState) {
        super(x, y, gameState);
        this.setRadius(radius);
    }

    /**
     * 
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * 
     * @param radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean checkCollision(Collisionable obj) {
        if (obj instanceof RectObj) {
            return this.checkCollisionRect((RectObj) obj);
        }
        return obj instanceof CircleObj && this.checkCollisionCircle((CircleObj) obj);
    }

    /**
     * Check collision vs a rectangle
     * 
     * @param obj rectangle to check collision with
     * @return true if is collisioning, false if not
     */
    private boolean checkCollisionRect(RectObj obj) {
        int recCenterX = (int) (obj.getX() + obj.getWidth() / 2.0);
        int recCenterY = (int) (obj.getY() + obj.getHeight() / 2.0);

        float dx = Math.abs(this.getX() - (float) recCenterX);
        float dy = Math.abs(this.getY() - (float) recCenterY);

        if (dx > (obj.getWidth() / 2.0 + this.getRadius())) {
            return false;
        }
        if (dy > (obj.getHeight() / 2.0 + this.getRadius())) {
            return false;
        }

        if (dx <= (obj.getWidth() / 2.0) + this.getRadius()) {
            return true;
        }
        if (dy <= (obj.getHeight() / 2.0) + this.getRadius()) {
            return true;
        }

        double cornerDistanceSq = (dx - obj.getWidth() / 2.0) * (dx - obj.getWidth() / 2.0) +
                (dy - obj.getHeight() / 2.0) * (dy - obj.getHeight() / 2.0);

        return (cornerDistanceSq <= (this.getRadius() * this.getRadius()));
    }

    /**
     * Check collision vs a circle
     * 
     * @param obj circle object to check collision with
     * @return true if is collisioning, false if not
     */
    private boolean checkCollisionCircle(CircleObj obj) {
        boolean collision = false;

        double dx = this.getX() - obj.getX(); // X distance between centers
        double dy = this.getY() - obj.getY(); // Y distance between centers

        double distance = Math.sqrt(dx * dx + dy * dy); // Distance between centers

        if (distance <= (this.getRadius() + obj.getRadius()))
            collision = true;

        return collision;
    }
}
