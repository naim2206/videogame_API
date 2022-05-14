package game;

import java.util.ArrayList;

import main.game1.MyPlayer;
import physics.Collisionable;
import physics.Player;

public class GameState {

	protected ArrayList<Collisionable> colObjects = new ArrayList<>();
	// protected MyPlayer player;
	protected Player player;

	public GameState() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Collisionable> getColObjects() {
		return colObjects;
	}
}
