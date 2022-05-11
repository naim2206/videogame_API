package physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import graphics.Window;

public abstract class Player extends CircleObj implements Movable{
	
	protected boolean created = false; //singleton
	protected double angle = 0;
	protected BufferedImage texture;
	protected Player player;
	
	public Player(int x, int y, double weight, double velX, double velY, double accX, double accY,
			double radius, BufferedImage texture) {
		super(x, y, weight, Material.Wood, velX, velY, accX, accY, radius);
		this.texture = texture;
		// TODO Auto-generated constructor stub
	}

	public Player(int x, int y, double weight, double radius, BufferedImage texture) {
		super(x, y, weight, Material.Wood, radius);
		this.texture = texture;
		
		// TODO Auto-generated constructor stub
	}

	
	public abstract void moveByPlayer(); 
	
	public void destroyPlayer(ArrayList<Collisionable> colObjects) {
		colObjects.remove(this);
	}
	
	public void fall() {
		this.setVelY(getVelY() + GRAVITY);
	}
	
	public void stop() {
		this.setAccX(getAccX()-1);	
	}
	
	public void move() {
		this.setX(Math.round((float) (this.getX() + this.getVelX())));
	    this.setY(Math.round((float) (this.getY() + this.getVelY())));
	}

	
	public void update(ArrayList<Collisionable> colObjects) {
		boolean status = true; //Air status
		moveByPlayer();
		move();		
		
		for(Collisionable c: colObjects) {
			if(this.checkCollision(c) ) {
				status = false;
				
				
				if(this.breakObject(c)) {
					destroyPlayer(colObjects);
				}
				else {
					this.impact(c);
				}

			}
			
			fall();
			
		}
		
		stop();
		
		
		
	}
	
	
	
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		AffineTransform at = AffineTransform.getTranslateInstance((double)getX(), (double)getY());
		
		if( this.getAccX() > 0) {
			angle += 0.1;
			at.rotate(angle, getRadius(), getRadius());
		}
		
		if( this.getAccX() < 0) {
			angle -= 0.1;
			at.rotate(angle, getRadius(), getRadius());
		}
	
		g2d.drawImage(texture, at, null);
		
	}

}
