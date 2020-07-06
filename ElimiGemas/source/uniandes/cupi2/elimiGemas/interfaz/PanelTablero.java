package uniandes.cupi2.elimiGemas.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.cupi2.elimiGemas.mundo.ElimiGemas;
import uniandes.cupi2.elimiGemas.mundo.Gemas;

public class PanelTablero extends JPanel implements ActionListener
{
	
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	/** Constante para la serialización */
    private static final long serialVersionUID = 1L;
    
    /** Constante que indica el ancho de la matriz de botones */
	public static final int ANCHO = 10;
	
	/** Constante que indica el alto de la matriz de botones */
	public static final int ALTO = 7;
	
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
	/** Atributo que modela la conexión con la interfaz principal */
	private InterfazElimiGemas principal;
	
	/** Atributo que modela la matriz de botones */
	private JButton[][] botones;
	
	
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	/**
	 * Metodo constructor del panel Tablero.
	 * @param ventana Parámetro con el que se inicializa la conexión con la interfaz principal.
	 */
	public PanelTablero(InterfazElimiGemas ventana)
	{
		principal = ventana;
		setBackground(new Color(21, 2, 2));
		setLayout(new GridLayout(ALTO, ANCHO));
		inicializar();
	}
	
	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

	/**
	 * Metodo que inicializa la matriz de botones.
	 * <b> post: </b> Se inicializó la matriz de botones. <br> 
	 */
	public void inicializar()
	{
		botones = new JButton[ALTO][ANCHO];
		for(int i =0; i<ALTO; i++)
		{
			for (int j=0; j<ANCHO; j++)
			{
				JButton temporal = new JButton();
				temporal.addActionListener(this);
				temporal.setActionCommand(i+","+j);
				temporal.setBackground(new Color(21, 2, 2));
				botones[i][j]= temporal;
			}
		}
	}
	
	/**
	 * Metodo que actualiza la información en la matriz de botones.
	 * <b> post: </b> Se actualizó la información en la matriz de botones. <br> 
	 * @param mundo Parametro que modela el uso de metodos presentes en el mundo.
	 */
	public void actualizar(ElimiGemas mundo)
	{
		removeAll();
		for(int i =0; i<ALTO; i++)
		{
			for (int j=0; j<ANCHO; j++)
			{
				if(mundo.darGema(i,j).darTipo()== Gemas.ESMERALDA){
					botones[i][j].setIcon(new ImageIcon("data/imagenes/esmeralda_pic.png"));
				}
				else if(mundo.darGema(i,j).darTipo()== Gemas.DIAMANTE){
					botones[i][j].setIcon(new ImageIcon("data/imagenes/diamante_pic.png"));
					
				}
				else if(mundo.darGema(i,j).darTipo()== Gemas.RUBI){
					botones[i][j].setIcon(new ImageIcon("data/imagenes/ruby_pic.png"));
					
				}
				else if(mundo.darGema(i,j).darTipo()== Gemas.VACIA){
					botones[i][j].setIcon(new ImageIcon("data/imagenes/eliminada_pic.PNG"));
					
				}
				add(botones[i][j]);
			}
		}
		validate();
		repaint();
		
	}
	
	//-----------------------------------------------------------------
    // Metodo de atención de eventos.
    //-----------------------------------------------------------------
	/**
	 * Metodo que asigna las funciones a cada botón después del evento del clic.
	 * @param e Evento de acción que entra mediante el clic.
	 */
	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		String[] coordenadas = comando.split(",");
		principal.jugar(Integer.parseInt(coordenadas[0]),Integer.parseInt(coordenadas[1]));
	}
	
	


}