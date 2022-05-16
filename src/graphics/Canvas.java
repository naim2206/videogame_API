
package graphics;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * Class to create the canvas
 * 
 * @author Naim Towfighian and Alejandro Casillas
 */
public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L; // Obligatory for JPanel

	/**
	 * Creates focusable canvas (can have inputs from mouse/keyboard)
	 * 
	 * @param color background color
	 */
	public Canvas(Color color) {
		this.setBackground(color);
		this.setFocusable(true);
	}

}
