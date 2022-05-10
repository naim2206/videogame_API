package Physics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Boulder extends CircleObj {

	public Boulder(int x, int y, double weight, Material material, double velX, double velY, double accX, double accY,
			double radius, BufferedImage texture) {
		super(x, y, weight, material, velX, velY, accX, accY, radius, texture);
		// TODO Auto-generated constructor stub
	}

	public Boulder(int x, int y, double weight, Material material, double radius, BufferedImage texture) {
		super(x, y, weight, material, radius, texture);
		// TODO Auto-generated constructor stub
	}

	public Boulder(int x, int y, double weight, double ratius, BufferedImage texture) {
		super(x, y, weight, ratius, texture);
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
