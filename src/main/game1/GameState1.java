package main.game1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import game.Assets;
import game.GameState;
import physics.Brick;
import physics.Material;

public class GameState1 extends GameState {
	public static int heigth = 700;
	public static int width = 500;

	public GameState1() {
		this.player = new MyPlayer(100, heigth - 50, 15, 0, 0, 0, 0, 25, Assets.Player, this);
		colObjects.add(player);

		colObjects.add(new Brick(0, heigth - 25, 60, Material.Stone, 500, 25, this));

		colObjects.add(new Brick(100, 700, 60, Material.Stone, 200, 25, this));

		colObjects.add(new Brick(200, 500, 60, Material.Stone, 200, 25, this));

		colObjects.add(new Brick(0, 300, 60, Material.Stone, 200, 25, this));
		colObjects.add(new Brick(300, 300, 60, Material.Stone, 200, 25, this));
		colObjects.add(new Brick(200, 100, 60, Material.Stone, 200, 25, this));
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
