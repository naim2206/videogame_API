package physics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Brick extends RectObj {

	public Brick(int x, int y, double weight, Material material, double velX, double velY, double accX, double accY,
			double width, double height, BufferedImage texture) {
		super(x, y, weight, material, velX, velY, accX, accY, width, height, texture);
		// TODO Auto-generated constructor stub
	}

	public Brick(int x, int y, double weight, Material material, double width, double height, BufferedImage texture) {
		super(x, y, weight, material, width, height, texture);
		// TODO Auto-generated constructor stub
	}

	public Brick(int x, int y, double weight, double width, double height, BufferedImage texture) {
		super(x, y, weight, width, height, texture);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

}
