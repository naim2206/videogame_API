package physics;

public interface Movable {

    public static final double GRAVITY = .05;
    public static final double FRICC_FLOOR = 0.4;
    public static final double MAX_SPEED_X = 22;
    public static final double MAX_SPEED_Y = 20;

    public void move();

    public void fall();

    public void stop();

}
