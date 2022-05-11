package physics;

public interface Movable {

    public static final double GRAVITY = -9.81;
    public static final double FRICC_FLOOR = 0.4;

    public void move();

    public void fall();

    public void stop();

}
