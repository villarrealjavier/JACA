package logicaJuego;

import elementos.PlayerType;

public class MainPrueba {

	

	public static void main(String[] args) {
		Juego j1 = new Juego(PlayerType.values()) ;
		//System.out.println(j1.imprimeNombreJugadores());
			
			System.out.println(j1.imprimeValoresJugadores());
		

	}

}
