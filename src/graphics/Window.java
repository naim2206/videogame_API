/**
 * Class to create the window and set the canvas
 * @author Naim Towfighian and Alejandro Casillas
 */
package graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import game.Keyboard;

public class Window extends JFrame {

	private static int width;
	private static int height;
	private Canvas panel;
	private Keyboard keyboard;

	/**
	 * Create the window
	 * 
	 * @param title      title of the window
	 * @param width      width of the window
	 * @param height     width of the window
	 * @param background background color of the image
	 */
	public Window(String title, int width, int height, Color background) {
		Window.width = width;
		Window.height = height;

		super.setTitle(title); // Sets the title of the frame
		super.setSize(Window.width, Window.height); // sets the size to the frame
		super.setLocationRelativeTo(null); // create frame in the center of the screen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window when X button is clicked
		super.setResizable(false); // no changing size of screen with mouse

		panel = new Canvas(background);
		keyboard = new Keyboard();

		panel.setVisible(true); // Show cnvas
		panel.setPreferredSize(new Dimension(Window.width, Window.height)); // size of the canvas
		panel.setMaximumSize(new Dimension(Window.width, Window.height));
		panel.setMinimumSize(new Dimension(Window.width, Window.height));

		this.add(panel);

		panel.addKeyListener(keyboard);

		this.setVisible(true); // Show screen

	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	/**
	 * 
	 * @return keyboard
	 */
	public Keyboard getKeyboard() {
		return this.keyboard;
	}

	/**
	 * 
	 * @return canvas
	 */
	public Canvas getCanvas() {
		return panel;
	}

}
