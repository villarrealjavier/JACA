package logicaJuego;

import java.util.ArrayList;
import java.util.HashMap;

import elementos.Coordenada;
import elementos.Element;
import elementos.ElementType;
import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;

public class Juego {

	private HashMap<Coordenada, Element> tablero;
	private ArrayList<Coordenada> coordenadaJugadores;
	private int jugadorJuega;
	private int dado;

	/**
	 * Constrcutor de juego en el que indicamos el tipo de personaje por parametro, después hacemos un bucle para comparar
	 * el numero de jugadores, es decir el contador, con el limite, y lo creamos hasta que se llegue a este limite. También llamamos en el contructor al metodo
	 * que se encarga de crear el tablero.
	 * @param personaje
	 */
	public Juego(PlayerType[] personaje) {
		super();
		int contador=0;
		coordenadaJugadores = new ArrayList<>();
		tablero = new HashMap<>();
		
		crearTablero();
		while(contador<Constantes.NUM_JUGADORES) {
			if(crearJugador(personaje[contador])==true) {
				contador++;
			}
		}
		
	}
	
	
	/**
	 * Metodo para crear a un jugador en el cual se le introduce por paramtero el tipo que es y a la hora de crearlo
	 * compruebo que la coordenada no este ocupada, si esta no lo está, lo creo
	 * @param tipo
	 * @return Devuelve un tipo booleano, el cual define si se ha podido crear o no.
	 */
	private boolean crearJugador(PlayerType tipo) {
		boolean crear = false;
		Jugador jugador = new Jugador(tipo);
		Coordenada coordenada = new Coordenada();
		while (coordenadaJugadores.contains(coordenada)) {
			coordenada = new Coordenada();
		}if(this.tablero.get(coordenada)==null) {
			coordenadaJugadores.add(coordenada);
			tablero.put(coordenada, jugador);
			crear = true;
		}
		
		
		return crear;
	}
	
	
	/**
	 * Creo el tablero al cual lo unico que hago es llamar a los demás metodos los cuales van a asignar tanto rocas, como gemas,etc
	 * en las coordenadas del tablero, para de esta manera tenerlo con todos los elementos creados.
	 * 
	 */
	private void crearTablero() {
		crearDinero();
		crearGemas();
		crearPociones();
		crearRocas();
	}
	
	/**
	 * Metodo para crear roca, el numero de rocas esta limitado por la constante NUM_ROCAS, para ello 
	 * creamos un elemento y una coordenada en la cual en el tablero comprobamos que el valor clave, es null
	 * si este es el null, le ponemos la coordenada creada y el elemento e incrementamos el contador, hasta que 
	 * el contador sea mayor que el limite.
	 * 
	 */
	private void crearRocas() {
		int contador = 0;
		while (contador < Constantes.NUM_ROCAS) {
			Coordenada coor1 = new Coordenada();
			Element e = new Element(ElementType.ROCA);
			if (tablero.get(coor1) == null) {
				this.tablero.put(coor1, e);
				contador++;
			}

		}
	}
	/**
	 * Metodo para crear dinero, hago un bucle en el cual incremento un contador, creo una coordenada y un elemento, 
	 * y si la coordenada obtenida mediante el get es null, la añado, si no, pues aumento el contador;
	 */
	private void crearDinero() {
		int contador = 0;
		while (contador < Constantes.NUM_DINERO) {
			Coordenada coordenada = new Coordenada();
			Element elemento = new Element(ElementType.DINERO);
			if (tablero.get(coordenada) == null) {
				this.tablero.put(coordenada, elemento);
				contador++;
			}

		}

	}
	/**
	 * Obtener elemento del tablero, se le pasa coordenada por parametro
	 * @param coord
	 * @return
	 */
	public Element obtenerElementoTablero(Coordenada coord) {
		return this.tablero.get(coord);
	}
	/**
	 * Obtener coordenada del jugador
	 * @return
	 */
	public Coordenada obtenerCoordenadaJugadorJuega() {
		return this.coordenadaJugadores.get(jugadorJuega);
	}
	
