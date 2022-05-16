
package game;

import java.awt.image.BufferedImage;

/**
 * Class to render images for each type of collisionable object
 * 
 * @author Naim Towfighian and Alejandro Casillas
 */
public class Assets {

	// Wood
	public static BufferedImage WoodBox;
	public static BufferedImage StoneBox;
	public static BufferedImage Player;

	// Stone
	public static BufferedImage Boulder;
	public static BufferedImage StoneBrick;
	public static BufferedImage WoodBrick;

	/**
	 * Load images
	 */
	public static void init() {
		WoodBox = Loader.ImageLoader("/Wood/wood_box.png");
		WoodBrick = Loader.ImageLoader("/Wood/woodBrick.png");
		Boulder = Loader.ImageLoader("/Stone/boulder.png");
		StoneBrick = Loader.ImageLoader("/Stone/brick.png");
		StoneBox = Loader.ImageLoader("/Stone/stoneBox.png");
		Player = Loader.ImageLoader("/Wood/RainbowBall.png");
	}
}
