
package physics;

/**
 * Interface to make an object movable (to be able to change position)
 * 
 * @author Naim Towfighian and Alejandro Casillas
 */
public interface Movable {

    public static final double GRAVITY = .3; // .05
    public static final double FRICC_FLOOR = 0.4;
    public static final double MAX_SPEED_X = 22;
    public static final double MAX_SPEED_Y = 20;

    /**
     * change position of object in terms of its velocity
     */
    public void move();

    /**
     * change Y velocity of the object in terms of Y acceleration and GRAVITY
     */
    public void fall();

    /**
     * Decrease velocity of object and apply friction
     */
    public void stop();

}
