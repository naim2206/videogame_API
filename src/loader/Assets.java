package loader;

import java.awt.image.BufferedImage;

import loader.Loader;

public class Assets {
	
	//BufferedImage image = Scalr.resize(originalImage, Scalr.Method.BALANCED, newWidth, newHeight); //RESIZE OBJ
    
	
	//Materials Objs
	//Wood
	public static BufferedImage WoodBox;
	
	//Stone
	public static BufferedImage Boulder;
	public static BufferedImage Brick;
	
	
	public static void init() {
		
		WoodBox = Loader.ImageLoader("/Wood/wood_box.png");
		Boulder = Loader.ImageLoader("/Stone/boulder.png");
		Brick = Loader.ImageLoader("/Stone/brick.png");
	
	}
}
