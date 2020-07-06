package uniandes.cupi2.elimiGemas.interfaz;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;


/**
 * Clase que pone la imagen en el encabezado de la aplicación.
 */
public class PanelImagen extends JPanel
{
	//-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
	
	/** Constante para la serialización */
    private static final long serialVersionUID = 1L;
		
	//-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------
	
    /**
     * Metodo constructor del panel de imagen.
     */
	public PanelImagen()
	{
		JLabel imagen = new JLabel("");
		ImageIcon titulo = new ImageIcon("data/imagenes/encabezado_pic.png");
		imagen.setIcon(titulo);
		add(imagen);
		setSize(722, 181);
		setBackground(Color.BLACK);
		Border borde = BorderFactory.createRaisedBevelBorder();
		setBorder(borde);
		
	}
}
