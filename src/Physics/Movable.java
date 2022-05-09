package Physics;


public interface Movable {

    public static final double gravity = 9.81;
    public static final double friccFloor = 0.4;
    public static final double friccAir = 0.1;

    public void move();
    // this.setX(Math.round((float) (this.getX() + this.getVelX())));
    // this.setY(Math.round((float) (this.getY() + this.getVelY())));

    public void fall();

    // this.setY(this.getY() - )
    public void stop();

    public void overSlide();
}
