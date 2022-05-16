/**
 * Class to render images for each type of collisionable object
 * @author Naim Towfighian and Alejandro Casillas
 */
package game;

import java.util.ArrayList;

import physics.Collisionable;
import physics.Player;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public abstract class GameState {

	protected ArrayList<Collisionable> colObjects = new ArrayList<>();
	protected Player player;

	/**
	 * Create an emplty GameState
	 */
	public GameState() {
	}

	/**
	 * Update every object in the game
	 */
	public void update() {
		for (int i = 0; i < colObjects.size(); i++) {
			colObjects.get(i).update();
		}
	}

	/**
	 * 
	 * @return list of objects in the game (ArrayList)
	 */
	public ArrayList<Collisionable> getColObjects() {
		return colObjects;
	}

	/**
	 * Draw every object in the game
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); // Hace que
		for (int i = 0; i < colObjects.size(); i++) {
			colObjects.get(i).draw(g);
		}

	}
}
