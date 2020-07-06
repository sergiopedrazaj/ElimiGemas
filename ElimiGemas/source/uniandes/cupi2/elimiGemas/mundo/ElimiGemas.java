package uniandes.cupi2.elimiGemas.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ElimiGemas 
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	/** Constante que modela el alto máximo de la matriz de gemas. */
	private static final int ALTO_MAXIMO = 7;
	
	/** Constante que modela el ancho máximo de la matriz de gemas. */
	private static final int ANCHO_MAXIMO = 10;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	/** Atributo que modela la matriz de gemas en el juego. */
	private Gemas[][] numeros;
	
	/** Atributo que modela el archivo persistencia. */
	Properties datosActuales;

	
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

	/**
	 * Metodo constructor de la clase ElimiGemas.
	 */
	public ElimiGemas()
	{
		numeros = new Gemas[ALTO_MAXIMO][ANCHO_MAXIMO];
	}
	
	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

	/**
	 * Metodo que permite cargar un archivo de juego.
	 * <b> post: </b> Se cargó el archivo de juego.<br> 
	 * @param archivo Archivo que se carga con la información del juego.
	 * @throws Exception Si el tipo de archivo es inválido lanza una excepción.
	 */
	public void cargar(File archivo) throws Exception 
	{
		datosActuales = new Properties();
		FileInputStream fis = new FileInputStream(archivo);
		try
		{
			datosActuales.load(fis);
			iniciarTablero();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("Tipo de archivo inválido.");
		}
	}
	
	/**
	 * Metodo que permite inicializar una tablero de juego.
	 * <b> post: </b> Se inicializó el tablero de juego. <br> 
	 * @throws Exception Si no hay cargado un archivo de juego, lanza una excepción.
	 */
	public void iniciarTablero() throws Exception
	{
		if (datosActuales != null)
		{
			for (int i = 0; i<ALTO_MAXIMO; i++)
			{
				String datos = datosActuales.getProperty("Fila"+i);
				String[] numerosFila = new String[ANCHO_MAXIMO];
				numerosFila = datos.split(",");
				for (int j = 0; j <ANCHO_MAXIMO; j++)
				{
					Gemas gemas = new Gemas(Integer.parseInt(numerosFila[j]));
					numeros[i][j] = gemas;
				}
			}
		}
		else
		{
			throw new Exception("¡Para reiniciar necesita cargar un tablero de juego!");
		}
		
	}
	
	/**
	 * Metodo que se usa para eliminar gemas adyacentes si la casilla seleccionada está en el borde superior.
	 * <b> pre: </b> La casilla seleccionada está en el borde superior. <br> 
	 * <b> post: </b> Se eliminaron las casillas adyancentes. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 */
	public void eliminarDesdeBordeSuperior(int x, int y)
	{
		int contar = 0;
		Gemas casillaSeleccionada = numeros[x][y];
		if (casillaSeleccionada.darTipo() == numeros[x][y-1].darTipo())
			{numeros[x][y-1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x+1][y-1].darTipo())
			{numeros[x+1][y-1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x+1][y].darTipo())
			{numeros[x+1][y].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x+1][y+1].darTipo())
			{numeros[x+1][y+1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x][y+1].darTipo())
			{numeros[x][y+1].asignarVacia(); contar++;}
		if (contar != 0)
		{
			casillaSeleccionada.asignarVacia();
		}

	}
	
	/**
	 * Metodo que retorna una gema dada su posición.
	 * <b> pre: </b> Los parámetros x y y son diferentes de "null". <br> 
	 * <b> post: </b> Se retornó la gema indicada. <br> 
	 * @param x Fila en la que se encuentra la gema.
	 * @param y Columna en la que se encuentra la gema.
	 * @return La gema segun la posición indicada.
	 */
	public Gemas darGema(int x, int y)
	{
		return numeros[x][y];
	}

	/**
	 * Metodo que se usa para eliminar gemas adyacentes si la casilla seleccionada está en el borde inferior.
	 * <b> pre: </b> La casilla seleccionada está en el borde inferior. <br> 
	 * <b> post: </b> Se eliminaron las casillas adyancentes. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 */
	public void eliminarDesdeBordeInferior(int x, int y)
	{
		int contar = 0;
		Gemas casillaSeleccionada = numeros[x][y];
			if (casillaSeleccionada.darTipo() == numeros[x][y-1].darTipo())
				{numeros[x][y-1].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x-1][y-1].darTipo())
				{numeros[x-1][y-1].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x-1][y].darTipo())
				{numeros[x-1][y].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x-1][y+1].darTipo())
				{numeros[x-1][y+1].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x][y+1].darTipo())
				{numeros[x][y+1].asignarVacia(); contar++;}
			if (contar != 0)
			{
				casillaSeleccionada.asignarVacia();
			}
	}

	/**
	 * Metodo que se usa para eliminar gemas adyacentes si la casilla seleccionada está en el borde izquierdo.
	 * <b> pre: </b> La casilla seleccionada está en el borde izquierdo. <br> 
	 * <b> post: </b> Se eliminaron las casillas adyancentes. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 */
	public void eliminarDesdeBordeIzquierdo(int x, int y)
	{
		int contar = 0;
		Gemas casillaSeleccionada = numeros[x][y];
		if (casillaSeleccionada.darTipo() == numeros[x-1][y].darTipo())
			{numeros[x-1][y].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x-1][y+1].darTipo())
			{numeros[x-1][y+1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x][y+1].darTipo())
			{numeros[x][y+1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x+1][y+1].darTipo())
			{numeros[x+1][y+1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x+1][y].darTipo())
			{numeros[x+1][y].asignarVacia(); contar++;}
		if (contar != 0)
		{
			casillaSeleccionada.asignarVacia();
		}
	}

	/**
	 * Metodo que se usa para eliminar gemas adyacentes si la casilla seleccionada está en el borde Derecho.
	 * <b> pre: </b> La casilla seleccionada está en el borde derecho. <br> 
	 * <b> post: </b> Se eliminaron las casillas adyancentes. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 */
	public void eliminarDesdeBordeDerecho(int x, int y)
	{
		int contar = 0;
		Gemas casillaSeleccionada = numeros[x][y];
		if (casillaSeleccionada.darTipo() == numeros[x-1][y].darTipo())
			{numeros[x-1][y].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x-1][y-1].darTipo())
			{numeros[x-1][y-1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x][y-1].darTipo())
			{numeros[x][y-1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x+1][y-1].darTipo())
			{numeros[x+1][y-1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x+1][y].darTipo())
			{numeros[x+1][y].asignarVacia(); contar++;}
		if (contar != 0)
		{
			casillaSeleccionada.asignarVacia();
		}
	}

	/**
	 * Metodo que se usa para eliminar gemas adyacentes.
	 * <b> post: </b> Se eliminaron las casillas adyancentes. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 */
	public void eliminarCasillasAdyacentes(int x, int y)
	{
		int contar = 0;
		Gemas casillaSeleccionada = numeros[x][y];
		if (casillaSeleccionada.darTipo() == numeros[x+1][y+1].darTipo()) 
			{numeros[x+1][y+1].asignarVacia(); contar++;} 
		if (casillaSeleccionada.darTipo() == numeros[x-1][y-1].darTipo()) 
			{numeros[x-1][y-1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x+1][y].darTipo())
			{numeros[x+1][y].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x-1][y].darTipo())
			{numeros[x-1][y].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x][y+1].darTipo())
			{numeros[x][y+1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x][y-1].darTipo())
			{numeros[x][y-1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x+1][y-1].darTipo())
			{numeros[x+1][y-1].asignarVacia(); contar++;}
		if (casillaSeleccionada.darTipo() == numeros[x-1][y+1].darTipo())
			{numeros[x-1][y+1].asignarVacia(); contar++;}
		if (contar != 0)
		{
			casillaSeleccionada.asignarVacia();
		}
	}
	
	/**
	 * Metodo que se usa para eliminar gemas adyacentes si la casilla seleccionada se encuentra en una de las esquinas.
	 * <b> pre: </b> La casilla seleccionada está en una de las esquinas. <br> 
	 * <b> post: </b> Se eliminaron las casillas adyancentes. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 */
	public void eliminarDesdeEsquinas(int x, int y)
	{
		int contar = 0;
		Gemas casillaSeleccionada = numeros[x][y];
		if (casillaSeleccionada == numeros[0][0])
		{
			if (casillaSeleccionada.darTipo() == numeros[x+1][y+1].darTipo()) 
				{numeros[x+1][y+1].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x+1][y].darTipo())
				{numeros[x+1][y].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x][y+1].darTipo())
				{numeros[x][y+1].asignarVacia(); contar++;}
		}
		else if(casillaSeleccionada == numeros[0][ANCHO_MAXIMO-1])
		{
			if (casillaSeleccionada.darTipo() == numeros[x+1][y-1].darTipo()) 
				{numeros[x+1][y-1].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x+1][y].darTipo())
				{numeros[x+1][y].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x][y-1].darTipo())
				{numeros[x][y-1].asignarVacia(); contar++;}				
		}
		else if (casillaSeleccionada == numeros[ALTO_MAXIMO-1][0])
		{
			if (casillaSeleccionada.darTipo() == numeros[x-1][y+1].darTipo()) 
				{numeros[x-1][y+1].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x-1][y].darTipo())
				{numeros[x-1][y].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x][y+1].darTipo())
				{numeros[x][y+1].asignarVacia(); contar++;}
		}
		else if (casillaSeleccionada == numeros[ALTO_MAXIMO-1][ANCHO_MAXIMO-1])
		{
			if (casillaSeleccionada.darTipo() == numeros[x-1][y-1].darTipo()) 
				{numeros[x-1][y-1].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x-1][y].darTipo())
				{numeros[x-1][y].asignarVacia(); contar++;}
			if (casillaSeleccionada.darTipo() == numeros[x][y-1].darTipo())
				{numeros[x][y-1].asignarVacia(); contar++;}
		}
		if (contar != 0)
		{
			casillaSeleccionada.asignarVacia();
		}
	}
	
	/**
	 * Metodo que indica si la casilla seleccionada está en una esquina.
	 * <b> pre: </b> Los parametros de entrada x y y son diferentes de "null". <br>
	 * <b> post: </b> La casilla seleccionada está o no en una esquina. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 * @return Retorna "true" si la casilla está en una esquina, de lo contrario "false".
	 */
	public boolean estaEnEsquina(int x, int y)
	{
		boolean estaEnEsquina = false;
		Gemas casillaSeleccionada = numeros[x][y];
		if (casillaSeleccionada == numeros[0][0] || casillaSeleccionada == numeros[0][ANCHO_MAXIMO-1] || casillaSeleccionada == numeros[ALTO_MAXIMO-1][0] || casillaSeleccionada == numeros[ALTO_MAXIMO-1][ANCHO_MAXIMO-1])
		{
			estaEnEsquina = true;
		}
		return estaEnEsquina;
	}
	
	/**
	 * Metodo que indica si la casilla seleccionada está en el borde izquierdo.
	 * <b> pre: </b> Los parametros de entrada x y y son diferentes de "null". <br>
	 * <b> post: </b> La casilla seleccionada está o no en el borde izquierdo. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 * @return Retorna "true" si la casilla está en el borde izquierdo, de lo contrario "false".
	 */
	public boolean estaEnBordeIzquierdo(int x, int y)
	{
		boolean estaEnBordeLateralIzquierdo = false;
		Gemas casillaSeleccionada = numeros[x][y];
		for (int i = 1; i < ALTO_MAXIMO-1 && !estaEnBordeLateralIzquierdo; i++ )
		{
			if (casillaSeleccionada == numeros[i][0])
			{
				estaEnBordeLateralIzquierdo = true;
			}			
		}
		return estaEnBordeLateralIzquierdo;
	}
	
	/**
	 * Metodo que indica si la casilla seleccionada está en el borde derecho.
	 * <b> pre: </b> Los parametros de entrada x y y son diferentes de "null". <br>
	 * <b> post: </b> La casilla seleccionada está o no en el borde derecho. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 * @return Retorna "true" si la casilla está en el borde derecho, de lo contrario "false".
	 */
	public boolean estaEnBordeDerecho(int x, int y)
	{
		boolean estaEnBordeLateralDerecho = false;
		Gemas casillaSeleccionada = numeros[x][y];
		for (int i = 1; i < ALTO_MAXIMO-1 && !estaEnBordeLateralDerecho; i++ )
		{
			if (casillaSeleccionada == numeros[i][ANCHO_MAXIMO-1])
			{
				estaEnBordeLateralDerecho = true;
			}			
		}
		return estaEnBordeLateralDerecho;
	}
	
	/**
	 * Metodo que indica si la casilla seleccionada está en el borde superior.
	 * <b> pre: </b> Los parametros de entrada x y y son diferentes de "null". <br>
	 * <b> post: </b> La casilla seleccionada está o no en el borde superior. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 * @return Retorna "true" si la casilla está en el borde superior, de lo contrario "false".
	 */
	public boolean estaEnBordeSuperior(int x, int y)
	{
		boolean estaEnBordeSuperior = false;
		Gemas casillaSeleccionada = numeros[x][y];
		for (int i = 1; i < ANCHO_MAXIMO-1 && !estaEnBordeSuperior; i++ )
		{
			if (casillaSeleccionada == numeros[0][i])
			{
				estaEnBordeSuperior = true;
			}
		}
		return estaEnBordeSuperior;
	}
	
	/**
	 * Metodo que indica si la casilla seleccionada está en el borde inferior.
	 * <b> pre: </b> Los parametros de entrada x y y son diferentes de "null". <br>
	 * <b> post: </b> La casilla seleccionada está o no en el borde inferior. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 * @return Retorna "true" si la casilla está en el borde inferior, de lo contrario "false".
	 */
	public boolean estaEnBordeInferior(int x, int y)
	{
		boolean estaEnBordeInferior = false;
		Gemas casillaSeleccionada = numeros[x][y];
		for (int i = 1; i < ANCHO_MAXIMO-1 && !estaEnBordeInferior; i++ )
		{
			if (casillaSeleccionada == numeros[ALTO_MAXIMO-1][i])
			{
				estaEnBordeInferior = true;
			}
		}
		return estaEnBordeInferior;
	}

	/**
	 * Metodo que hace caer una gema si la casilla debajo de esta está vacía.
	 * <b> post: </b> La casilla cayó a la posición inferior vacia. <br>
	 */
	public void hacerCaerGema()
	{
		for (int i = 0; i < ALTO_MAXIMO-1; i++)
		{
			for (int j = 0; j < ANCHO_MAXIMO; j++)
			{
				if (numeros [i][j].darTipo() != Gemas.VACIA)
				{
					if (numeros[i+1][j].darTipo() == Gemas.VACIA)
					{
						numeros[i+1][j].asignarNuevoTipo(numeros[i][j].darTipo());
						numeros[i][j].asignarVacia();
					}
				}
			}
		}
	}
	
	/**
	 * Metodo que indica si hay gemas por caer en el tablero, es decir si hay casillas vacías debajo de una gema.
	 * @return Retorna "true" si hay gemas por caer, de lo contrario "false".
	 */
	public boolean hayGemasPorCaer()
	{
		boolean siHay = false;
		for (int i = 0; i < ALTO_MAXIMO-1; i++)
		{
			for (int j = 0; j < ANCHO_MAXIMO; j++)
			{
				if (numeros [i][j].darTipo() != Gemas.VACIA)
				{
					if (numeros[i+1][j].darTipo() == Gemas.VACIA)
					{
						siHay = true;
					}
				}
			}
		}
		return siHay;
	}
		
	public boolean hayColumnasVacias()
	{	
		boolean siHay = false;
		for (int j = 0; j < ANCHO_MAXIMO && !siHay; j++)
		{
			int contador = 0;
			for (int i = 0; i < ALTO_MAXIMO; i++)
			{
				if (numeros[i][j].darTipo() == Gemas.VACIA)
				{
					contador++;
				}
			}
			if (contador == ALTO_MAXIMO)
			{
				siHay = true;
			}
		
		}
		return siHay;
	}
	
	public void moverColumnaCompleta()
	{
		for (int i = 0; i < ALTO_MAXIMO ; i++)
		{
			for (int j = 1; j < ALTO_MAXIMO; j++ )
			{
				if(numeros[i][j-1].darTipo() == Gemas.VACIA)
				{
					
				}
			}
		}
	}
	


	/**
	 * Metodo que realiza una jugada, basandose en las reglas de juego.
	 * <b> pre: </b> Los parametros de entrada x y y son diferentes de "null". <br>
	 * <b> post: </b> Se realizó una jugada. <br> 
	 * @param x Fila en la que se encuentra la casilla seleccionada.
	 * @param y Columna en la que se encuentra la casilla seleccionada.
	 * @throws Exception Si la casilla seleccionada está vacía retorna una excepción.
	 */
	
	public void realizarJugada(int x, int y) throws Exception
	{
		if (numeros[x][y].darTipo() != Gemas.VACIA)
		{
			if (estaEnBordeIzquierdo(x,y) == true)
			{
				eliminarDesdeBordeIzquierdo(x,y);
			}
			else if (estaEnBordeDerecho(x,y) == true)
			{
				eliminarDesdeBordeDerecho(x,y);
			}
			else if (estaEnBordeInferior(x,y) == true)
			{
				eliminarDesdeBordeInferior(x,y);
			}
			else if (estaEnBordeSuperior(x,y) == true)
			{
				eliminarDesdeBordeSuperior(x,y);
			}
			else if (estaEnEsquina(x,y) == true)
			{
				eliminarDesdeEsquinas(x,y);
			}
			else
			{
				eliminarCasillasAdyacentes(x,y);
			}
			while(hayGemasPorCaer() == true)
			{
				hacerCaerGema();
			}
	

		}
		else
		{
			throw new Exception("¡No puede seleccionar una casilla vacía!");
		}

	}
	

	/**
	 * Metodo de extensión 1.
	 * @return Mensaje del método 1.
	 */
	public String metodo1()
	{
		return "Respuesta 1";
	}
	
	/**
	 * Metodo de extensión 2.
	 * @return Mensaje del metodo 2.
	 */
	public String metodo2()
	{
		return "Respuesta 2";
	}
}
