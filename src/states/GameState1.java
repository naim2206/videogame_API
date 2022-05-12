package states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import loader.Assets;
import physics.*;



public class GameState1 extends GameState{

	

	
	public GameState1() {
		this.player = new MyPlayer(100, 400, 15, 25, Assets.Player, this);
		colObjects.add(player);
		
		colObjects.add(new Brick(300, 500, 60, Material.Stone, 100, 100, this)
				
				);
		
	}
	
	
	
	
	
	
	public void update() {
		
		for(int i = 0; i < colObjects.size(); i++) {
			colObjects.get(i).update();
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
