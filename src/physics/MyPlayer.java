package physics;

import java.awt.image.BufferedImage;


import input.Keyboard;

public class MyPlayer extends Player {

	public MyPlayer(int x, int y, double weight, double velX, double velY, double accX, double accY, double radius,
			BufferedImage texture) {
		super(x, y, weight, velX, velY, accX, accY, radius, texture);
		// TODO Auto-generated constructor stub
	}

	public MyPlayer(int x, int y, double weight, double radius, BufferedImage texture) {
		super(x, y, weight, radius, texture);
		// TODO Auto-generated constructor stub
		
		setVelX(0);
		setVelY(0);
	}

	@Override
	public void moveByPlayer() {
		if(Keyboard.RIGHT) {
			this.setAccX(0.002);
			//move();
			return;
		}
		
		if(Keyboard.LEFT) { 
			this.setAccX(-0.002);
			//move();
			return;
		}
		
		if(Keyboard.UP) { 
			this.setAccY(-0.002);
			//move();
			return;
		}
		
		else {
			this.setAccX(0);
			this.setAccY(0);
		}
		
		if (getX() > 500) {
			setX(0);
		}
		if (getY() > 700) {
			setY(0);
		}
		
		if (getX() < 0) {
			setX(500);
		}
		
		if (getY() < 0) {
			setY(700);
		}
		
		
	}

}
