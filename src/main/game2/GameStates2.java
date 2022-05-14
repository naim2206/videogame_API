package main.game2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import game.Assets;
import game.GameState;
import physics.Brick;
import physics.Material;
import java.awt.*;

public class GameStates2 extends GameState {
	public static int heigth = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

	public GameStates2() {
		colObjects.add(new Brick(0, heigth - 25, 60, Material.Stone, width, 25, this));
		for (int i = 0; i < width; i += 100) {
			for (int j = 0; j < 300; j += 100) {
				colObjects.add(new Brick(i, j, 1, Material.Wood, 80, 80, this));
			}
		}
		// colObjects.add(new Brick(0, 0, 1, Material.Wood, 80, 80, this));

		this.player = new MyPlayer2(100, heigth - 50, 102, 0, 0, 0, 0, 25,
				Assets.Player, this);
		colObjects.add(player);

	}

	public void update() {

		for (int i = 0; i < colObjects.size(); i++) {
			colObjects.get(i).update();
			// System.out.println(colObjects.get(i).getWeight());
		}
		// System.out.println();

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
