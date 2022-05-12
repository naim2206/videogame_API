package physics;

public interface Movable {

    public static final double GRAVITY = .001;
    public static final double FRICC_FLOOR = 0.4;
    public static final double MAX_SPEED_X = 2.2;
    public static final double MAX_SPEED_Y = 1.8;
    
    public void move();

    public void fall();

    public void stop();

}
