/**
 * Class to check if the keys are pressed
 * @author Naim Towfighian and Alejandro Casillas
 */
package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[256];

	public static boolean UP, LEFT, RIGHT, SHOOT;

	/**
	 * Constructor, nothing is pressed at the start
	 */
	public Keyboard() {
		UP = false;
		LEFT = false;
		RIGHT = false;
		SHOOT = false;
	}

	/**
	 * checks if a key is pressed
	 */
	public void update() {
		UP = keys[KeyEvent.VK_UP];
		LEFT = keys[KeyEvent.VK_LEFT];
		RIGHT = keys[KeyEvent.VK_RIGHT];
		SHOOT = keys[KeyEvent.VK_P];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
