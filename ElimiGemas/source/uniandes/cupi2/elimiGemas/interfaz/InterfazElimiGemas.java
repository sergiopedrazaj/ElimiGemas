package uniandes.cupi2.elimiGemas.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.elimiGemas.mundo.ElimiGemas;

/**
 * Interfaz principal que modela el juego.
 * @author Sergio Pedraza
 *
 */
public class InterfazElimiGemas extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	/** Constante para la serializaci�n */
    private static final long serialVersionUID = 1L;
    
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /** Atributo que modela la conexi�n con el mundo */
	private ElimiGemas elimiGemas;
	
	/** Atributo que modela la conexi�n con el panel de opciones */
	private PanelOpciones panelOpciones;
	
	/** Atributo que modela la conexi�n con el panel Tablero */
	private PanelTablero panelTablero;
	
	/** Atributo que modela la conexi�n con el panel de Imagen */
	private PanelImagen panelImagen;
	
	
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	/**
	 * Metodo constructor de la interfaz.
	 * <b> post: </b> Se inicializaron todos los atributos de la interfaz. <br>
	 */
	public InterfazElimiGemas()
	{
		elimiGemas = new ElimiGemas();
		panelOpciones = new PanelOpciones(this);
		panelTablero = new PanelTablero(this);
		panelImagen = new PanelImagen();
		
		setTitle( "ElimiGemas" );
		setBackground(new Color(100, 48, 1));
		setSize( 722, 700 );
	    setResizable( false );
	    setDefaultCloseOperation( EXIT_ON_CLOSE );
	    setLayout( new BorderLayout() );
	    
	    add(panelImagen, BorderLayout.NORTH);
	    add(panelTablero, BorderLayout.CENTER);
	    add(panelOpciones, BorderLayout.SOUTH);

	}
	
	
	// -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
	
	/**
	 * Metodo que carga un archivo de juego.
	 * <b> post: </b> Se carg� el archivo de juego.
	 */
	public void cargar()
	{
		 JFileChooser selector = new JFileChooser( "./data" );
	     selector.showOpenDialog( this );
	     File archivo = selector.getSelectedFile( );
	     if( archivo != null )
	     {
	    	 try
	    	 {
	    		 elimiGemas.cargar(archivo);
	    		 panelTablero.actualizar(elimiGemas);
	    	 }
	    	 catch( Exception e )
	    	 {
	    		 String ms = e.getMessage();
	    		 JOptionPane.showMessageDialog( this, ms, "Error", JOptionPane.INFORMATION_MESSAGE );
	    		 System.exit( 0 );
	    	 }
	     }

	}
	
	/**
	 * Metodo que mediante el clic realiza una jugada.
	 * <b> post: </b> Se realiz� una jugada.
	 * @param x numero de la fila en la que se encuentra el bot�n oprimido.
	 * @param y numero de la columna en la que se encuentra el bot�n oprimido.
	 */
	public void jugar(int x, int y)
	{
		try
		{
			elimiGemas.realizarJugada(x, y);		
			panelTablero.actualizar(elimiGemas);
		}
		catch (Exception e)
		{
			String ms = e.getMessage();
			JOptionPane.showMessageDialog(this, ms, "Hey!", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	/**
	 * Metodo que reinicia el tablero de juego.
	 * <b> post: </b> Se reinici� el tablero de juego.
	 */
	public void reiniciar()
	{
		try
		{
			elimiGemas.iniciarTablero();
			panelTablero.actualizar(elimiGemas);
		}
		catch (Exception e)
		{
			String ms = e.getMessage();
			JOptionPane.showMessageDialog(this, ms, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	 //-----------------------------------------------------------------
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = elimiGemas.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Ejecuta el punto de extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = elimiGemas.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

	
	//-----------------------------------------------------------------
    // Programa principal
    //-----------------------------------------------------------------

    /**
     * M�todo inicial
     * @param args Par�metros de entrada. No se requiere ninguno.
     */
    public static void main( String[] args )
    {
        InterfazElimiGemas elimiGemas = new InterfazElimiGemas( );
        elimiGemas.setVisible( true );
    }

}