	/**
	 * Metodo para crear gemas, el numero de rocas esta limitado por la constante NUM_GEMAS, para ello 
	 * creamos un elemento y una coordenada en la cual en el tablero comprobamos que el valor clave, es null
	 * si este es el null, le ponemos la coordenada creada y el elemento e incrementamos el contador, hasta que 
	 * el contador sea mayor que el limite.
	 * 
	 */
	private void crearGemas() {
		int contador = 0;
		while (contador < Constantes.NUM_GEMAS) {
			Coordenada coor1 = new Coordenada();
			Element e = new Element(ElementType.GEMA);
			if (tablero.get(coor1) == null) {
				this.tablero.put(coor1, e);
				contador++;
			}

		}
	}
	/**
	 * Metodo para crear pociones, el numero de rocas esta limitado por la constante NUM_POCIONES, para ello 
	 * creamos un elemento y una coordenada en la cual en el tablero comprobamos que el valor clave, es null
	 * si este es el null, le ponemos la coordenada creada y el elemento e incrementamos el contador, hasta que 
	 * el contador sea mayor que el limite.
	 * 
	 */
	private void crearPociones() {
		int contador = 0;
		while (contador < Constantes.NUM_POCIONES) {
			Coordenada coor1 = new Coordenada();
			Element e = new Element(ElementType.POCION);
			if (tablero.get(coor1) == null) {
				this.tablero.put(coor1, e);
				contador++;
			}

		}
	}
	
/**
 * Metodo para terminar el juego, el cual recorre los elementos del tablero, y comprueba si el elemento es una estancia de jugador
 * y si lo es comprobamos si ha llegado al limite de dinero del juego el cual es 4, si es así acaba y ponemos la variable
 * a true. Si no lo posee pero la longitud de la coordenada es igual a 1, también acabariamos el juego, por lo cual lo pondriamos
 * a true.
 * @return terminar, variable booleana.
 */
	public boolean isTerminado() {
		boolean terminar = false;
		boolean dinero = false;
		for (Element elemento : this.tablero.values()) {
			if (elemento instanceof Jugador) {
				if (((Jugador) elemento).getDinero() == Constantes.DINERO) {
					dinero = true;
				}
			}
		}
	if (this.coordenadaJugadores.size() == 1 || dinero) {
		terminar = true;
		}
		return terminar;
	}
	/**
	 * Metodo para eliminar a un jugador
	 * @param coordenada
	 */
	private void eliminarJugador(Coordenada coordenada) {
		this.coordenadaJugadores.remove(coordenada);
		this.tablero.remove(coordenada);
	}

	/**
	 * Metodo para imprimir jugadores, el cual declaramos un StringBuilder que va a ser lo que retorne el método,
	 * recorremos las coordenadas que posee la Lista, despues creamos u  jugador  y le realizamos el casteo para poder
	 * obtener su nombre y metemos en el StringBuilder su nombre y el numero de jugador.
	 * @return Devuleve el StringBuilder.
	 */
	public String imprimeNombreJugadores() {
		int contador = 1;
		StringBuilder sb = new StringBuilder();
		
		for (Coordenada coordenada : this.coordenadaJugadores) {
		Jugador jugadores = (Jugador) tablero.get(coordenada);
			sb.append("El tipo del jugador es: " + jugadores.getNombre() + " y es el jugador numero: " + contador + "\n");
			contador++;
		}
		return sb.toString();
	}
	
	/**
	 * Obtener valor del dado
	 * @return
	 */
	public int getValorDado() {
		return dado;
	}
	/**
	 * Disminuye valor del dado
	 * @return
	 */
	public int decrementaDado() {
		return this.dado--;
	}
	
