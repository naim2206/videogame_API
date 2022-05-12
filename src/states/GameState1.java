package states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import loader.Assets;
import physics.*;

public class GameState1 extends GameState {

	public GameState1() {
		this.player = new MyPlayer(100, 100, 15, 25, Assets.Player, this);
		colObjects.add(player);

		colObjects.add(new Brick(0, 675, 60, Material.Stone, 500, 25, this));

		colObjects.add(new Brick(0, 0, 60, Material.Stone, 25, 700, this));

		colObjects.add(new Brick(0, 25, 60, Material.Stone, 500, 25, this));

		colObjects.add(new Brick(475, 0, 60, Material.Stone, 25, 700, this));

		colObjects.add(new Box(300, 100, 15, Material.Stone, 0, 0, 0, 0, 100, 100, this));
		colObjects.add(new Bolder(100, 300, 15, 0, 0, 0, 0, 10, this));
	}

	public void update() {

		for (int i = 0; i < colObjects.size(); i++) {
			colObjects.get(i).update();
		}

	}

	public void draw(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); // Hace que
																												// no se
																												// pixelee
																												// al
																												// girar

		for (int i = 0; i < colObjects.size(); i++) {
			colObjects.get(i).draw(g);
		}

	}

}
