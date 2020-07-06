package uniandes.cupi2.elimiGemas.mundo;

public class Gemas 
{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	/** Constante que modela el tipo de gema "Esmeralda". */
	public static final int ESMERALDA = 1;
	
	/** Constante que modela el tipo de gema "Rubi". */
	public static final int RUBI = 2;
	
	/** Constante que modela el tipo de gema "Diamante". */
	public static final int DIAMANTE = 3;
	
	/** Constante que modela la casilla vac�a. */
	public static final int VACIA = 4;
	
	
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
	/** Atributo que modela el tipo de Gema. */
	public int tipo;
	
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	/**
	 * Metodo constructor de la clase Gema
	 * @param nTipo Es el tipo de la gema que se va a construir.
	 */
	public Gemas(int nTipo)
	{
		tipo = nTipo;
	}
	
	
	// -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
	
	/**
	 * M�todo que retorna el tipo de gema.
	 * @param tipo Retorna el tipo de gema.
	 */
	public int darTipo()
	{
		return tipo;
	}
	
	/**
	 * M�todo que asigna como vac�a a determinada gema.
	 * <b> post: </b> Se asign� como vac�a la gema.<br> 
	 */
	public void asignarVacia()
	{
		if (darTipo() == ESMERALDA || darTipo() == DIAMANTE || darTipo() == RUBI)
		{
			tipo = VACIA;
		}
	}
	
	/**
	 * M�todo que asigna un nuevo tipo a una gema.
	 * <b> pre: </b> nTipo != null.<br> 
	 * <b> post: </b> Se asign� un nuevo tipo a la gema.<br> 
	 * @param nTipo tipo con el que se va a asignar la gema.
	 */
	public void asignarNuevoTipo(int nTipo)
	{
		tipo = nTipo;
	}

}
