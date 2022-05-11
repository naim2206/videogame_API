package graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L; // Requisito de JPanel

	public Canvas(Color color) {

		this.setBackground(color); // Asigna el fondo que recibe del constructor
		this.setFocusable(true); // Canvas puede ser objetivo de entradas de mouse/teclado
	}

}
