package main;

import java.awt.Color;

import graphics.Window;
import states.GameState1;

public class Game1{
	
	private GameState1 gameState;
	
	public static void Init() {
		Window Ventana = new Window("Jueguito", 500,700, Color.CYAN);
		
		
		
	}

		
	public static void Run(){
	
		Init();
	
	
	while(true){
		
		gameState1.update();
		gameState1.draw();
		
		
	}
	
	
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Run();
		
	}
	
}
