package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;

class TestJugador {

	/**
	 * Creamos un jugador y introducimos los metodo de encontrar dinero, gemas y pociones y nos tendra que devolver
	 * 1, debido a que al principio empieza con 0.
	 */
	@Test
	void testJugadorEncuentra() {
		Jugador j1 = new Jugador(PlayerType.GUERRERO);
		j1.encuentraDinero();
		j1.encuentraGema();
		j1.encuentraPocion();
		assertTrue(j1.getDinero()==1 && j1.getGemas()==1 && j1.getPociones()==1 && j1.getNombre().equalsIgnoreCase("GUERRERO"));
}
	/**
	 * Creamos un jugador el cual no encuentra nada, ni le metemos los metodos y esto nos deberá devolver que todas sus
	 * pociones, gemas y dinero están a 0.
	 */
	@Test
	void testJugadorNoEncuentra() {
		Jugador j1 = new Jugador(PlayerType.GUERRERO);
	
		assertTrue(j1.getDinero()==0 && j1.getGemas()==0 && j1.getPociones()==0 && j1.getNombre().equalsIgnoreCase("GUERRERO"));
}
	/**
	 * Le metemos los metodos de encontrar al jugador e imprimimos su resumen y nos deberá salir tal y como se especifica
	 */
	@Test
	void testJugadorResumen() {
		Jugador j1 = new Jugador(PlayerType.GUERRERO);
		j1.encuentraDinero();
		j1.encuentraGema();
		j1.encuentraPocion();
		
		assertEquals("Nombre: GUERRERO Gemas: 1 Dinero: 1 Pociones: 1", j1.resumen());
}
	/**
	 * Igual que el anterior pero sin encontrar nada
	 */
	@Test
	void testJugadorResumenVacio() {
		Jugador j1 = new Jugador(PlayerType.GUERRERO);
		
		
		assertEquals("Nombre: GUERRERO Gemas: 0 Dinero: 0 Pociones: 0", j1.resumen());
}
	/**
	 * Le introducimos mediante el metodo setDinero una cantidad Incorrecta y este deberá capturar la excepcion.
	 */
	@Test
	void testJugadorDineroIncorrecto() {
		Jugador j1 = new Jugador(PlayerType.GUERRERO);
		try {
			j1.setDinero(-2000);
			assert(false);
		}catch(JugadorException e) {
			assert(true);
		}
	
}	/**
	 * Le introducimos mediante el metodo setGemas una cantidad Incorrecta y este deberá capturar la excepcion.
	 */
	@Test
	void testJugadorGemasIncorrecto() {
		Jugador j1 = new Jugador(PlayerType.GUERRERO);
		try {
			j1.setGemas(-2000);
			assert(false);
		}catch(JugadorException e) {
			assert(true);
		}
	
}	/**
	 * Le introducimos mediante el metodo setPociones una cantidad Incorrecta y este deberá capturar la excepcion.
	 */
	@Test
	void testJugadorPocionesIncorrecto() {
	Jugador j1 = new Jugador(PlayerType.GUERRERO);
	try {
		j1.setPociones(-2000);
		assert(false);
	}catch(JugadorException e) {
		assert(true);
	}

}
	/**
	 * Le introducimos mediante el metodo setDinero el valor de 1, y deberá devolver que el dinero obtenido es 1.
	 */
	@Test
	void testJugadorDinero() {
		Jugador j1 = new Jugador(PlayerType.GUERRERO);
		j1.setDinero(1);
			assertEquals(j1.getDinero(),1);
	
}
	/**
	 * Le introducimos mediante el metodo setGemas el valor de 1, y deberá devolver que el valor obtenido es 1.
	 */
	@Test
	void testJugadorGemas() {
		Jugador j1 = new Jugador(PlayerType.GUERRERO);
		j1.setGemas(1);
			assertEquals(j1.getGemas(),1);
	/**
	 * Le introducimos mediante el metodo setPociones el valor de 1, y deberá devolver que el valor obtenido es 1.
	 */
}	@Test
	void testJugadorPociones() {
	Jugador j1 = new Jugador(PlayerType.GUERRERO);
	j1.setPociones(1);
		assertEquals(j1.getPociones(),1);

}
	
	
	
	
	
}