	/**
	 * Metodo para asignar valor del dado
	 */
	public void setDado() {
		this.dado = ((Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega))).getVelocidadParaLuchar();
	}
	
	
	/**
	 * Metodo el cual cambia al jugador de posicion, se le pasa por parametro una coordenada, acto seguido se elimina al 
	 * juagdor de la coordenada, y se actualiza cambiandolo de posicion, y se le vuelve a poner en el tablero.
	 * @param coordenada
	 */
	private void cambiaJugadorAPosicion(Coordenada coordenada) {
		Coordenada coor = coordenadaJugadores.get(jugadorJuega); 
		Jugador jug = (Jugador) tablero.get(coor);
		
		tablero.remove(coor); 
		coordenadaJugadores.remove(jugadorJuega); 
		coordenadaJugadores.add(jugadorJuega, coordenada); 
		tablero.put(coordenada, jug);
	}
	

	/**
	 * Metodo el cual imprime el valor de los elementos del jugadores, se realiza igual que el anterior solo que a este
	 * le sacamos los valores de los elementos del jugador.
	 * @return Devuelve un StringBuilder
	 */
	public String imprimeValoresJugadores() {
		int contador = 1;
		StringBuilder sb = new StringBuilder();
		
		for (Coordenada coordenada : this.coordenadaJugadores) {
			Jugador jugador = (Jugador) tablero.get(coordenada);
			sb.append("Jugador numero: " + contador 
						+ " Dinero: " + jugador.getDinero() 
						+ " Gemas: " + jugador.getGemas() 
						+ " Pociones: " + jugador.getPociones() + "\n");
			contador++;
		}
		return sb.toString();
	}
	
	/**
	 * Metodo para mover al jugador, se le pasa por parametro un caracter, en funcion de la direccion en la cual quiere ir,
	 * una vez que se le pasa se llama a los metodos correspondientes para la subida, bajada o desplazamiento hacia
	 * las direcciones correctas, si no, se lanza excepcion.
	 * @param direccion, Caracter
	 * @return
	 * @throws JuegoException
	 */
	private Coordenada getNextPosition (char direccion) throws JuegoException {
		if(direccion!='N' && direccion!='S' && direccion!='E' && direccion!='O') {
			throw new JuegoException("Error en la dirección.");
		}
		Coordenada coor;
		try {
			coor = coordenadaJugadores.get(jugadorJuega).clone();
			if(direccion=='N') {
				coor.goUp();
			}else if(direccion=='S') {
				coor.goDown();
			}else if(direccion=='E') {
				coor.goRight();
			}else {
				coor.goLeft();
			}
		} catch (CloneNotSupportedException e) {
			throw new JuegoException(e.getMessage());
		}
		return coor;
	}
	
	/**
	 * Escribe el tablero en formato no gráfico. Devuelve el string con la
	 * información
	 */
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		resul.append(barra());
		resul.append("     |");

		for (int fila = 0; fila < Constantes.TAMANNO; fila++) {
			for (int columna = 0; columna < Constantes.TAMANNO; columna++) {
				Coordenada coor = new Coordenada(columna, fila);

				if (this.tablero.get(coor) != null) {
					resul.append(" " + this.tablero.get(coor).getType().getSymbol() + " ");
				} else {
					resul.append("   ");
				}

				resul.append("|");
			}
			resul.append("\n");
			resul.append(barra());
			resul.append("     |");
		}
		resul.delete(resul.length() - 5, resul.length());
		return resul.toString();
	}
	
	public void proximoJugador() {
		if (this.jugadorJuega == Constantes.NUM_JUGADORES - 1) {
			this.jugadorJuega = 0;
		} else {
			jugadorJuega++;
		}
	}
	
	/**
	 * Metodo para obtener ganador
	 * @return
	 */
	public String getGanador() {
		StringBuilder resultado = new StringBuilder();
		if (this.coordenadaJugadores.size() == 1) {
			Jugador aux = (Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega));
			resultado.append(aux.toString());
		} else {
			for (Element siguiente : tablero.values()) {
				if (siguiente instanceof Jugador) {
					Jugador aux = ((Jugador) siguiente);
					if (aux.getDinero() == Constantes.NUM_DINERO) {
						resultado.append(aux);
					}
				}
			}
		}
		return resultado.toString();
	}

	/**
	 * Metodo para obtener el nombre del jugador
	 * @return
	 */
	public String getNombreJugadorQueJuega() {
		StringBuilder sb = new StringBuilder();
		Coordenada coor = this.coordenadaJugadores.get(jugadorJuega);
		
	
		Jugador jugador = (Jugador) this.tablero.get(coor);
		sb.append(jugador.getNombre());
		return sb.toString();
	}
	
	/**
	 * Obtener movimiento del jugador
	 * @return
	 */
	public int getMovimientoJugador() {
		Coordenada coor = this.coordenadaJugadores.get(jugadorJuega);
		Jugador jugador = (Jugador) this.tablero.get(coor);
		return jugador.getFuerzaParaLuchar();
	}
	

	/**
	 * Simplemente escribe una barra en pantalla
	 * 
	 * @return
	 */
	private String barra() {
		StringBuilder resul = new StringBuilder();
		resul.append("     ");
		for (int i = 0; i < Constantes.TAMANNO * 4; i++) {
			resul.append("-");
		}
		resul.append("\n");
		return resul.toString();
	}


	/**
	 * Mover el jugador
	 * 
	 * @param direction
	 * @return
	 * @throws JuegoException
	 * @throws JugadorException
	 */
	public String movePlayer(char direction) throws JuegoException, JugadorException {
		// Si no es una dirección válida, mando un exception
		String resul = "";
		Jugador jugador = (Jugador) this.tablero.get(this.coordenadaJugadores.get(jugadorJuega));

		Coordenada coordDestino = getNextPosition(direction);

		// Tengo que ver que hay en la nueva casilla
		Element elemento = this.tablero.get(coordDestino);

		if (elemento != null) { // Hay algo en la casilla
			if (elemento instanceof Jugador) {

				Jugador enemigo = (Jugador) elemento;
				int resultadoLucha = jugador.lucha(enemigo);
				switch (resultadoLucha) {
				case Constantes.EMPATE:
					resul = "Empate entre los jugadore";
					break;
				case Constantes.GANA_USA_POCIMA:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una pócima al enemigo";
					break;
				case Constantes.GANA_DINERO:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita el dinero al enemigo";
					break;
				case Constantes.GANA_MUERE:
					resul = "El jugador " + jugador.getNombre() + " gana. El enemigo muere";
					this.eliminarJugador(coordDestino);
					// Si se elimina el jugador que juega el dado se pone a 0 para que no siga
					// tirando
					break;
				case Constantes.PIERDE_USA_POCIMA:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una pócima al jugador";
					break;
				case Constantes.PIERDE_DINERO:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita el dinero al jugador";
					break;
				case Constantes.PIERDE_MUERE:
					resul = "El enemigo " + enemigo.getNombre() + " gana. El jugador muere";
					this.eliminarJugador(this.coordenadaJugadores.get(jugadorJuega));
					dado = 0;
					// Decrementamos en uno el jugador, para que no se salte al siguiente
					// ya que al borrarlo el siguiente apunta al siguiente, y al incrementarlo
					// se le salta
					this.jugadorJuega--;
					break;
				}
				// Después de la lucha los jugadores no se mueven
			} else if (elemento.getType() == ElementType.ROCA) {
				int resultadoRoca = jugador.encuentraRoca();
				switch (resultadoRoca) {
				case Constantes.ROMPE_ROCA_CON_GEMA:
					resul = "El jugador " + jugador.getNombre() + " rompe la roca con una gema";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.GANA_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " gana a la roca";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.PIERDE_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " pierde. No se mueve";
					break;
				}
			} else if (elemento.getType() == ElementType.GEMA) {
				jugador.encuentraGema();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.DINERO) {
				jugador.encuentraDinero();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.POCION) {
				jugador.encuentraPocion();
				this.cambiaJugadorAPosicion(coordDestino);

			}

		} else {
			this.cambiaJugadorAPosicion(coordDestino);
		}

		return resul;
	}

	
}
