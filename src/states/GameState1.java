package states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import loader.Assets;
import physics.Collisionable;
import physics.MyPlayer;


public class GameState1 {

	private ArrayList<Collisionable> colObjects = new ArrayList<>();
	private MyPlayer player;

	
	public GameState1() {
		this.player = new MyPlayer(100, 400, 50, 2, Assets.Player);
		colObjects.add(player);
		
	}
	
	
	
	
	
	
	public void update() {
		
		for(int i = 0; i < colObjects.size(); i++) {
			colObjects.get(i).update(colObjects);
		}
	
		
	}
	
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); //Hace que no se pixelee al girar
		
		for(int i = 0; i < colObjects.size(); i++) {
			colObjects.get(i).draw(g);
		}
		
		
	}
}
