package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import elementos.PlayerType;
import logicaJuego.Constantes;
import logicaJuego.Juego;

class TestJuego {


	/**
	 * Mediante este test comprobamos que imprime de forma correcta, los valores de los jugadores.
	 */
	@Test
	void testImprimeValoresJugadores() {
		PlayerType[] jugadores = {PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO};
		Juego j1 = new Juego(jugadores);
		assertEquals(j1.imprimeValoresJugadores(),"Jugador numero: 1 Dinero: 0 Gemas: 0 Pociones: 0\n"
												+ "Jugador numero: 2 Dinero: 0 Gemas: 0 Pociones: 0\n"
												+ "Jugador numero: 3 Dinero: 0 Gemas: 0 Pociones: 0\n"
												+ "Jugador numero: 4 Dinero: 0 Gemas: 0 Pociones: 0\n");
}
	/**
	 * Igual que el test anterior, pero introduciendo un resultado mal y mediante un assertNoEquals nos aseguramos que
	 * el resultado no es ese.
	 */
	@Test
	void testImprimeValoresMal() {
		PlayerType[] players = {PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO};
		Juego j1 = new Juego(players);
		assertNotEquals(j1.imprimeValoresJugadores(),"Jugador numero: 1 Dinero: 1 Gemas: 0 Pociones: 0\n"
													+ "Jugador numero: 2 Dinero: 1 Gemas: 0 Pociones: 0\n"
													+ "Jugador numero: 3 Dinero: 1 Gemas: 0 Pociones: 0\n"
													+ "Jugador numero: 4 Dinero: 1 Gemas: 0 Pociones: 0\n");
	}
	/**
	 * Test para comprobar que es correcto el asignamiento del valor del dado, para ello creamos a los jugadores y el
	 * juego y le asignamos el dado, y mediante un assertTrue, se debe encontrar el valor del dado entre 1 y el limite
	 * del ELFO, que es el que mas movimiento puede tener
	 */
	
	@Test
	void testDadoCorrecto() {
		PlayerType[] players = {PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO};
		Juego j1 = new Juego(players);	
			j1.setDado();
			assertTrue(j1.getValorDado()>=1 && j1.getValorDado()<=Constantes.ELFO_VELOCIDAD);
		
	}
	
	/**
	 * Test que sirve para comprobar que el dado se ha decrementado, creamos una variable dado y le asignamos el valor del dado
	 * y llamamos al metodo decrementar dado.
	 */
	@Test
	void testDadoDecrementar() {
		PlayerType[] jugadores = {PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO};
		Juego juego = new Juego(jugadores);	
		juego.setDado();
		int dado = juego.getValorDado();
		juego.decrementaDado();
		assertEquals(dado-1, juego.getValorDado());
	}
	
	/**
	 * Mediante este test comprobamos que el resultado que esperamos no este incorrecto, para ello ponemos un resultado
	 * mal, y lo hacemos mediante assertNoEquals.
	 */
	@Test
	void testImprimeNombresMal() {
		PlayerType[] players = {PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO};
		Juego j1 = new Juego(players);
		
		assertNotEquals(j1.imprimeNombreJugadores(),"El tipo del jugador es: MAGO y es el jugador numero: 1\n"
													+ "El tipo del jugador es: GUERRERO y es el jugador numero: 2\n"
													+ "El tipo del jugador es: MAGO y es el jugador numero: 3\n"
													+ "El tipo del jugador es: OGRO y es el jugador numero: 4\n");
	}
	
	
	/**
	 * Test para comprobar imprimir los jugadores, lo realizamos mediante un assertEquals y lo igualamos al resultado esperado,
	 * este test debe estar correcto.
	 */
	@Test
	void testImprimeNombres() {
		PlayerType[] players = {PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO};
		Juego j1 = new Juego(players);
		assertEquals(j1.imprimeNombreJugadores(),"El tipo del jugador es: ELFO y es el jugador numero: 1\n"
													+ "El tipo del jugador es: GUERRERO y es el jugador numero: 2\n"
													+ "El tipo del jugador es: MAGO y es el jugador numero: 3\n"
													+ "El tipo del jugador es: OGRO y es el jugador numero: 4\n");
}
	
	
	/**
	 * Mediante este test comprobamos que nos devuelve el ultimo jugador.
	 */
	@Test
	void testUltimaPosicion() {
		PlayerType[] players = {PlayerType.GUERRERO, PlayerType.ELFO, PlayerType.OGRO, PlayerType.MAGO};
		Juego j1 = new Juego(players);
		
		j1.proximoJugador();
		j1.proximoJugador();
		j1.proximoJugador();		
		assertEquals(j1.getNombreJugadorQueJuega(),"MAGO");
	}
	/**
	 * Mediante este test, comprobamos que el resultado no es el esperado, y lo volvemos hacer mediante un assertNoEquals
	 */
		@Test
		void testUltimaPosicionMal() {
			PlayerType[] players = {PlayerType.GUERRERO, PlayerType.ELFO, PlayerType.MAGO, PlayerType.OGRO};
			Juego j1 = new Juego(players);
			j1.proximoJugador();
			j1.proximoJugador();
			j1.proximoJugador();		
			assertNotEquals( j1.getNombreJugadorQueJuega(),"MAGO");
		}
		
		/**
		 * Mediante este test, comprobamos que devuelve el primer jugador el cual hemos introducido.
		 */
		@Test
		void testJugadorPrimeraPosicion() {
			PlayerType[] jugadores = {PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO};
			Juego juego = new Juego(jugadores);
			assertEquals("ELFO", juego.getNombreJugadorQueJuega());
		}
		/**
		 * El test es correcto puesto que el primero es ELFO, no MAGO.
		 */
		@Test
		void testJugadorUltimaPrimeraPosicionMal() {
			PlayerType[] jugadores = {PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO};
			Juego juego = new Juego(jugadores);
			juego.proximoJugador();
			assertNotEquals("MAGO", juego.getNombreJugadorQueJuega());
		}
	
		
		
}
