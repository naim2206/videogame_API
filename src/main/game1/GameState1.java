package main.game1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import physics.Box;

import game.Assets;
import game.GameState;
import physics.Bolder;
import physics.Brick;
import physics.Material;

public class GameState1 extends GameState {
	public static int heigth = 700;
	public static int width = 500;

	public GameState1() {
		this.player = new MyPlayer(200, heigth - 50, 15, 0, 0, 0, 0, 25,
				Assets.Player, this);
		colObjects.add(player);

		colObjects.add(new Brick(0, heigth - 25, 60, Material.Stone, width, 25, this));
		colObjects.add(new Brick(0, 25, 60, Material.Stone, width, 25, this));
		colObjects.add(new Brick(0, 0, 60, Material.Stone, 25, heigth, this));
		colObjects.add(new Brick(width - 25, 0, 60, Material.Stone, 25, heigth, this));

		colObjects.add(new Bolder(100, 100, 5, 50, this));

		// colObjects.add(new Brick(100, 700, 60, Material.Stone, 200, 25, this));

		// // colObjects.add(new Box(200, 500, 100, Material.Stone, 20, 100, this));
		// colObjects.add(new Bolder(200, 500, 100, 50, this));

		// colObjects.add(new Brick(0, 300, 60, Material.Stone, 200, 25, this));
		colObjects.add(new Brick(300, 300, 60, Material.Stone, 200, 25, this));
		colObjects.add(new Box(200, 100, 30, Material.Stone, 50, 50, this));
		// colObjects.add(new Brick(200, 100, 60, Material.Stone, 200, 25, this));

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
