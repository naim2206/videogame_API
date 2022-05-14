package game;

import java.util.ArrayList;

import physics.Collisionable;
import physics.Player;

public class GameState {

	protected ArrayList<Collisionable> colObjects = new ArrayList<>();
	// protected MyPlayer player;
	protected Player player;

	public GameState() {
	}

	public ArrayList<Collisionable> getColObjects() {
		return colObjects;
	}
}
