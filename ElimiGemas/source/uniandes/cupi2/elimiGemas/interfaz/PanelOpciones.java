package uniandes.cupi2.elimiGemas.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOpciones extends JPanel implements ActionListener
{
	//-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
	/** Constante para la serialización */
    private static final long serialVersionUID = 1L;
    
    /** Constante que modela el comando del botón Cargar. */
	public static final String CARGAR = "Cargar";
	
	/** Constante que modela el comando del botón Reiniciar. */
	public static final String REINICIAR = "Reiniciar";
	
	/** Constante que modela el comando del botón Opción 1. */
	public static final String OPCION_1 = "Opción 1";
	
	/** Constante que modela el comando del botón Opción 2. */
	public static final String OPCION_2 = "Opción 2";
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
	/** Atributo que modela la conexión del panel con la interfaz principal. */
	private InterfazElimiGemas principal;
	
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
	/** Atributo que modela el botón Cargar */
	private JButton btnCargar;

	/** Atributo que modela el botón Reiniciar */
	private JButton btnReiniciar;
	
	/** Atributo que modela el botón Opción 1 */
	private JButton btnOpcion1;
	
	/** Atributo que modela el botón Opción 2 */
	private JButton btnOpcion2;
	
	//-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------
	
    /**
     * Metodo constructor del panel de opciones.
     */	
	public PanelOpciones(InterfazElimiGemas ventana)
	{
		//Inicializa el parametro principal
		principal = ventana;
		
		//Adiciona un marco con titulo
		TitledBorder border = BorderFactory.createTitledBorder( "Opciones" );
        border.setTitleColor( Color.WHITE );
        setBorder( border );
        setLayout(new GridLayout(1,4));
        setBackground (new Color(21, 2, 2));
        
		//Inicializa los atributos.
		btnCargar = new JButton("Cargar");
		btnReiniciar = new JButton("Reiniciar");
		btnOpcion1 = new JButton("Opción 1");
		btnOpcion2 = new JButton("Opción 2");
		
		//Adiciona los comandos a los botones.
		btnCargar.setActionCommand(CARGAR);
		btnCargar.addActionListener(this);
		btnCargar.setBackground(new Color(128, 64, 0));
		btnCargar.setForeground(Color.WHITE);
		btnReiniciar.setActionCommand(REINICIAR);
		btnReiniciar.addActionListener(this);
		btnReiniciar.setBackground(new Color(128, 64, 0));
		btnReiniciar.setForeground(Color.WHITE);
		btnOpcion1.setActionCommand(OPCION_1);
		btnOpcion1.addActionListener(this);
		btnOpcion1.setBackground(new Color(128, 64, 0));
		btnOpcion1.setForeground(Color.WHITE);
		btnOpcion2.setActionCommand(OPCION_2);
		btnOpcion2.addActionListener(this);
		btnOpcion2.setBackground(new Color(128, 64, 0));
		btnOpcion2.setForeground(Color.WHITE);
		
		//Adicion los elementos al panel.
		add(btnCargar);
		add(btnReiniciar);
		add(btnOpcion1);
		add(btnOpcion2);
	
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
		if (comando.equals(OPCION_1))
		{
			principal.reqFuncOpcion1();
		} 
		else if (comando.equals(OPCION_2))
		{
			principal.reqFuncOpcion2();
	
		}
		else if (comando.equals(CARGAR))
		{
			principal.cargar();
		}
		else if (comando.equals(REINICIAR))
		{
			principal.reiniciar();
		}
	}

}

