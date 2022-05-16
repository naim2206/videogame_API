package main.game2;

import game.Assets;
import game.GameState;
import physics.Bolder;
import physics.Brick;
import physics.Material;
import java.awt.*;

public class GameStates2 extends GameState {
	public static int heigth = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

	public GameStates2() {
		colObjects.add(new Brick(0, heigth - 25, 60, Material.Stone, width, 25, this));
		colObjects.add(new Brick(0, 25, 60, Material.Stone, width, 25, this));
		for (int i = 0; i < width; i += 100) {
			for (int j = 100; j < 400; j += 100) {
				colObjects.add(new Brick(i, j, -100, Material.Wood, 80, 80, this));
			}
		}

		this.player = new MyPlayer2(100, heigth - 100, 102, 0, 0, 0, 0, 50,
				Assets.Player, this);
		colObjects.add(player);
		colObjects.add(new Bolder(100, 400, 1, 0, 50, 0, 0, 50, this));

	}

	public void update() {
		for (int i = 0; i < colObjects.size(); i++) {
			if (colObjects.get(i) instanceof Bolder) {
				if (colObjects.get(i).getX() > width) {
					colObjects.get(i).setX(0);
				}
				if (colObjects.get(i).getX() < 0) {
					colObjects.get(i).setX(width - 1);
				}
			}
			colObjects.get(i).update();
		}

	}

}
