package game;

import java.awt.image.BufferedImage;

public class Assets {

	// BufferedImage image = Scalr.resize(originalImage, Scalr.Method.BALANCED,
	// newWidth, newHeight); //RESIZE OBJ

	// Materials Objs
	// Wood
	public static BufferedImage WoodBox;
	public static BufferedImage StoneBox;
	public static BufferedImage Player;

	// Stone
	public static BufferedImage Boulder;
	public static BufferedImage StoneBrick;
	public static BufferedImage WoodBrick;

	public static void init() {

		WoodBox = Loader.ImageLoader("/Wood/wood_box.png");
		WoodBrick = Loader.ImageLoader("/Wood/woodBrick.png");
		Boulder = Loader.ImageLoader("/Stone/boulder.png");
		StoneBrick = Loader.ImageLoader("/Stone/brick.png");
		StoneBox = Loader.ImageLoader("/Stone/stoneBox.png");
		Player = Loader.ImageLoader("/Wood/RainbowBall.png");
	}
}
