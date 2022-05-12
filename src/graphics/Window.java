package graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import input.Keyboard;

public class Window extends JFrame{
	
	private static int  width;
	private static int  height;
	
	private Canvas panel;
	private Keyboard keyboard;
	//private Hilo hilo;
	
	public Window(String title, int width, int height, Color background) { //Recibe titulo y tama�o del frame
		this.width = width;
		this.height = height;
		
		
		super.setTitle(title); //Asigna el titulo al frame
		super.setSize(this.width,this.height); //asigna tama�o al frame
		super.setLocationRelativeTo(null); // frame se crea en el centro de la pantalla
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar ventana al darle a la X
		super.setResizable(false); //No se puede alterar el tama�o con el mouse
		
		
		panel = new Canvas(background);
		keyboard = new Keyboard();
		
		
		panel.setVisible(true); //Muestra el canvas
		panel.setPreferredSize(new Dimension(this.width,this.height)); //tama�o canvas
		panel.setMaximumSize(new Dimension(this.width,this.height));
		panel.setMinimumSize(new Dimension(this.width,this.height));
		
		this.add(panel);
		
		panel.addKeyListener(keyboard);
		
		//hilo = new Hilo(panel);
		//hilo.start();
		
		this.setVisible(true); //Muestra la ventana
		
		
	}
	
	
	
	
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Keyboard getKeyboard() {
		return this.keyboard;
	}
	
	public Canvas getCanvas() {
		return panel;
	}
	
}
