package Graphics;

import java.awt.Color;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	private final int  width;
	private final int  height;
	
	private Canvas panel;
	//private Hilo hilo;
	
	public Window(String title, int width, int height, Color background) { //Recibe titulo y tamaño del frame
		this.width = width;
		this.height = height;
		
		
		super.setTitle(title); //Asigna el titulo al frame
		super.setSize(this.width,this.height); //asigna tamaño al frame
		super.setLocationRelativeTo(null); // frame se crea en el centro de la pantalla
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar ventana al darle a la X
		super.setResizable(false); //No se puede alterar el tamaño con el mouse
		panel = new Canvas(background);
		super.add(panel);
		panel.setVisible(true); //Muestra el canvas
		
		
		this.setVisible(true); //Muestra la ventana completa
		
		
		//hilo = new Hilo(panel);
		//hilo.start();
		
	}
	
	
	
	
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
}
