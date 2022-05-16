/**
 * Class to load images to screen and set their sizes
 * @author Naim Towfighian and Alejandro Casillas
 */
package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {

	/**
	 * Read image from path
	 * 
	 * @param path
	 * @return Buffered image with image loaded
	 */
	public static BufferedImage ImageLoader(String path) {
		try {
			return ImageIO.read(Loader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * set size of the image to equal the width and height of the collisionable
	 * object
	 * 
	 * @param img  image to resize
	 * @param newW Width to resize it to
	 * @param newH height to resize it to
	 * @return resized graphic
	 */
	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return dimg;
	}
}