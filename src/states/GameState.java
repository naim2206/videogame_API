package states;

import java.util.ArrayList;

import physics.Collisionable;
import physics.MyPlayer;

public class GameState {
	
	
	protected ArrayList<Collisionable> colObjects = new ArrayList<>();
	protected MyPlayer player;
	
	public GameState() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<Collisionable> getColObjects() {
		return colObjects;
	}
}
