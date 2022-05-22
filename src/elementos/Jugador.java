
package elementos;

import java.util.Random;

import logicaJuego.Constantes;

public class Jugador extends Element{
	//ATRIBUTOS
	private int dinero;
	private int pociones;
	private int gemas;
	private PlayerType jugador;
	Random random = new Random();

	//CONTRUCTOR
	public Jugador(PlayerType jugador) {
		super(ElementType.valueOf(jugador.name()));
		this.jugador = jugador;
		this.dinero = 0;
		this.gemas = 0;
		this.pociones = 0;
	}


	
	//GETTERS AND SETTERS
	public String getNombre() {
		return jugador.name();
	}

	private int getFuerza() {
		return jugador.getFuerza();
	}

	public int getFuerzaParaLuchar() {
		return random.nextInt(getFuerza());
	}

	private int getMagia() {
		return jugador.getMagia();
	}

	public int getMagiaParaLuchar() {
		return random.nextInt(getMagia());
	}

	private int getVelocidad() {
		return jugador.getVelocidad();
	}

	public int getVelocidadParaLuchar() {
		return random.nextInt(getVelocidad());
	}

	public int getDinero() {
		return dinero;
	}
	
	public void setDinero(int dinero) throws JugadorException {
		if (dinero < 0) {
			throw new JugadorException("Error. El dinero  no puede ser menor de 0");
		} else {
			this.dinero = dinero;
		}
	}

	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones) throws JugadorException {
		if (pociones < 0) {
			throw new JugadorException("Error. Las pociones no pueden ser negativas");
		} else {
			this.pociones = pociones;
		}
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) throws JugadorException {
		if (gemas < 0) {
			throw new JugadorException("Error. No pueden ser negativas");
		} else {
			this.gemas = gemas;
		}

	}

	public String resumen() {
		return "Nombre: " + this.getNombre()
				+ " Gemas: " + this.getGemas() 
				+ " Dinero: " + this.getDinero()
				+ " Pociones: " + this.getPociones();
	}

	public PlayerType getPlayer() {
		return jugador;
	}

		//METODOS A LA HORA DE ENCONTRAR GEMAS, DINEROS Y POCION (INCREMENTO)
	public void encuentraDinero() {
		this.dinero++;
	}
	

	public void encuentraPocion() {
		this.pociones++;
	}

	public void encuentraGema() {
		this.gemas++;
	}
	
	/**
	 * Metodo que se lleva a cabo a la hora de realizar la lucha entre los dos oponentes, si ambos tienen la 
	 * misma fuerza, quedará empate.
	 * Si el jugador1 posee mas fuerza que el jugador2, pero este posee pocimas, gana y se le disminuye 1 pocion,
	 * Si el rival, es decir, jugador2 posee dinero, ganará, si no tiene nada, ganará jugador 1.
	 * Si jugador 2 posee más fuerza que jugador 1, pasará lo mismo pero al contrario,es decir, con el jugador1.
	 * 
	 * @param rival
	 * @return resultado, valor del enumerado.
	 */
	public int lucha(Jugador rival) {
	int resultado;
	int fuerzaJ = this.getFuerzaParaLuchar();
	int fuerzaRival= rival.getFuerzaParaLuchar();
		if (fuerzaJ==fuerzaRival) {
			resultado=Constantes.EMPATE;
			
		}else if (fuerzaJ> fuerzaRival) {
			if (rival.getPociones() > 0) {
				rival.pociones--;
				resultado= Constantes.GANA_USA_POCIMA; //Gana el jugador y se utiliza pocima del enemigo para que no muera
				
			}else if (rival.getDinero()>0) {
				this.dinero+= rival.dinero;
				rival.dinero=0;
				resultado= Constantes.GANA_DINERO; //Gana el jugador y se lleva todo el dinero del enemigo
			}else {
				resultado=Constantes.GANA_MUERE; //Gana el jugador y el enemigo muer
				
			}
		}else {
			if (pociones>0) {
				pociones--;
				resultado=Constantes.PIERDE_USA_POCIMA; //Gana el enemigo y se utiliza pocima del jugador para que no muera
				
			}else if (dinero>0 ){
				rival.dinero+=this.dinero;
				this.dinero=0;
				resultado=Constantes.PIERDE_DINERO; //Gana el enemigo y se lleva todo el dinero del jugador
				
			}else {
				resultado= Constantes.PIERDE_MUERE; //Gana el enemigo y el jugador muere
			}
		}
		return resultado;
	}
	/**
	 * Metodo realizado para cuando el jugador se encuentra una roca, si el jugador posee gema, puede romper
	 * la roca con la gema y se le disminuye una gema al jugador. Si el jugador no posee gemas pero por el contrario
	 * tiene más de 4 de magia le gana a la roca, si esto no se cumple, el jugador  pierde.
	 * @return Devuelve  el resultado con el valor del enumerado.
	 */
	public int encuentraRoca() {
	int resultado;
		if(this.gemas>0) {
			resultado=Constantes.ROMPE_ROCA_CON_GEMA; //Rompe roca
			this.gemas--;
		}else {
			if (this.getMagia()>4) {
				resultado=Constantes.GANA_A_LA_ROCA; //Le gana a la roca
			}else {
				resultado=Constantes.PIERDE_A_LA_ROCA; //Pierde con la roca
			}
		}
		return resultado;
	}
	
}
