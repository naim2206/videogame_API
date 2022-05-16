/**
 * Class for rectangular objects
 * @author Naim Towfighian and Alejandro Casillas
 */
package physics;

import game.GameState;

public abstract class RectObj extends Collisionable {
    private double width;
    private double height;

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
     * @param width     width of the rectangle
     * @param height    height of the rectangle
     * @param gameState state of the game where object was created
     */
    public RectObj(int x, int y, double weight, Material material, double velX,
            double velY, double accX, double accY, double width, double height, GameState gameState) {
        super(x, y, weight, material, velX, velY, accX, accY, gameState);
        this.setWidth(width);
        this.setHeight(height);
    }

    /**
     * Constructor with weight and material
     * default: in rest
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param material  material of the object
     * @param width     width of the rectangle
     * @param height    height of the rectangle
     * @param gameState state of the game where object was created
     */
    public RectObj(int x, int y, double weight, Material material, double width,
            double height, GameState gameState) {
        super(x, y, weight, material, gameState);
        this.setWidth(width);
        this.setHeight(height);
    }

    /**
     ** Basic constructor
     * defaults: weight = 20, material = Wood, in rest
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param width     width of the rectangle
     * @param height    height of the rectangle
     * @param gameState state of the game where object was created
     */
    public RectObj(int x, int y, double weight, double width, double height, GameState gameState) {
        super(x, y, gameState);
        this.setWidth(width);
        this.setHeight(height);
    }

    @Override
    public boolean checkCollision(Collisionable obj) {
        if (obj instanceof RectObj) {
            return this.checkCollisionRect((RectObj) obj);
        }
        return obj instanceof CircleObj && this.checkCollisionCircle((CircleObj) obj);
    }

    /**
     * Check collision vs rectangular object
     * 
     * @param obj rectangle to check collision with
     * @return true if is collisioning, false if not
     */
    private boolean checkCollisionRect(RectObj obj) {
        return this.checkCollisionRectX(obj) && this.checkCollisionRectY(obj);
    }

    /**
     * Check collision in the X axis for rectangles
     * 
     * @param obj rectangle to check collision with
     * @return true if is collisioning, false if not
     */
    public boolean checkCollisionRectX(RectObj obj) {
        boolean collision = false;
        if (this.getX() < obj.getX() + obj.getWidth() && this.getX() + this.getWidth() > obj.getX()) {
            collision = true;
        }
        return collision;
    }

    /**
     * Check collision in the Y axis for rectangles
     * 
     * @param obj rectangle to check collision with
     * @return true if is collisioning, false if not
     */
    public boolean checkCollisionRectY(RectObj obj) {
        boolean collision = false;
        if (this.getY() < obj.getY() + obj.getHeight() && this.getY() + this.getHeight() > obj.getY()) {
            collision = true;
        }
        return collision;
    }

    /**
     * Check collision vs circular object
     * 
     * @param obj circular object to check collision with
     * @return true if is collisioning, false if not
     */
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

    /**
     * 
     * @return width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * 
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * 
     * @return height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * 
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }
}
