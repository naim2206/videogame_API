package states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import physics.Collisionable;


public class GameState1 {

	private ArrayList<Collisionable> colObjects = new ArrayList<>();
	

	
	public GameState1() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void update() {
		
		for(int i = 0; i < colObjects.size(); i++) {
			colObjects.get(i).update();
		}
	
		
	}
	
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); //Hace que no se pixelee al girar
		
		for(int i = 0; i < movingObjects.size(); i++) {
			movingObjects.get(i).draw(g);
		}
		
		for(int i = 0; i < explosions.size(); i++) {
			Animation anim = explosions.get(i);
			g2d.drawImage(anim.getCurrentFrame(), (int)anim.getPosition().getX(), (int)anim.getPosition().getY(), null);
			
			}
		
		
		
	}
}
