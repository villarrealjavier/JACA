package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import elementos.Coordenada;

class TestCoordenada {

	/**
	 * Introducimos valores validos para crear la coordenada y se deberia asignar los valores correctamente, por cual
	 * debería ser tanto la X como la Y el valor 1.
	 */
	@Test
	void testCoor() {
		Coordenada coor = new Coordenada(1, 1);
		assertEquals(coor.getX(), 1);
		assertEquals(coor.getY(), 1);

	}
	/**
	 * Realizamos el test con valores tanto no validos positivos, como negativos, y no deberia asignarse, por lo cual 			
	 * deberia ser 0.
	 */
	@Test
	void testCoorFalsa() {
		Coordenada coor = new Coordenada(1000, 1000);
		Coordenada coor2 = new Coordenada(-1000, -1000);

		
		assertEquals(coor.getX(), 0);
		assertEquals(coor.getY(), 0);
		assertEquals(coor2.getX(), 0);
		assertEquals(coor2.getY(), 0);

	}
	
	/**
	 * Creamos una coordenada y le introducimos la coordenada 1,1, por lo cual nos deberia dejar movernos hacia arriba.
	 */
	@Test
	void testMoverArriba() {
		Coordenada coor = new Coordenada(1,1);
		
		assertEquals(coor.goUp(), true);

	}
	
	@Test
	void testNoMoverArriba() {
		Coordenada coor = new Coordenada(1,0);
		
		assertEquals(coor.goUp(), false);

	}
	
	/**
	 * Debe dejar movernos hacia abajo porque no estamos en el limite
	 */
	@Test
	void testMoverAbajo() {
		Coordenada coor = new Coordenada(1,7);
		
		assertEquals(coor.goDown(), true);

	}
	
	
	/**
	 * Introducimos los valores y al encontrarnos en el limite, no nos deberia dejar movernos hacia abajo
	 */
	@Test
	void testMoverAbajoMal() {
		Coordenada coor = new Coordenada(1,9);
		
		assertEquals(coor.goDown(), false);

	}
	
	/**
	 * Introducimos valores los cuales se encuentran en la mitad, nos tiene que permitir movernos.
	 */
	@Test
	void testMoverDerecha() {
		Coordenada coor = new Coordenada(5,5);
		
		assertEquals(coor.goRight(), true);

	}
	
	/**
	 * Establecemos valores en el limite, entonces no nos debe dejar movernos hacia la derecha
	 */
	@Test
	void testMoverDerechaMal() {
		Coordenada coor = new Coordenada(9,5);
		
		assertEquals(coor.goRight(), false);

	}
	
	/**
	 * Introducimos valores los cuales se encuentran en la mitad, nos tiene que permitir movernos.
	 */
	@Test
	void testMoverIzquierda() {
		Coordenada coor = new Coordenada(5,5);
		
		assertEquals(coor.goLeft(), true);

	}
	
	/**
	 * Establecemos valores en el limite, entonces no nos debe dejar movernos hacia la izquierda
	 */
	@Test
	void testMoverIzquierdaMal() {
		Coordenada coor = new Coordenada(0,5);
		
		assertEquals(coor.goLeft(), false);

	}
	
	
	
	

}
